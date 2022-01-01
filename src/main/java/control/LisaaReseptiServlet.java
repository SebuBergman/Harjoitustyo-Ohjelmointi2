package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ReseptipankkiDao;
import database.ReseptipankkiJdbcDao;
import model.Reseptipankki;

@WebServlet("/lisaa-resepti")
public class LisaaReseptiServlet extends HttpServlet {

	/*
	 * Lähettää selaimelle reseptin tiedot lisäyslomakkeen
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/reseptilisayslomake.jsp").forward(request, response);
	}

	//Vastaanottaa tietoa selaimelta
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Pyydetään lomakkeella syötetyn resepti tiedot request-oliolta

		try {
			String annoksia = request.getParameter("annoksia"); // nimi
			String reseptiNimi = request.getParameter("reseptiNimi"); // kuvaus
			String valmistusAika = request.getParameter("valmistusAika");
			String ainesosat = request.getParameter("ainesosat");
			String ohje = request.getParameter("ohje");

			// Luodaan uusi Resepti-luokan olio edellisillä parametreillä
			Reseptipankki reseptipankki = new Reseptipankki(annoksia, reseptiNimi, valmistusAika, ainesosat, ohje);
			System.out.println("Resepti: " + reseptipankki.toString());

			ReseptipankkiDao reseptipankkidao = new ReseptipankkiJdbcDao();
			// tallennetaan tiedot tietokantaan
			boolean lisaysOnnistui = reseptipankkidao.addResepti(reseptipankki);
			if (lisaysOnnistui)
				// uudelleenohjaus /listaa-resepti osoitteeseen .jps-käsittelyn sijaan
				response.sendRedirect("/lisaa-resepti");
			else {

				request.setAttribute("viesti", "Reseptin lisäyksessä tietokantaan tapahtui virhe.");
				// servlet kutsuu jsp:tä
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {

			e.printStackTrace(); // tulostetaan Consoleen virhetilanteessa metodikutsupinoa

			request.setAttribute("viesti", "Resepti-lomakkeella syötetyt tiedot eivät olleet kelvolliset.");
			// servlet kutsuu jsp:tä
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
	}
}