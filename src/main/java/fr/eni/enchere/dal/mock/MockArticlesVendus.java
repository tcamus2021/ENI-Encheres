package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.dal.DAOEniEnchere;

public class MockArticlesVendus implements DAOEniEnchere<ArticleVendu> {
	private List<ArticleVendu> listeArticlesVendus = new ArrayList<>();

	/**
	 * Ajoute un article vendu dans la liste des articles
	 * 
	 * @param articleVendu
	 */
	@Override
	public void insert(ArticleVendu articleVendu) {
		listeArticlesVendus.add(articleVendu);
	}

	/**
	 * Récupère tous les articles vendus de la liste
	 */
	@Override
	public List<ArticleVendu> getAll() {
		return listeArticlesVendus;
	}

	/**
	 * Récupère un article vendu par son identifiant
	 */
	@Override
	public ArticleVendu getById(Integer id) {
		for (ArticleVendu articleVendu : listeArticlesVendus) {
			if (articleVendu.getNoArticle() == id) {
				return articleVendu;
			}
		}
		return null;
	}

	/**
	 * Met un jour un article vendu
	 * 
	 * @param articleVendu
	 * @return
	 * @return
	 */
	@Override
	public void update(ArticleVendu articleVendu) {
	}

	/**
	 * Supprime un Article vendu
	 */
	@Override
	public void delete(Integer id) {
		listeArticlesVendus.removeIf(c -> c.getNoArticle() == id);
	}
}
