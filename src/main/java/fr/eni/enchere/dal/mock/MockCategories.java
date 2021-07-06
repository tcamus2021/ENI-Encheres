package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.DAOEniEnchere;

public class MockCategories implements DAOEniEnchere<Categorie> {
	private List<Categorie> listeCategories = new ArrayList<>();

	/**
	 * Ajoute une catégorie dans la liste
	 * 
	 * @param categorie
	 */
	@Override
	public void insert(Categorie categorie) {
		listeCategories.add(categorie);
	}

	/**
	 * Récupère toutes les catégories de la liste
	 */
	@Override
	public List<Categorie> getAll() {
		return listeCategories;
	}

	/**
	 * Récupère une catégorie par son identifiant
	 */
	@Override
	public Categorie getById(Integer id) {
		for (Categorie categorie : listeCategories) {
			if (categorie.getNoCategorie() == id) {
				return categorie;
			}
		}
		return null;
	}

	/**
	 * Met un jour une categorie
	 * 
	 * @param categorie
	 * @return
	 * @return
	 */
	@Override
	public void update(Categorie categorie) {
	}

	/**
	 * Supprime une catégorie
	 */
	@Override
	public void delete(Integer id) {
		listeCategories.removeIf(c -> c.getNoCategorie() == id);
	}
}
