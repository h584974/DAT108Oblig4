package innlogging;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Festdeltager;
import database.FestdeltagerDAO;
import validering.BCrypt;
import validering.Validator;

@WebServlet("/LogginnPost")
public class LogginnPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FestdeltagerDAO festdeltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		boolean logginn = false;
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		Festdeltager fd = null;
		
		if(Validator.validerMobil(mobil) && Validator.validerPassord(passord)) {
			fd = festdeltagerDAO.hentFestdeltager(Integer.parseInt(mobil));
		}
		
		if(fd != null) {
			logginn = BCrypt.checkpw(passord, fd.getPassord());
		}
		
		if(logginn) {
			Cookie innlogget = new Cookie("brukernavn",mobil);
			innlogget.setMaxAge(300);
			response.addCookie(innlogget);
			response.sendRedirect("Deltagerliste");
		}
		else {
			request.getSession().setAttribute("feil", "true");
			response.sendRedirect("Logginn");
		}
	}

}