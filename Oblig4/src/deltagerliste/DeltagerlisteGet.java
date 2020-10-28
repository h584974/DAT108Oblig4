package deltagerliste;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Festdeltager;
import database.FestdeltagerDAO;

@WebServlet("/DeltagerlisteGet")
public class DeltagerlisteGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FestdeltagerDAO festdeltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Festdeltager> festdeltagere = festdeltagerDAO.hentAlleFestdeltagere();
		request.setAttribute("festdeltagere", festdeltagere);
		request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
	}

}
