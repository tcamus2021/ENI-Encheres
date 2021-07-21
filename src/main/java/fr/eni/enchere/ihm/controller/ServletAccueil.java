package fr.eni.enchere.ihm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bo.ArticleVendu;
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
		ModelArticleVendu model = new ModelArticleVendu();
		try {
			BLLFactorySingl.createInstanceVente().getAllArticleVendu();
		} catch (BLLexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
		// articles 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
