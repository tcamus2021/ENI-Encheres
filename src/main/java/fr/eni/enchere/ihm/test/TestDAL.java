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

			DAOFactory.getDaoUtilisateurs().insert(rene);

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

			DAOFactory.getDaoUtilisateurs().insert(robert);

//			System.out.println(DAOFactory.getDaoUtilisateurs().getAll());

			DAOFactory.getDaoUtilisateurs().delete(2);

			Utilisateur rene2 = DAOFactory.getDaoUtilisateurs().getById(1);
			rene2.setMotDePasse(((Integer) "NouveauMDP".hashCode()).toString());

			DAOFactory.getDaoUtilisateurs().update(rene2);

System.out.println("_________________Test DAO Categories____________________");
		
			Categorie sport = new Categorie();
			sport.setLibelle("sport aquatique");
			DAOFactory.getDaoCategories().insert(sport); 
			
			System.out.println(DAOFactory.getDaoCategories().getById(1));
			
			Categorie loisirs = new Categorie();
			loisirs.setLibelle("parc d'attraction");
			DAOFactory.getDaoCategories().insert(loisirs);
			
			Categorie meuble = new Categorie();
			meuble.setLibelle("meuble");
			DAOFactory.getDaoCategories().insert(meuble);
			
			System.out.println(DAOFactory.getDaoCategories().getAll());
			
			DAOFactory.getDaoCategories().delete(3);

			Categorie meuble1 = DAOFactory.getDaoCategories().getById(3);
			meuble1.setLibelle("canape");

			DAOFactory.getDaoCategories().update(meuble1);

			
System.out.println("_________________Test DAO Encheres____________________");
			
			Utilisateur julia = new Utilisateur();
			julia.setPseudo("Juju");
			julia.setNom("Le Gall");
			julia.setPrenom("Julia");
			julia.setEmail("julia@mail.fr");
			julia.setTelephone("0617513533");
			julia.setRue("48 allée des framboisiers");
			julia.setCodePostal(44300);
			julia.setVille("Reze");
			julia.setMotDePasse("jujudu29");
			julia.setCredit(500);
			julia.setAdministrateur(false);

			DAOFactory.getDaoUtilisateurs().insert(julia);
			
			ArticleVendu chaise = new ArticleVendu();
			chaise.setNomArticle("chaise haute");
			chaise.setDescription("Verte");
			chaise.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
			chaise.setDateFinEncheres(Date.valueOf(LocalDate.now()));
			chaise.setMiseAPrix(20);
			chaise.setPrixVente(80);
			chaise.setEtatVente("Vendu");
			chaise.setUtilisateur(julia);
			chaise.setCategorieArticle(meuble);
			chaise.setLienImage("www.image1.jpeg");
			
			DAOFactory.getDaoArticlesVendus().insert(chaise);
			
			Enchere enchere1 = new Enchere();
			enchere1.setDateEnchere(Date.valueOf(LocalDate.now()));
			enchere1.setMontantEnchere(200);
			enchere1.setUtilisateur(julia);		
			enchere1.setArticleVendu(chaise);
			
			DAOFactory.getDaoEnchere().insert(enchere1);
			
			Enchere enchere2 = new Enchere();
			enchere2 .setDateEnchere(Date.valueOf(LocalDate.now()));
			enchere2 .setMontantEnchere(300);
			enchere2 .setArticleVendu(chaise);
			enchere2 .setUtilisateur(robert);
			
//			System.out.println(DAOFactory.getDaoEnchere().getById(1));
			
			DAOFactory.getDaoEnchere().insert(enchere2);
			
//			System.out.println(DAOFactory.getDaoEnchere().getAll());
			
			DAOFactory.getDaoEnchere().delete(2);

//			System.out.println(DAOFactory.getDaoEnchere().getAll());
			
			Enchere enchere3 = DAOFactory.getDaoEnchere().getById(1);
			enchere3.setMontantEnchere(500);
			
			DAOFactory.getDaoEnchere().update(enchere2);
			
		System.out.println("_________________Test DAO Retrait____________________");

		ArticleVendu castor = new ArticleVendu();
		castor.setNomArticle("Beaver");
		castor.setDescription("Castor bleu");
		castor.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
		castor.setDateFinEncheres(Date.valueOf(LocalDate.now()));
		castor.setMiseAPrix(100);
		castor.setPrixVente(180);
		castor.setEtatVente("Vendu");
		castor.setUtilisateur(rene);
		castor.setCategorieArticle(loisirs);
		castor.setLienImage("www.image.jpeg");
		
		DAOFactory.getDaoArticlesVendus().insert(castor);
		
		Retrait retrait1 = new Retrait();
		retrait1.setArticle(castor);
		retrait1.setRue("rue des mouettes");
		retrait1.setCodePostal(44000);
		retrait1.setVille("Nantes");
		
		castor.setLieuRetrait(retrait1);
	
		
		DAOFactory.getDaoRetrait().insert(retrait1);
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
