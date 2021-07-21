package fr.eni.enchere.ihm.model;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */

public class ModelCategorie {
	private List<Categorie> categories = new ArrayList<>();

	/**
	 * Constructeur vide
	 */
	public ModelCategorie() {
	}

	/*
	 * Constructeur complet
	 */
	public ModelCategorie(List<Categorie> categories) {
		super();
		this.categories = categories;
	}

	/**
	 * Gatter des categories
	 * 
	 * @return
	 */

	public List<Categorie> getCategories() {
		return categories;
	}

	/**
	 * Setter des articles vendus
	 * 
	 * @param categories
	 */
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "ModelCategorie [categories=" + categories + "]";
	}

}
