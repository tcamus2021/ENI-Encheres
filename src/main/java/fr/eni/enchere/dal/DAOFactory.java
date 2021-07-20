package fr.eni.enchere.dal;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.dao.DAOArticlesVendus;
import fr.eni.enchere.dal.dao.DAOUtilisateurs;
import fr.eni.enchere.dal.mock.MockArticlesVendus;
import fr.eni.enchere.dal.mock.MockCategories;
import fr.eni.enchere.dal.mock.MockEncheres;
import fr.eni.enchere.dal.mock.MockRetrait;
import fr.eni.enchere.dal.mock.MockUtilisateurs;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */
public class DAOFactory {
	/**
	 * Création de DAO article vendu
	 * @return
	 */
	public static DAOEniEnchere<ArticleVendu> getDaoArticlesVendus() {
		return new DAOArticlesVendus();
	}
	
	/**
	 * Création de DAO categorie
	 * @return
	 */
	public static DAOEniEnchere<Categorie> getDaoCategories() {
			return new MockCategories();
	}
	
	/**
	 * Création de DAO Enchere
	 * @return
	 */
	public static DAOEniEnchere<Enchere> getDaoEnchere() {
		return new MockEncheres();
	}
	
	/**
	 * Création de DAO retrait
	 * @return
	 */
	public static DAOEniEnchere<Retrait> getDaoRetrait() {
		return new MockRetrait();
	}
	
	/**
	 * Création de DAO Utilisateur
	 * @return
	 */
	public static DAOEniEnchere<Utilisateur> getDaoUtilisateurs() {
		return new DAOUtilisateurs();
	}
}
