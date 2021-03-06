package fr.eni.enchere.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tcamus2021 rguezennec2021
 *
 */
public class Categorie {
	private Integer noCategorie;
	private String libelle;
	private List<ArticleVendu> listeArticleVendu = new ArrayList<>();

	/**
	 * Constructeur complet
	 * 
	 * @param noCategorie
	 * @param libelle
	 * @param listeArticleVendu
	 */
	public Categorie(Integer noCategorie, String libelle, List<ArticleVendu> listeArticleVendu) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.listeArticleVendu = listeArticleVendu;
	}

	/**
	 * Constructeur vide
	 */
	public Categorie() {
		super();
	}

	/**
	 * Getter id catégorie
	 * 
	 * @return
	 */
	public Integer getNoCategorie() {
		return noCategorie;
	}

	/**
	 * Setter id catégorie
	 * 
	 * @param noCategorie
	 */
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	/**
	 * Getter libelle
	 * 
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter libelle
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter liste des articles vendus
	 * 
	 * @return
	 */
	public List<ArticleVendu> getListeArticleVendu() {
		return listeArticleVendu;
	}

	/**
	 * Setter liste des articles vendus
	 * 
	 * @param listeArticleVendu
	 */
	public void setListeArticleVendu(List<ArticleVendu> listeArticleVendu) {
		this.listeArticleVendu = listeArticleVendu;
	}

	/**
	 * Ajout d'un article vendu
	 * 
	 * @param articleVendu
	 */
	public void addArticleVendu(ArticleVendu articleVendu) {
		this.listeArticleVendu.add(articleVendu);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", listeArticleVendu=");
		builder.append(listeArticleVendu);
		builder.append("]");
		return builder.toString();
	}

}
