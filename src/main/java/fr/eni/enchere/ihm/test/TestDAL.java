package fr.eni.enchere.ihm.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.Enchere;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			System.out.println(DAOFactory.getDaoUtilisateurs().getById(1));
			
			DAOFactory.getDaoUtilisateurs().insert(robert);
			
			System.out.println(DAOFactory.getDaoUtilisateurs().getAll());
			
			DAOFactory.getDaoUtilisateurs().delete(2);

			System.out.println(DAOFactory.getDaoUtilisateurs().getAll());
			
			Utilisateur rene2 = DAOFactory.getDaoUtilisateurs().getById(1);
			rene2.setMotDePasse(((Integer) "NouveauMDP".hashCode()).toString());
			
			DAOFactory.getDaoUtilisateurs().update(rene2);
			
			
//			System.out.println("_________________Test DAO Encheres____________________");
//
//			Enchere enchere1 = new Enchere();
//			enchere1.setDateEnchere(null);
//			enchere1.setMontantEnchere(200);
////			enchere1.setArticleVendu().setNoArticle(1);
////			enchere1.setUtilisateur().setNoUtilisateur(2);
//			
//
//			DAOFactory.getDaoEnchere().insert(enchere1);
//			
//			Enchere enchere2 = new Enchere();
//			enchere2 .setDateEnchere(null);
//			enchere2 .setMontantEnchere(300);
////			enchere2 .setArticleVendu().setNoArticle(1);
////			enchere2 .setUtilisateur().setNoUtilisateur(2);
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
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
