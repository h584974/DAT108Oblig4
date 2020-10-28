package innlogging;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogginnFeil")
public class LogginnFeil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> feilmeldinger = Arrays.asList("Ugyldig brukernavn og/eller passord");
		request.setAttribute("feilmeldinger", feilmeldinger);
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

}
