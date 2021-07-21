package fr.eni.enchere.ihm.model;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */

public class ModelArticleVendu {
	private List<ArticleVendu> articlesVendus = new ArrayList<>();

	/**
	 * Constructeur vide
	 */
	public ModelArticleVendu() {
	}
	
	/**
	 * Constructeur complet
	 * 
	 * @param articlesVendus
	 */

	public ModelArticleVendu(List<ArticleVendu> articlesVendus) {
		super();
		this.articlesVendus = articlesVendus;
	}

	/**
	 * Getter des articles vendus
	 * @return
	 */
	public List<ArticleVendu> getArticlesVendus() {
		return articlesVendus;
	}

	/**
	 * Setter des articles vendus
	 * @param articlesVendus
	 */
	public void setArticlesVendus(List<ArticleVendu> articlesVendus) {
		this.articlesVendus = articlesVendus;
	}

	@Override
	public String toString() {
		return "ModelArticleVendu [articlesVendus=" + articlesVendus + "]";
	}

}
