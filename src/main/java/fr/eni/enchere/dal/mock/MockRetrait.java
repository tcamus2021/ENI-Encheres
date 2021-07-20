package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DAOEniEnchere;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */
public class MockRetrait implements DAOEniEnchere<Retrait> {
	private List<Retrait> listeRetraits = new ArrayList<>();

	/**
	 * Ajoute un retrait à la liste
	 */
	@Override
	public void insert(Retrait retrait) {
		listeRetraits.add(retrait);
	}

	/**
	 * Récupère tous les retraits de la liste
	 */
	@Override
	public List<Retrait> getAll() {
		return listeRetraits;
	}

	/**
	 * Récupère un retrait par son identifiant
	 */
	@Override
	public Retrait getById(Integer id) {
		for (Retrait retrait : listeRetraits) {
			if (retrait.getIdRetrait() == id) {
				return retrait;
			}
		}
		return null;
	}

	/**
	 * Met à jour un retrait
	 */
	@Override
	public void update(Retrait t) {
	}

	/**
	 * Supprime un retrait
	 */
	@Override
	public void delete(Integer id) {
		listeRetraits.removeIf(c->c.getIdRetrait()==id);
	}
}
