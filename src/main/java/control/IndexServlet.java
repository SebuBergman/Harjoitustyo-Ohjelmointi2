package control;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ReseptipankkiDao;
import database.ReseptipankkiJdbcDao;
import model.Reseptipankki;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// haetaan reseptit tietokannasta
		ReseptipankkiDao reseptipankkidao = new ReseptipankkiJdbcDao();
		List<Reseptipankki> reseptit = reseptipankkidao.findAll();

		// resepti-lista .jsp:n saataville
		request.setAttribute("reseptit", reseptit);
		/*resp.getWriter().append(
				"<p>Web1-demo (Servlet, JSP, DB): <br>Kokeile endpointtia <a href='listaa-reseptit'>/listaa-reseptit</a> tai <a href='lisaa-resepti'>/lisaa-resepti</a></p>");
				*/
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}
