package paamelding;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaameldingPost")
public class PaameldingPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getSession().setAttribute("passord", passord);
		request.getSession().setAttribute("kjonn", kjonn);
		
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
		
		request.getSession().setAttribute("feil", feil);
		response.sendRedirect("PaameldingGet");
	}

}
