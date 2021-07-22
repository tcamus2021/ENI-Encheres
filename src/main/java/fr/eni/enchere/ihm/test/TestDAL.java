package fr.eni.enchere.ihm.test;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;

/**
 * Servlet implementation class TestDAL
 */
@WebServlet("/TestDAL")
public class TestDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDAL() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("_________________Test DAO Utilisateur____________________");

			Utilisateur rene = new Utilisateur();
			rene.setPseudo("Xx_Rene_Du_24XX");
			rene.setNom("Mallard");
			rene.setPrenom("René");
			rene.setEmail("rene@mail.fr");
			rene.setTelephone("0617513524");
			rene.setRue("32 Rue des agenêts");
			rene.setCodePostal(44000);
			rene.setVille("Nantes");
			rene.setMotDePasse("ReneLPB");
			rene.setCredit(500);
			rene.setAdministrateur(false);

//			DAOFactory.getDaoUtilisateurs().insert(rene);

			Utilisateur robert = new Utilisateur();
			robert.setPseudo("Xx_Robert_Du_24XX");
			robert.setNom("Le suisse");
			robert.setPrenom("Robert");
			robert.setEmail("robert@mail.fr");
			robert.setTelephone("0784859565");
			robert.setRue("87 Rue des agenêts");
			robert.setCodePostal(29000);
			robert.setVille("Paris");
			robert.setMotDePasse("Robert");
			robert.setCredit(500);
			robert.setAdministrateur(false);
			
	

//			System.out.println(DAOFactory.getDaoUtilisateurs().getById(1));

//			DAOFactory.getDaoUtilisateurs().insert(robert);
//
//			System.out.println(DAOFactory.getDaoUtilisateurs().getAll());
//
//			DAOFactory.getDaoUtilisateurs().delete(1);
//
//			Utilisateur rene2 = DAOFactory.getDaoUtilisateurs().getById(1);
//			rene2.setMotDePasse(((Integer) "NouveauMDP".hashCode()).toString());
//
//			DAOFactory.getDaoUtilisateurs().update(rene2);

			System.out.println("_________________Test DAO Categories____________________");
		
			Categorie sport = new Categorie();
			sport.setLibelle("sport aquatique");
//			DAOFactory.getDaoCategories().insert(sport); 
//			
//			System.out.println(DAOFactory.getDaoCategories().getById(1));
			
			Categorie sport2 = new Categorie();
			sport2.setLibelle("escrime");
//			DAOFactory.getDaoCategories().insert(sport2);

//			System.out.println(DAOFactory.getDaoCategories().getById(48));
//			System.out.println(DAOFactory.getDaoCategories().getById(50));
			
			Categorie sport3 = new Categorie();
			sport3.setLibelle("pétanque");
//			DAOFactory.getDaoCategories().insert(sport3);
			
//			System.out.println(DAOFactory.getDaoCategories().getAll());			
//			DAOFactory.getDaoCategories().delete(50);
//
//			Categorie sport4 = new Categorie();
//			sport4.setLibelle("volley");
//
//			DAOFactory.getDaoCategories().update(sport4);
//			sport4.setLibelle("gym");

		

System.out.println("_________________Test DAO Articles____________________");			
//			Utilisateur julia = new Utilisateur();
//			julia.setPseudo("Juju");
//			julia.setNom("Le Gall");
//			julia.setPrenom("Julia");
//			julia.setEmail("julia@mail.fr");
//			julia.setTelephone("0617513533");
//			julia.setRue("48 allée des framboisiers");
//			julia.setCodePostal(44300);
//			julia.setVille("Reze");
//			julia.setMotDePasse("jujudu29");
//			julia.setCredit(500);
//			julia.setAdministrateur(false);
//
//			DAOFactory.getDaoUtilisateurs().insert(julia);
//			
//			Retrait retrait0 = new Retrait();
//			retrait0.setRue("rue des mouettes");
//			retrait0.setCodePostal(44000);
//			retrait0.setVille("Nantes");
//			DAOFactory.getDaoRetrait().insert(retrait0);

			ArticleVendu palme = new ArticleVendu();
			palme.setNomArticle("Palme");
			palme.setDescription("Verte");
			palme.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
			palme.setDateFinEncheres(Date.valueOf(LocalDate.now()));
			palme.setMiseAPrix(20);
			palme.setPrixVente(80);
			palme.setEtatVente("Vendu");
			palme.setUtilisateur(DAOFactory.getDaoUtilisateurs().getById(65));

			Categorie cat = DAOFactory.getDaoCategories().getById(48);
