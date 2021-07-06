package fr.eni.enchere.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */
public class Utilisateur {

	private Integer noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private Integer codePostal;
	private String ville;
	private String motDePasse;
	private Integer credit;
	private Boolean administrateur;
	private List<ArticleVendu> listeArticlesVendus = new ArrayList<>();
	private List<Enchere> listeEncheres = new ArrayList<>();

	/**
	 * Constructeur vide
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * 
	 * Constructeur partiel
	 * 
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, Integer codePostal, String ville, String motDePasse, Integer credit, Boolean administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 * @param listeArticlesVendus
	 * @param listeEncheres
	 */
	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, Integer codePostal, String ville, String motDePasse, Integer credit, Boolean administrateur,
			List<ArticleVendu> listeArticlesVendus, List<Enchere> listeEncheres) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.listeArticlesVendus = listeArticlesVendus;
		this.listeEncheres = listeEncheres;
	}

	/**
	 * Getter du noUtilisateur
	 * 
	 * @return
	 */
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * Setter du noUtilisateur
	 * 
	 * @param noUtilisateur
	 */
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * Getter du pseudo
	 * 
	 * @return
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Setter du pseudo
	 * 
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Getter du nom
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter du nom
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter du prenom
	 * 
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter du prenom
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de l'email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de l'email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter du telephone
	 * 
	 * @return
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter du telephone
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de rue
	 * 
	 * @return
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter de rue
	 * 
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Getter du code postal
	 * 
	 * @return
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter du code Postal
	 * 
	 * @param codePostal
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter de la ville
	 * 
	 * @return
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter de la ville
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter du mot de passe
	 * 
	 * @return
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Setter du mot de passe
	 * 
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * Getter du credit
	 * 
	 * @return
	 */
	public Integer getCredit() {
		return credit;
	}

	/**
	 * Setter du credit
	 * 
	 * @param credit
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	/**
	 * Getter de l'admministrateur
	 * 
	 * @return
	 */
	public Boolean getAdministrateur() {
		return administrateur;
	}

	/**
	 * Setter de l'administrateur
	 * 
	 * @param administrateur
	 */
	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	/**
	 * Getter de la liste des articles vendus
	 * 
	 * @return
	 */
	public List<ArticleVendu> getListeArticlesVendus() {
		return listeArticlesVendus;
	}

	/**
	 * Setter de la liste des articles vendus
	 * 
	 * @param listeArticlesVendus
	 */
	public void setListeArticlesVendus(List<ArticleVendu> listeArticlesVendus) {
		this.listeArticlesVendus = listeArticlesVendus;
	}

	/**
	 * Ajout d'un article vendu
	 * 
	 * @param ArticleVendu
	 */
	public void addListeArticlesVendus(ArticleVendu articleVendu) {
		boolean trouver = false; // Booléen si un article de même numéro est trouvé dans la liste
		if (this.listeArticlesVendus.size() != 0) {
			for (ArticleVendu articleVenduForeach : listeArticlesVendus) {
				if (articleVenduForeach.getNoArticle() == articleVendu.getNoArticle()) { // La condition pour trouver le
																							// même numéro
					trouver = true;
				}
			}
		}
		if (!trouver) { // Si il n'a pas été trouvé on le met dans la liste
			articleVendu.setUtilisateur(this); // Ajout de l'utilisateur qu'on manipule dans l'objet ArticleVendu
			this.listeArticlesVendus.add(articleVendu);
		}
	}

	/**
	 * Getter de la liste des encheres
	 * 
	 * @return
	 */
	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}

	/**
	 * Setter de la liste des encheres
	 * 
	 * @param listeEncheres
	 */
	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}

	/**
	 * Ajout d'une enchere
	 * 
	 * @param enchere
	 */
	public void addListeEncheres(Enchere enchere) {
		boolean trouver = false;
		if (this.listeEncheres.size() != 0) {
			for (Enchere enchereForeach : this.listeEncheres) {
				if (enchereForeach.getDateEnchere().equals(enchere.getDateEnchere())) {
					trouver = true;
				}
			}
		}
		if (!trouver) {
			this.listeEncheres.add(enchere);
			enchere.setUtilisateur(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [noUtilisateur=");
		builder.append(noUtilisateur);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateur=");
		builder.append(administrateur);
		builder.append(", listeArticlesVendus=");
		builder.append(listeArticlesVendus);
		builder.append(", listeEncheres=");
		builder.append(listeEncheres);
		builder.append("]");
		return builder.toString();
	}

}
