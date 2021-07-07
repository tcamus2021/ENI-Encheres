package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DAOEniEnchere;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */
public class MockEncheres implements DAOEniEnchere<Enchere> {
	private List<Enchere> listeEncheres = new ArrayList<>();

	/**
	 * Ajoute une enchère dans la liste
	 * 
	 * @param enchere
	 */
	@Override
	public void insert(Enchere enchere) {
		listeEncheres.add(enchere);
	}

	/**
	 * Récupère toutes les enchères de la liste
	 *
	 */
	@Override
	public List<Enchere> getAll() {
		return listeEncheres;
	}

	/**
	 * Récupère une enchère par son identifiant
	 */
	@Override
	public Enchere getById(Integer id) {
		for (Enchere enchere : listeEncheres) {
			if (enchere.getIdEnchere() == id) {
				return enchere;
			}
		}
		return null;
	}

	/**
	 * Met à jour une enchère
	 * 
	 * @param enchere
	 * @return
	 * @return
	 */
	@Override
	public void update(Enchere enchere) {
	}

	/**
	 * Supprime une enchère
	 */
	@Override
	public void delete(Integer id) {
		listeEncheres.removeIf(c -> c.getIdEnchere() == id);
	}
}
