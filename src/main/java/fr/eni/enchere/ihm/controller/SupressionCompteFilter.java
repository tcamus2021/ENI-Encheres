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
import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet Filter implementation class SupressionCompteFilter
 */
@WebFilter("/accueil")
public class SupressionCompteFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SupressionCompteFilter() {
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
		if(request.getParameter("suppression-compte") != null) {
			try {
				Utilisateur aSupprimer = (Utilisateur) ((HttpServletRequest)request).getSession().getAttribute("login");
				BLLFactorySingl.createInstanceUtilisateur().delete(aSupprimer);
				((HttpServletRequest)request).getSession().invalidate();
			} catch (BLLexception e) {
				e.printStackTrace();
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
