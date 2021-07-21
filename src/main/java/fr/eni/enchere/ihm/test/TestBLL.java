package fr.eni.enchere.ihm.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class TestBLL
 */
@WebServlet("/TestBLL")
public class TestBLL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestBLL() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
//			System.out.println("_____________________Test BLL utilisateur____________________");
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
//			rene.setAdministrateur(false);
//			
//			Utilisateur robert = new Utilisateur();
//			robert.setPseudo("Xx_Robert_Du_24XX");
//			robert.setNom("Le suisse");
//			robert.setPrenom("Robert");
//			robert.setEmail("Robert@mail.fr");
//			robert.setTelephone("0617514524");
//			robert.setRue("89 Rue des agenêts");
//			robert.setCodePostal(44000);
//			robert.setVille("Nantes");
//			robert.setMotDePasse("RobertLeBG");
//			robert.setAdministrateur(false);
//			
//			//Insertions
//			BLLFactorySingl.createInstanceUtilisateur().inscription(rene);
//			BLLFactorySingl.createInstanceUtilisateur().inscription(robert);
//
//			//Touts les utilisateurs
//			System.out.println(BLLFactorySingl.createInstanceUtilisateur().getAll());
//			
//			//René se connecte avec son pseudo
//			try {
//				BLLFactorySingl.createInstanceUtilisateur().verifierInscription("Xx_Rene_Du_24XX", "ReneLPB");
//				System.out.println("Connected");
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			
//			//René se connecte avec son mail
//			try {
//				BLLFactorySingl.createInstanceUtilisateur().verifierInscription("rene@mail.fr", "ReneLPB");
//				System.out.println("Connected");
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			
//			//René se trompe de mdp
//			try {
//				BLLFactorySingl.createInstanceUtilisateur().verifierInscription("Xx_Rene_Du_24XX", "MauvaisMDP");
//				System.out.println("Connected");
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			
//			//Affichage de rené
//			System.out.println(BLLFactorySingl.createInstanceUtilisateur().getUtilisateurByPseudo("Xx_Rene_Du_24XX"));
//			
//			//Robert est supprimé
//			BLLFactorySingl.createInstanceUtilisateur().delete(robert);
//
//			//Affichage de tout les utilisateurs
//			System.out.println(BLLFactorySingl.createInstanceUtilisateur().getAll());
			
			System.out.println(BLLFactorySingl.createInstanceUtilisateur().getAll());
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