//			System.out.println(cat);
			palme.setCategorieArticle(cat);
			palme.setLienImage("www.imagepalme.jpeg");
			
//			DAOFactory.getDaoArticlesVendus().insert(palme);
			
			ArticleVendu cochonnet = new ArticleVendu();
			cochonnet.setNomArticle("cochonnet");
			cochonnet.setDescription("cochonnet de compétition");
			cochonnet.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
			cochonnet.setDateFinEncheres(Date.valueOf(LocalDate.now()));
			cochonnet.setMiseAPrix(100);
			cochonnet.setPrixVente(180);
			cochonnet.setEtatVente("Vendu");
			cochonnet.setUtilisateur(DAOFactory.getDaoUtilisateurs().getById(69));
			Categorie cat1 = DAOFactory.getDaoCategories().getById(48);
//			System.out.println(cat1);
			cochonnet.setCategorieArticle(cat1);
			cochonnet.setLienImage("www.image.jpeg");
			
//			DAOFactory.getDaoArticlesVendus().insert(cochonnet);
		
			
//			for (ArticleVendu articleVendu : DAOFactory.getDaoArticlesVendus().getAll()) {
//				System.out.println(articleVendu.getNomArticle());
//			}

//			System.out.println(DAOFactory.getDaoArticlesVendus().getById(3));
//			System.out.println(DAOFactory.getDaoArticlesVendus().getById(1));
			
//			DAOFactory.getDaoArticlesVendus().delete(4);
			
System.out.println("_________________Test DAO Encheres____________________");
			
			Enchere enchere1 = new Enchere();
			enchere1.setDateEnchere(Date.valueOf(LocalDate.now()));
			enchere1.setMontantEnchere(200);
			enchere1.setUtilisateur(DAOFactory.getDaoUtilisateurs().getById(69));		
			enchere1.setArticleVendu(DAOFactory.getDaoArticlesVendus().getById(1));
			DAOFactory.getDaoEnchere().insert(enchere1);
			
			Enchere enchere2 = new Enchere();
			enchere2.setDateEnchere(Date.valueOf(LocalDate.now()));
			enchere2.setMontantEnchere(300);
			enchere2.setArticleVendu(palme);
			enchere2.setUtilisateur(robert);
//			
//			System.out.println(DAOFactory.getDaoEnchere().getById(1));
//			
//			DAOFactory.getDaoEnchere().insert(enchere2);
//			
//			System.out.println(DAOFactory.getDaoEnchere().getAll());
//			
//			DAOFactory.getDaoEnchere().delete(2);
//
//			System.out.println(DAOFactory.getDaoEnchere().getAll());
//			
//			Enchere enchere3 = DAOFactory.getDaoEnchere().getById(1);
//			enchere3.setMontantEnchere(500);
//			
//			DAOFactory.getDaoEnchere().update(enchere2);
//			
//		System.out.println("_________________Test DAO Retrait____________________");
//

//		
//		Retrait retrait1 = new Retrait();
//		retrait1.setArticle(castor);
//		retrait1.setRue("rue des mouettes");
//		retrait1.setCodePostal(44000);
//		retrait1.setVille("Nantes");
//		
//		castor.setLieuRetrait(retrait1);
//	
//		
//		DAOFactory.getDaoRetrait().insert(retrait1);
//		System.out.println(DAOFactory.getDaoRetrait().getById(1));
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
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
