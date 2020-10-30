package deltagerliste;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Festdeltager;
import database.FestdeltagerDAO;

@WebServlet("/Deltagerliste")
public class DeltagerlisteGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FestdeltagerDAO festdeltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Festdeltager> festdeltagere = festdeltagerDAO.hentAlleFestdeltagere();
		Cookie innlogget = null;
		
		try {
			innlogget = Arrays.stream(request.getCookies()).filter(c -> c.getName().equalsIgnoreCase("brukernavn")).findAny().get();
		}
		catch(NoSuchElementException e) {}
		
		if(innlogget == null) {
			response.sendRedirect("PaameldingGet");
		}
		else {
			if(festdeltagere != null && !festdeltagere.isEmpty()) {
				festdeltagere.sort(new Comparator<Festdeltager>() {
					@Override
					public int compare(Festdeltager f1, Festdeltager f2) {
						int c1 = f1.getFornavn().compareTo(f2.getEtternavn());
						return c1 == 0 ? f1.getEtternavn().compareTo(f2.getEtternavn()) : c1;
					}
				});
			}
			
			request.setAttribute("brukernavn", innlogget.getValue());
			request.setAttribute("festdeltagere", festdeltagere);
			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		}
	}

}
