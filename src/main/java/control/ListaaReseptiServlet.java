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

@WebServlet("/listaa-resepti")
public class ListaaReseptiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idStr = request.getParameter("reseptiid");
		int reseptiId = Integer.parseInt(idStr);
		// haetaan reseptit tietokannasta
		ReseptipankkiDao reseptipankkidao = new ReseptipankkiJdbcDao();
		Reseptipankki reseptipankki = new Reseptipankki();
		
		List<Reseptipankki> reseptit = reseptipankkidao.findByID(reseptiId);

		// resepti-lista .jsp:n saataville
		request.setAttribute("reseptit", reseptit);
		// pyynnön eteenpäinlähetys reseptipankki.jsp:lle
		request.getRequestDispatcher("/WEB-INF/reseptipankki_resepti.jsp").forward(request, response);

	}

}
