package fr.eni.enchere.ihm.model;

import fr.eni.enchere.bo.Utilisateur;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */
public class ModelUtilisateur {
	private Utilisateur utilisateur;

	/**
	 * Constructeur vide
	 */
	public ModelUtilisateur() {
	}

	/**
	 * Constructeur complet
	 * 
	 * @param utilisateur
	 */
	public ModelUtilisateur(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}

	/**
	 * Getter de l'utilisateur
	 * 
	 * @return
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * Setter de l'utilisateur
	 * 
	 * @param utilisateur
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "ModelUtilisateur [utilisateur=" + utilisateur + "]";
	}

}
