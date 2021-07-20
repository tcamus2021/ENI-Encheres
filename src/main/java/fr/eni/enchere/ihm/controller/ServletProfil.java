package fr.eni.enchere.ihm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProfil
 */
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher nextPage = null;
		if(request.getAttribute("user") == null) { // TODO Attribut pour gérer si c'est notre profil ou non
			if(request.getSession().getAttribute("login") != null) {
				request.setAttribute("utilisateurVoulu", request.getSession().getAttribute("login"));
				request.setAttribute("monProfil", true);
				nextPage = request.getRequestDispatcher("WEB-INF/profil.jsp");
			} else {
				nextPage = request.getRequestDispatcher("WEB-INF/accueil.jsp");
			}
		} else { // Cas où ce n'est pas notre profil
			request.setAttribute("monProfil", false);
			request.setAttribute("utilisateurVoulu", request.getAttribute("user"));
			nextPage = request.getRequestDispatcher("WEB-INF/profil.jsp");
		}
		nextPage.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
