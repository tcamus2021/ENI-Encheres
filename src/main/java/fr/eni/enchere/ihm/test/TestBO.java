package fr.eni.enchere.ihm.test;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
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
		
		ArticleVendu a0 = new ArticleVendu();
		a0.setNoArticle(0);
		a0.setNomArticle("Pendule");
		a0.setDescription("BO PENDULE QUOI");
		a0.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
		a0.setDateFinEncheres(Date.valueOf(LocalDate.of(2021, 7, 8)));
		a0.setMiseAPrix(500);
		a0.setPrixVente(600);
		a0.setEtatVente("En cours");
		a0.setCategorieArticle(new Categorie(0, "Horlogerie", new ArrayList<>()));
		a0.setUtilisateur(rene);
		
		System.out.println("_________________Test lien d'articleVendu vers utilisateur____________________");
		System.out.println(rene.toString());
		System.out.println(a0.toString());
		
		ArticleVendu a1 = new ArticleVendu();
		a1.setNoArticle(1);
		a1.setNomArticle("Saucisson");
		a1.setDescription("Piment d'espelette");
		a1.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
		a1.setDateFinEncheres(Date.valueOf(LocalDate.of(2021, 7, 8)));
		a1.setMiseAPrix(1000);
		a1.setPrixVente(1500);
		a1.setEtatVente("Bientot");
		a1.setCategorieArticle(new Categorie(1, "Boucherie", new ArrayList<>()));
		
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
		robert.addListeArticlesVendus(a1);
		
		System.out.println("_________________Test lien d'utilisateur vers Articlevendu____________________");
		System.out.println(robert.toString());
		System.out.println(a1.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
