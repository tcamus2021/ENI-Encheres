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

/**
 * Servlet Filter implementation class FilterAccesPageModeConnecter
 */
@WebFilter({ "/compte-modification", "/vente-creation", "/vente" })
public class FilterAccesPageModeConnecter implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterAccesPageModeConnecter() {
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
		if (((HttpServletRequest) request).getSession().getAttribute("login") != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/accueil").forward(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
