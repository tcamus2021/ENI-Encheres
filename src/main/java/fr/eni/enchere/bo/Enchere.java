package fr.eni.enchere.bo;

import java.util.Date;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */

public class Enchere {
	private Date dateEnchere;
	private Integer montantEnchere;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;

	/**
	 * Constructeur vide
	 */
	public Enchere() {
		super();
	}

	/**
	 * Constructeur complet
	 * 
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param utilisateur
	 * @param articleVendu
	 */
	public Enchere(Date dateEnchere, Integer montantEnchere, Utilisateur utilisateur, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}

	/**
	 * Getter de la date de l'enchère
	 * 
	 * @return
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * Setter de la date de l'enchère
	 * 
	 * @param dateEnchere
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * Getter du montant de l'enchère
	 * 
	 * @return
	 */
	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * Setter du montant de l'enchère
	 * 
	 * @param montantEnchere
	 */
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * Getter de l'utilisteur
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

	/**
	 * Getter d'un article vendu
	 * 
	 * @return
	 */
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	/**
	 * Setter d'un article vendu
	 * 
	 * @param articleVendu
	 */
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montantEnchere=");
		builder.append(montantEnchere);
		builder.append(", utilisateur=");
		builder.append(utilisateur.getNom());
		builder.append(", articleVendu=");
		builder.append(articleVendu);
		builder.append("]");
		return builder.toString();
	}

}
