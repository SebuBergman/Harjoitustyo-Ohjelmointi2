package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ReseptipankkiDao;
import database.ReseptipankkiJdbcDao;

@WebServlet("/poista-resepti")
public class PoistaReseptiServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// Sijoitetaan muuttujaan pyynnön parametrina tullut poistettavan reseptin
			String idStr = request.getParameter("reseptiid");
			int reseptiId = Integer.parseInt(idStr);
			// Luodaan reseptipankkidao olio
			ReseptipankkiDao reseptipankkidao = new ReseptipankkiJdbcDao();
			// Poistetaan resepti tietokannasta
			boolean poistoOnnistui = reseptipankkidao.removeResepti(reseptiId);
			if (poistoOnnistui) {
				// uudelleenohjataan pyyntö /listaa-reseptit osoitteeseen
				response.sendRedirect("/listaa-reseptit");
			} else {
				request.setAttribute("viesti", "Reseptin poistossa tapahtui virhe.");
				// servlet kutsuu jsp:tä
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe,");
			// servlet kutsuu jsp:tä
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
	}
}