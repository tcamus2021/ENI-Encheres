package fr.eni.enchere.bll.interfaces;

import java.util.List;

import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

/**
 * 
 * @author tcamus2021 & rguezennec2021
 *
 */
public interface VenteManager {

	/**
	 * Pour vendre un article
	 * 
	 * @throws BLLexception
	 */
	public void vendre(ArticleVendu articleVendu) throws BLLexception;

	/**
	 * Pour afficher la liste des enchères
	 * 
	 * @throws BLLexception
	 */
	public List<Enchere> getAllEnchere() throws BLLexception;

	/**
	 * Pour avoir une liste de tout les ArticleVendu
	 * 
	 * @return
	 * @throws BLLexception
	 */
	public List<ArticleVendu> getAllArticleVendu() throws BLLexception;

	/**
	 * Pour avoir une liste de toutes les Catégories
	 * 
	 * @return
	 * @throws BLLexception
	 */
	public List<Categorie> getAllCategorie() throws BLLexception;

	/**
	 * Pour avoir une liste de tout les Retrait
	 * 
	 * @return
	 * @throws BLLexception
	 */
	public List<Retrait> getAllRetrait() throws BLLexception;

	/**
	 * Pour faire une enchère
	 * 
	 * @throws BLLexception
	 */
	public void encherir(Utilisateur utilisateur, Integer montant, ArticleVendu articleVendu) throws BLLexception;

	/**
	 * Pour remporter une vente
	 * 
	 * @throws BLLexception
	 */
	public void remporterVente(Utilisateur utilisateur) throws BLLexception;
}
