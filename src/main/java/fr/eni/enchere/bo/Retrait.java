package fr.eni.enchere.bo;

/**
 * 
 * @author tcamus2021 rguezennec2021
 *
 */
public class Retrait {
	private Integer idRetrait;
	private String rue;
	private Integer codePostal;
	private String ville;
	private ArticleVendu article;

	/**
	 * Constructeur complet
	 * 
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param article
	 */
	public Retrait(String rue, Integer codePostal, String ville, ArticleVendu article) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}

	/**
	 * Constructeur vide
	 */
	public Retrait() {
	}

	/**
	 * Getter rue
	 * 
	 * @return
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter rue
	 * 
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Getter code postal
	 * 
	 * @return
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter code postal
	 * 
	 * @param codePostal
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter ville
	 * 
	 * @return
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter ville
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter Article
	 * 
	 * @return
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * Setter Article
	 * 
	 * @param article
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	/**
	 * Getter de l'id
	 * 
	 * @return
	 */
	public Integer getIdRetrait() {
		return idRetrait;
	}

	/**
	 * Setter de l'id
	 * 
	 * @param idRetrait
	 */
	public void setIdRetrait(Integer idRetrait) {
		this.idRetrait = idRetrait;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [idRetrait=");
		builder.append(idRetrait);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", article=");
		builder.append(article.getNomArticle());
		builder.append("]");
		return builder.toString();
	}

}
