package fr.eni.enchere.ihm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.ihm.model.ModelArticleVendu;

/**
 * Servlet implementation class ServletAccueil
 */
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccueil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ModelArticleVendu model = new ModelArticleVendu();
			model.setArticlesVendus(BLLFactorySingl.createInstanceVente().getAllArticleVendu());
			request.setAttribute("model", model);
		} catch (BLLexception e) {
			request.setAttribute("erreur", "Erreur dans le chargement de la page");
		} finally {
			request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
