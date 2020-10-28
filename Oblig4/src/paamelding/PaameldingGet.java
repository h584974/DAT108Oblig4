package paamelding;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaameldingGet")
public class PaameldingGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean feil = true;
		
		try {
			feil = (Boolean)request.getSession().getAttribute("feil");
		}
		catch(Throwable e) {}
		
		if(feil) {
			request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
		}
	}

}