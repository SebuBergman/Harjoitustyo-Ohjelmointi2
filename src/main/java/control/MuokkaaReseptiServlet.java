package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ReseptipankkiDao;
import database.ReseptipankkiJdbcDao;
import model.Reseptipankki;

@WebServlet("/muokkaa-resepti")
public class MuokkaaReseptiServlet extends HttpServlet  {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		// hae reseptiId ja muut muuttujat
		int reseptiID = Integer.parseInt(request.getParameter("reseptiid"));
		String annoksia = request.getParameter("annoksia");
		String reseptinimi = request.getParameter("reseptinimi");
		String valmistusAika = request.getParameter("valmistusAika");
		String ainesosat = request.getParameter("ainesosat");
		String ohje = request.getParameter("ohje");
		// käytä reseptiId ja lue tietokannan resepti tiedot id perusteella
		Reseptipankki reseptipankki = new Reseptipankki();
		reseptipankki.setReseptiId(reseptiID);
		reseptipankki.setAnnoksia(annoksia);
		reseptipankki.setReseptiNimi(reseptinimi);
		reseptipankki.setValmistusAika(valmistusAika);
		reseptipankki.setAinesosat(ainesosat);
		reseptipankki.setOhje(ohje);
		*/
		
		request.getRequestDispatcher("/WEB-INF/reseptimuokkauslomake.jsp").forward(request, response);
	}
	
		//Vastaanottaa tietoa selaimelta
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			// Pyydetään lomakkeella syötetyn resepti tiedot request-oliolta
			try {
				int reseptiId = Integer.parseInt(request.getParameter("reseptiid")); // id
				String annoksia = request.getParameter("annoksia"); // nimi
				String reseptiNimi = request.getParameter("reseptiNimi"); // kuvaus
				String valmistusAika = request.getParameter("valmistusAika"); //valmistusaika
				String ainesosat = request.getParameter("ainesosat"); //ainesosat
				String ohje = request.getParameter("ohje"); //ohje

				// Luodaan uusi Resepti-luokan olio edellisillä parametreillä
				Reseptipankki reseptipankki = new Reseptipankki(reseptiId ,annoksia, reseptiNimi, valmistusAika, ainesosat, ohje);
				System.out.println("Resepti: " + reseptipankki.toString());

				ReseptipankkiDao reseptipankkidao = new ReseptipankkiJdbcDao();
				// tallennetaan tiedot tietokantaan
				boolean lisaysOnnistui = reseptipankkidao.muokkaaResepti(reseptipankki);
				if (lisaysOnnistui)
					// uudelleenohjaus /listaa-resepti osoitteeseen .jps-käsittelyn sijaan
					response.sendRedirect("/listaa-reseptit");
				else {

					request.setAttribute("viesti", "Resepti-lomakkeella syötetyt tiedot eivät olleet kelvolliset.");
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
