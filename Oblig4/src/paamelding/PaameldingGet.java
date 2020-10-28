package paamelding;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Festdeltager;
import database.FestdeltagerDAO;

@WebServlet("/PaameldingGet")
public class PaameldingGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FestdeltagerDAO festdeltagerDAO;

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
			String fornavn = (String)request.getSession().getAttribute("fornavn");
			String etternavn = (String)request.getSession().getAttribute("etternavn");
			Integer mobil = Integer.parseInt((String)request.getSession().getAttribute("mobil"));
			String passord = (String)request.getSession().getAttribute("passord");
			String kjonn = (String)request.getSession().getAttribute("kjonn");
			Festdeltager nyFestdeltager = new Festdeltager(fornavn,etternavn,mobil,passord,kjonn);
			festdeltagerDAO.lagreFestdeltager(nyFestdeltager);
			request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
		}
	}

}
