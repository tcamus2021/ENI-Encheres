package fr.eni.enchere.ihm.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet Filter implementation class MiseAJourCompteFilter
 */
@WebFilter("/compte")
public class MiseAJourCompteFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MiseAJourCompteFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getParameter("modification-nom") != null) {
			try {
				Utilisateur miseAJour = new Utilisateur();
				Utilisateur utilisateurCourant = (Utilisateur)((HttpServletRequest)request).getSession().getAttribute("login");
				miseAJour.setNoUtilisateur(utilisateurCourant.getNoUtilisateur());
				miseAJour.setPseudo(request.getParameter("modification-pseudo"));
				miseAJour.setNom(request.getParameter("modification-nom"));
				miseAJour.setPrenom(request.getParameter("modification-prenom"));
				miseAJour.setEmail(request.getParameter("modification-email"));
				miseAJour.setTelephone(request.getParameter("modification-telephone"));
				miseAJour.setRue(request.getParameter("modification-rue"));
				miseAJour.setCodePostal(Integer.parseInt(request.getParameter("modification-code-postal")));
				miseAJour.setVille(request.getParameter("modification-ville"));
				miseAJour.setAdministrateur(false);
				miseAJour.setCredit(((Utilisateur)((HttpServletRequest)request).getSession().getAttribute("login")).getCredit());
				BLLFactorySingl.createInstanceUtilisateur().verifierInscription(
						utilisateurCourant.getPseudo(),
						request.getParameter("modification-password-actuel"));
				if(!request.getParameter("modification-password-nouveau").equals(request.getParameter("modification-password-confirmation"))) {
					throw new Exception();
				}
				if(!request.getParameter("modification-password-confirmation").equals("")) {
					miseAJour.setMotDePasse(((Integer)request.getParameter("modification-password-confirmation").hashCode()).toString());
				} else {
					miseAJour.setMotDePasse(((Integer)request.getParameter("modification-password-actuel").hashCode()).toString());
				}
				BLLFactorySingl.createInstanceUtilisateur().update(miseAJour);
				((HttpServletRequest)request).getSession().setAttribute("login", 
						BLLFactorySingl.createInstanceUtilisateur().getUtilisateurByPseudo(miseAJour.getPseudo()));
				chain.doFilter(request, response);
			} catch (Exception e) {
				request.setAttribute("erreur", "Erreur, veuillez vérifier vos champs et vos mot de passes.");
				request.getRequestDispatcher("/compte-modification").forward(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
