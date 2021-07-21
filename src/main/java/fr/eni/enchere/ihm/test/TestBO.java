package fr.eni.enchere.ihm.test;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class TestBO
 */
@WebServlet("/TestBO")
public class TestBO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestBO() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("_________________Test BO____________________");

		// Déclarations objets
		Utilisateur rene = new Utilisateur();
		rene.setNoUtilisateur(0);
		rene.setPseudo("Xx_Rene_Du_24XX");
		rene.setNom("Mallard");
		rene.setPrenom("René");
		rene.setEmail("rene@mail.fr");
		rene.setTelephone("0617513524");
		rene.setRue("32 Rue des agenêts");
		rene.setCodePostal(44000);
		rene.setVille("Nantes");
		rene.setMotDePasse("ReneLPB");
		rene.setCredit(150);
		rene.setAdministrateur(false);

		ArticleVendu article0 = new ArticleVendu();
		article0.setNoArticle(0);
		article0.setNomArticle("Pendule");
		article0.setDescription("BO PENDULE QUOI");
		article0.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
		article0.setDateFinEncheres(Date.valueOf(LocalDate.of(2021, 7, 8)));
		article0.setMiseAPrix(500);
		article0.setPrixVente(600);
		article0.setEtatVente("En cours");

		Categorie horlogerie = new Categorie();
		horlogerie.setNoCategorie(0);
		horlogerie.setLibelle("Horlogerie");

		Categorie boucherie = new Categorie();
		boucherie.setNoCategorie(1);
		boucherie.setLibelle("Boucherie");

		Retrait retrait0 = new Retrait();
		retrait0.setIdRetrait(0);
		retrait0.setRue("25 Grande rue");
		retrait0.setCodePostal(29542);
		retrait0.setVille("Paris");

		Enchere enchere0 = new Enchere();
		enchere0.setIdEnchere(0);
		enchere0.setMontantEnchere(1600);
		enchere0.setDateEnchere(Date.valueOf(LocalDate.of(2022, 7, 6)));

		Enchere enchere1 = new Enchere();
		enchere1.setIdEnchere(1);
		enchere1.setMontantEnchere(1700);
		enchere1.setDateEnchere(Date.valueOf(LocalDate.now()));

		
		// Comment lier les objets

		// Lien entre catégorie et article
		article0.setCategorieArticle(boucherie);
		boucherie.addArticleVendu(article0);

		// Lien entre article et enchère
		article0.setLieuRetrait(retrait0);
		retrait0.setArticle(article0);

		// Lien entre article et utilisateur
		article0.setUtilisateur(rene);
		rene.addListeArticlesVendus(article0);

		// Lien enchère article et utilisateur
		enchere0.setUtilisateur(rene);
		enchere0.setArticleVendu(article0);
		rene.addListeEncheres(enchere0);
		article0.addListeEnchere(enchere0);

		// Nouveau lien enchère article et utilisateur
		enchere1.setUtilisateur(rene);
		enchere1.setArticleVendu(article0);
		rene.addListeEncheres(enchere1);
		article0.addListeEnchere(enchere1);

		System.out.println(enchere0.toString());
		System.out.println(enchere1.toString());
		System.out.println(article0.toString());
		System.out.println(rene.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
