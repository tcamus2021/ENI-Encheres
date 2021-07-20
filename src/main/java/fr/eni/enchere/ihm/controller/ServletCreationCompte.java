package fr.eni.enchere.ihm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bll.BLLexception;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("create-pseudo") != null) {
			if (!request.getParameter("create-motDePasse").equals(request.getParameter("create-motDePasse-verif"))) {
				request.setAttribute("erreur", "Mot de passe incorrect");
				request.getRequestDispatcher("/WEB-INF/creationcompte.jsp").forward(request, response);
			} else {
				try {
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setPseudo(request.getParameter("create-pseudo"));
					utilisateur.setNom(request.getParameter("create-nom"));
					utilisateur.setPrenom(request.getParameter("create-prenom"));
					utilisateur.setEmail(request.getParameter("create-email"));
					utilisateur.setTelephone(request.getParameter("create-telephone"));
					utilisateur.setRue(request.getParameter("create-rue"));
					utilisateur.setCodePostal(Integer.parseInt(request.getParameter("create-code-postal")));
					utilisateur.setVille(request.getParameter("create-ville"));
					utilisateur.setMotDePasse(request.getParameter("create-motDePasse"));
					utilisateur.setAdministrateur(false);

					BLLFactorySingl.createInstanceUtilisateur().inscription(utilisateur);

					Utilisateur utilisateurAvecId = BLLFactorySingl.createInstanceUtilisateur()
							.getUtilisateurByPseudo(utilisateur.getPseudo());

					((HttpServletRequest) request).getSession().setAttribute("login", utilisateurAvecId);

					request.getRequestDispatcher("/accueil").forward(request, response);
				} catch (BLLexception e) {
					request.setAttribute("erreur", e.getMessage());
					request.getRequestDispatcher("/WEB-INF/creationcompte.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("erreur", "Veuillez vérifier vos champs");
					request.getRequestDispatcher("/WEB-INF/creationcompte.jsp").forward(request, response);
				}
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/creationcompte.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
