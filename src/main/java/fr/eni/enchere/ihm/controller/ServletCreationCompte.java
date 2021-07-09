package fr.eni.enchere.ihm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletCreationCompte
 */
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreationCompte() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("create-name") != null) {
			try {
				Utilisateur utilisateur = new Utilisateur();
				
				BLLFactorySingl.createInstanceUtilisateur().inscription(utilisateur);
				
				Utilisateur utilisateurAvecId = BLLFactorySingl.createInstanceUtilisateur()
						.getUtilisateurByPseudo(utilisateur.getPseudo());
				
				((HttpServletRequest) request).getSession().setAttribute("login", utilisateurAvecId);
				
				request.getRequestDispatcher("/accueil").forward(request, response);
			} catch (Exception e) {
				
			}
		} else {
			request.getRequestDispatcher("WEB-INF/creationcompte").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
