package fr.eni.enchere.ihm.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet Filter implementation class CreationArticleFilter
 */
@WebFilter("/accueil")
public class CreationArticleFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CreationArticleFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request.getParameter("creation-vente-article") == null) {
			chain.doFilter(request, response);
		} else {
			try {
				ArticleVendu article = new ArticleVendu();
				article.setNomArticle(request.getParameter("creation-vente-article"));

				Categorie categorie = new Categorie();
				switch ((String) request.getParameter("creation-vente-categorie")) {
				case "1":
					categorie.setNoCategorie(1);
					categorie.setLibelle("Informatique");
					break;
				case "2":
					categorie.setNoCategorie(2);
					categorie.setLibelle("Ameublement");
					break;
				case "3":
					categorie.setNoCategorie(3);
					categorie.setLibelle("Vêtement");
					break;
				case "4":
					categorie.setNoCategorie(4);
					categorie.setLibelle("Sport & Loisirs");
					break;
				}

				article.setCategorieArticle(categorie);
				article.setDescription(request.getParameter("creation-vente-description"));
				article.setDateDebutEncheres(Date.valueOf(request.getParameter("creation-vente-date-debut")));
				article.setDateFinEncheres(Date.valueOf(request.getParameter("creation-vente-date-fin")));
				// TODO add image
				article.setLienImage("/WEB-INF/img/default.png");
				article.setMiseAPrix(Integer.parseInt(request.getParameter("creation-vente-prix")));
				article.setPrixVente(Integer.parseInt(request.getParameter("creation-vente-prix")));
				

				Retrait retrait = new Retrait();
				if(!request.getParameter("creation-vente-ville").equals("") && !request.getParameter("creation-vente-cp").equals("")
						&& !request.getParameter("creation-vente-rue").equals("")) {
					retrait.setRue(request.getParameter("creation-vente-rue"));
					retrait.setCodePostal(Integer.parseInt(request.getParameter("creation-vente-cp")));
					retrait.setVille(request.getParameter("creation-vente-ville"));
				} else {
					retrait.setRue(((Utilisateur)((HttpServletRequest)request).getSession().getAttribute("login")).getRue());
					retrait.setCodePostal(((Utilisateur)((HttpServletRequest)request).getSession().getAttribute("login")).getCodePostal());
					retrait.setVille(((Utilisateur)((HttpServletRequest)request).getSession().getAttribute("login")).getVille());
				}
				
				article.setLieuRetrait(retrait);
				
				article.setUtilisateur(((Utilisateur)((HttpServletRequest)request).getSession().getAttribute("login")));
				
				BLLFactorySingl.createInstanceVente().vendre(article);

				chain.doFilter(request, response);
			} catch (BLLexception e) {
				request.setAttribute("erreur", e.getMessage());
				request.getRequestDispatcher("/vente-creation").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("erreur", "Erreur, veuillez vérifier vos champs");
				request.getRequestDispatcher("/vente-creation").forward(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
