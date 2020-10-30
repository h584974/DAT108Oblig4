package paamelding;

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
import validering.Validator;

@WebServlet("/PaameldingPost")
public class PaameldingPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FestdeltagerDAO festdeltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		String passordRepetert = request.getParameter("passordRepetert");
		String kjonn = request.getParameter("kjonn");
		
		request.getSession().invalidate();
		
		request.getSession().setAttribute("fornavn", fornavn);
		request.getSession().setAttribute("etternavn", etternavn);
		request.getSession().setAttribute("mobil", mobil);
		
		Boolean feil = false;
		
		if(!Validator.validerFornavn(fornavn)) {
			request.getSession().setAttribute("fornavnFeilmelding", "Ugyldig fornavn");
			feil = true;
		}
		
		if(!Validator.validerEtternavn(etternavn)) {
			request.getSession().setAttribute("etternavnFeilmelding", "Ugyldig etternavn");
			feil = true;
		}
		
		if(!Validator.validerMobil(mobil)) {
			request.getSession().setAttribute("mobilFeilmelding", "Ugyldig mobilnummer");
			feil = true;
		}
		
		if(!Validator.validerPassord(passord)) {
			request.getSession().setAttribute("passordFeilmelding", "Ugyldig passord");
			feil = true;
		}
		
		if(!Validator.validerPassordRepetert(passordRepetert, passord)) {
			request.getSession().setAttribute("passordrepetertFeilmelding", "Passord m&aring; v&aelig;re like");
			feil = true;
		}
		
		if(!Validator.validerKjonn(kjonn)) {
			request.getSession().setAttribute("kjonnFeilmelding", "Må velge kj&oslash;nn");
			feil = true;
		}
		
		if(!feil) {
			Festdeltager nyFestdeltager = new Festdeltager(fornavn,etternavn,Integer.parseInt(mobil),passord,kjonn);
			
			try {
				festdeltagerDAO.lagreFestdeltager(nyFestdeltager);
				Cookie innlogget = new Cookie("brukernavn",mobil);
				innlogget.setMaxAge(300);
				response.addCookie(innlogget);
			}
			catch(Throwable e) {
				feil = true;
				request.getSession().setAttribute("mobilFeilmelding", "Deltager med dette nummeret er allerede registrert");
			}
		}
		
		request.getSession().setAttribute("feil", feil);
		response.sendRedirect("Paameldingsskjema");
	}

}
