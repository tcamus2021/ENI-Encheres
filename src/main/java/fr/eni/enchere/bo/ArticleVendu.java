package fr.eni.enchere.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author tcamus2021 rguezennec2021
 *
 */
public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	private String lienImage;
	private Utilisateur utilisateur;
	private Categorie categorieArticle;
	private Retrait lieuRetrait;
	private List<Enchere> listeEnchere = new ArrayList<>();

	/**
	 * Constructeur complet
	 * 
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param utilisateur
	 * @param categorieArticle
	 * @param lieuRetrait
	 * @param listeEnchere
	 * @param lien
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente, Utilisateur utilisateur,
			Categorie categorieArticle, Retrait lieuRetrait, List<Enchere> listeEnchere, String lien) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.utilisateur = utilisateur;
		this.categorieArticle = categorieArticle;
		this.lieuRetrait = lieuRetrait;
		this.listeEnchere = listeEnchere;
		this.lienImage = lien;
	}

	/**
	 * Constructeur vide
	 */
	public ArticleVendu() {
	}

	/**
	 * Getter id de l'article
	 * 
	 * @return
	 */
	public Integer getNoArticle() {
		return noArticle;
	}

	/**
	 * Setter de l'id de l'article
	 * 
	 * @param noArticle
	 */
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * Getter du nom
	 * 
	 * @return
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * Setter du nom
	 * 
	 * @param nomArticle
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * Getter de la description
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter de la description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter du commencement
	 * 
	 * @return
	 */
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	/**
	 * Setter du commencement
	 * 
	 * @param dateDebutEncheres
	 */
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	/**
	 * Getter de la fin
	 * 
	 * @return
	 */
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	/**
	 * Setter de la fin
	 * 
	 * @param dateFinEncheres
	 */
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	/**
	 * Getter de la mise ?? prix
	 * 
	 * @return
	 */
	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	/**
	 * Setter de la mise ?? prix
	 * 
	 * @param miseAPrix
	 */
	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	/**
	 * Getter du prix de vente
	 * 
	 * @return
	 */
	public Integer getPrixVente() {
		return prixVente;
	}

	/**
	 * Setter du prix de vente
	 * 
	 * @param prixVente
	 */
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	/**
	 * Getter de l'etat de la vente
	 * 
	 * @return
	 */
	public String getEtatVente() {
		return etatVente;
	}

	/**
	 * Setter de l'??tat de la vente
	 * 
	 * @param etatVente
	 */
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
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

	/**
	 * Getter de la cat??gorie
	 * 
	 * @return
	 */
	public Categorie getCategorieArticle() {
		return categorieArticle;
	}

	/**
	 * Setter de la cat??gorie
	 * 
	 * @param categorieArticle
	 */
	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	/**
	 * Gette du lieu de retrait
	 * 
	 * @return
	 */
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	/**
	 * Setter du lieu de retrait
	 * 
	 * @param lieuRetrait
	 */
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	/**
	 * Getter des ench??res
	 * 
	 * @return
	 */
	public List<Enchere> getListeEnchere() {
		return listeEnchere;
	}

	/**
	 * Setter des encheres
	 * 
	 * @param listeEnchere
	 */
	public void setListeEnchere(List<Enchere> listeEnchere) {
		this.listeEnchere = listeEnchere;
	}

	/**
	 * Getter lien de l'image
	 * 
	 * @return
	 */
	public String getLienImage() {
		return lienImage;
	}

	/**
	 * Setter lien de l'image
	 * 
	 * @param lienImage
	 */
	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}

	/**
	 * Ajout d'une ench??re
	 * 
	 * @param enchere
	 */
	public void addListeEnchere(Enchere enchere) {
		this.listeEnchere.add(enchere);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEncheres=");
		builder.append(dateDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append(", lienImage=");
		builder.append(lienImage);
		builder.append(", utilisateur=");
		builder.append(utilisateur.getPseudo());
		builder.append(", categorieArticle=");
		builder.append(categorieArticle.getLibelle());
		builder.append(", lieuRetrait=");
		builder.append(lieuRetrait.getRue());
		builder.append(", listeEnchere=");
		builder.append(listeEnchere);
		builder.append("]");
		return builder.toString();
	}

}
