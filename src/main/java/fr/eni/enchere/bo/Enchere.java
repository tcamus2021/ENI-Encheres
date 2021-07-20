package fr.eni.enchere.bo;

import java.util.Date;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */

public class Enchere {
	private Integer idEnchere;
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
		if (this.utilisateur == null) {
			this.utilisateur = utilisateur;
			this.utilisateur.addListeEncheres(this);
		}
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
		if (this.articleVendu == null) {
			this.articleVendu = articleVendu;
			this.articleVendu.addListeEnchere(this);
		}
	}

	/**
	 * Getter de l'id
	 * 
	 * @return
	 */
	public Integer getIdEnchere() {
		return idEnchere;
	}

	/**
	 * Setter de l'id
	 * 
	 * @param idEnchere
	 */
	public void setIdEnchere(Integer idEnchere) {
		this.idEnchere = idEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [idEnchere=" + idEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", utilisateur=" + utilisateur.getPrenom() + ", articleVendu=" + articleVendu + "]"; //TODO
	}

}
