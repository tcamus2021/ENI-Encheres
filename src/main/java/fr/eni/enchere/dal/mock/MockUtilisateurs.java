package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOEniEnchere;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */
public class MockUtilisateurs implements DAOEniEnchere<Utilisateur>{
	private List<Utilisateur>listeUtilisateurs = new ArrayList<>();
	
	/**
	 * Ajoute un utilisateur dans la liste
	 */
	@Override
	public void insert(Utilisateur utilisateur) {
		listeUtilisateurs.add(utilisateur);
	}

	/**
	 * Recupère tous les utilisateurs de la liste
	 */
	@Override
	public List<Utilisateur> getAll() {
		return listeUtilisateurs;
	}

	/**
	 * Récupère un utilisateur par son identifiant 
	 */
	@Override
	public Utilisateur getById(Integer id) {
		for (Utilisateur utilisateur : listeUtilisateurs) {
			if(utilisateur.getNoUtilisateur()== id);
			return utilisateur;
		}
		return null;
	}

	/**
	 * Met à jour un utilisateur
	 */
	@Override
	public void update(Utilisateur t) {
		// TODO Auto-generated method stub	
	}

	/**
	 * Supprime un utilisateur
	 */
	@Override
	public void delete(Integer id) {
		listeUtilisateurs.removeIf(c->c.getNoUtilisateur()==id);	
	}
}
