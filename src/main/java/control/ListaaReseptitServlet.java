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

@WebServlet("/listaa-reseptit")
public class ListaaReseptitServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// haetaan reseptit tietokannasta
		ReseptipankkiDao reseptipankkidao = new ReseptipankkiJdbcDao();
		List<Reseptipankki> reseptit = reseptipankkidao.findAll();

		// resepti-lista .jsp:n saataville
		request.setAttribute("reseptit", reseptit);
		// pyynnön eteenpäinlähetys reseptipankki.jsp:lle
		request.getRequestDispatcher("/WEB-INF/reseptipankki.jsp").forward(request, response);

	}

}
