package fr.eni.enchere.ihm.test;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//			System.out.println("_________________Test DAO Utilisateur____________________");
//
//			Utilisateur rene = new Utilisateur();
//			rene.setPseudo("Xx_Rene_Du_24XX");
//			rene.setNom("Mallard");
//			rene.setPrenom("René");
//			rene.setEmail("rene@mail.fr");
//			rene.setTelephone("0617513524");
//			rene.setRue("32 Rue des agenêts");
//			rene.setCodePostal(44000);
//			rene.setVille("Nantes");
//			rene.setMotDePasse("ReneLPB");
//			rene.setCredit(500);
//			rene.setAdministrateur(false);
//
//			DAOFactory.getDaoUtilisateurs().insert(rene);
//
//			Utilisateur robert = new Utilisateur();
//			robert.setPseudo("Xx_Robert_Du_24XX");
//			robert.setNom("Le suisse");
//			robert.setPrenom("Robert");
//			robert.setEmail("robert@mail.fr");
//			robert.setTelephone("0784859565");
//			robert.setRue("87 Rue des agenêts");
//			robert.setCodePostal(29000);
//			robert.setVille("Paris");
//			robert.setMotDePasse("Robert");
//			robert.setCredit(500);
//			robert.setAdministrateur(false);
//
//			System.out.println(DAOFactory.getDaoUtilisateurs().getById(1));
//
//			DAOFactory.getDaoUtilisateurs().insert(robert);
//
//			System.out.println(DAOFactory.getDaoUtilisateurs().getAll());
//
//			DAOFactory.getDaoUtilisateurs().delete(2);
//
//			System.out.println(DAOFactory.getDaoUtilisateurs().getAll());
//
//			Utilisateur rene2 = DAOFactory.getDaoUtilisateurs().getById(1);
//			rene2.setMotDePasse(((Integer) "NouveauMDP".hashCode()).toString());
//
//			DAOFactory.getDaoUtilisateurs().update(rene2);

			Utilisateur rene = BLLFactorySingl.createInstanceUtilisateur().getUtilisateurByPseudo("tanguy@mail.gouv");
//			
			Categorie vetement = new Categorie();
			vetement.setNoCategorie(3);
			vetement.setLibelle("Vêtement");
//			
			ArticleVendu polo = new ArticleVendu();
			polo.setNomArticle("Polo Blanc");
			polo.setDescription("Couleur Blanche");
			polo.setDateDebutEncheres(Date.valueOf(LocalDate.now()));
			polo.setDateFinEncheres(Date.valueOf(LocalDate.of(2021, 07, 23)));
			polo.setMiseAPrix(20);
			polo.setPrixVente(60);
			polo.setUtilisateur(rene);
			polo.setCategorieArticle(vetement);
			polo.setLienImage("/WEB-INF/img/default.png");
//			
//			DAOFactory.getDaoArticlesVendus().insert(polo);

//			System.out.println(DAOFactory.getDaoArticlesVendus().getAll());
//			
//			System.out.println(DAOFactory.getDaoArticlesVendus().getById(1));
			
			DAOFactory.getDaoArticlesVendus().update(polo);

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
