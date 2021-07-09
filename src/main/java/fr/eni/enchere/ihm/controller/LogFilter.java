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
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/connexion")
public class LogFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LogFilter() {
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
		if (request.getParameter("login-name") != null) { // Cas de connexion
			try {
				BLLFactorySingl.createInstanceUtilisateur().verifierInscription(request.getParameter("login-name"),
						request.getParameter("login-password"));

				Utilisateur utilisateur = BLLFactorySingl.createInstanceUtilisateur()
						.getUtilisateurByPseudo(request.getParameter("login-name"));
				((HttpServletRequest) request).getSession().setAttribute("login", utilisateur);

				chain.doFilter(request, response);
			} catch (Exception e) {
				request.setAttribute("erreur", e.getMessage());
				request.getRequestDispatcher("/connexion").forward(request, response);
			}
		} else if (((HttpServletRequest) request).getSession().getAttribute("login") != null){
			chain.doFilter(request, response);
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
