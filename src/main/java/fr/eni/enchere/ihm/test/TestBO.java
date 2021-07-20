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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("_________________Test lien d'articleVendu vers utilisateur____________________");
		
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
		article0.setUtilisateur(rene);
		
		System.out.println(rene.toString());
		System.out.println(article0.toString());
		
		System.out.println("_________________Test lien d'utilisateur vers Articlevendu____________________");
		
		ArticleVendu article1 = new ArticleVendu();
		article1.setNoArticle(1);
		article1.setNomArticle("Saucisson");
		article1.setDescription("Piment d'espelette");
		article1.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
		article1.setDateFinEncheres(Date.valueOf(LocalDate.of(2021, 7, 8)));
		article1.setMiseAPrix(1000);
		article1.setPrixVente(1500);
		article1.setEtatVente("Bientot");
		
		Utilisateur robert = new Utilisateur();
		robert.setNoUtilisateur(1);
		robert.setPseudo("Xx_Robert_Du_24XX");
		robert.setNom("Mallard");
		robert.setPrenom("Robert");
		robert.setEmail("robert@mail.fr");
		robert.setTelephone("0617513524");
		robert.setRue("32 Rue des agenêts");
		robert.setCodePostal(44000);
		robert.setVille("Nantes");
		robert.setMotDePasse("RobertLPB");
		robert.setCredit(200);
		robert.setAdministrateur(false);
		robert.addListeArticlesVendus(article1);
		
		System.out.println(robert.toString());
		System.out.println(article1.toString());

		
		System.out.println("_________________Test lien Utilisateur Encheres____________________");
		
		Enchere enchere0 = new Enchere();
		enchere0.setIdEnchere(0);
		enchere0.setMontantEnchere(1600);
		enchere0.setDateEnchere(Date.valueOf(LocalDate.of(2022, 7, 6)));
		enchere0.setUtilisateur(rene);
		
		
		Enchere enchere1 = new Enchere();
		enchere1.setIdEnchere(1);
		enchere1.setMontantEnchere(1700);
		enchere1.setDateEnchere(Date.valueOf(LocalDate.now()));
		robert.addListeEncheres(enchere1);
		
		System.out.println(enchere1.toString());
		System.out.println(rene.getPrenom() + " " + rene.getListeEncheres());
		System.out.println(robert.getPrenom() + " " +  robert.getListeEncheres());
		

		System.out.println("_________________Test lien ArticleVendu et enchere____________________");
		
		enchere0.setArticleVendu(article0);
		article1.addListeEnchere(enchere1);
		
		System.out.println(enchere0);
		System.out.println(enchere1);
		System.out.println(article0.getNomArticle() + " " + article0.getListeEnchere());
		System.out.println(article1.getNomArticle() + " " + article1.getListeEnchere());

		System.out.println("_________________Test lien ArticleVendu et retrait____________________");
		
		Retrait retrait0 = new Retrait();
		retrait0.setIdRetrait(0);
		retrait0.setRue("25 Grande rue");
		retrait0.setCodePostal(29542);
		retrait0.setVille("Paris");
		
		Retrait retrait1 = new Retrait();
		retrait1.setIdRetrait(1);
		retrait1.setRue("32 Petite rue");
		retrait1.setCodePostal(46542);
		retrait1.setVille("Morlaix");
		
		retrait0.setArticle(article0);
		article1.setLieuRetrait(retrait1);
		
		System.out.println(retrait0);
		System.out.println(retrait1);
		System.out.println(article0);
		System.out.println(article1);

		System.out.println("_________________Test lien ArticleVendu et Catégorie____________________");
		
		Categorie horlogerie = new Categorie();
		horlogerie.setNoCategorie(0);
		horlogerie.setLibelle("Horlogerie");
		
		Categorie boucherie = new Categorie();
		boucherie.setNoCategorie(1);
		boucherie.setLibelle("Boucherie");
		
		article0.setCategorieArticle(horlogerie);
		boucherie.addArticleVendu(article1);
		
		System.out.println(horlogerie);
		System.out.println(boucherie);
		System.out.println(article0);
		System.out.println(article1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
