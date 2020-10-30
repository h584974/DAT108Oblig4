package innlogging;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logginn
 */
@WebServlet("/Logginn")
public class Logginn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String feil = (String)request.getSession().getAttribute("feil");
		
		if(feil != null) {
			request.getSession().invalidate();
			List<String> feilmeldinger = Arrays.asList("Ugyldig brukernavn og/eller passord");
			request.setAttribute("feilmeldinger", feilmeldinger);
		}
		
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

}