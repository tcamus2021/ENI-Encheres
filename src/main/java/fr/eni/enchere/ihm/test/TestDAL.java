package fr.eni.enchere.ihm.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
			System.out.println(DAOFactory.getDaoUtilisateurs().getAll());
			
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
