package fr.eni.enchere.bll.interfaces;

import java.util.List;

import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bo.Utilisateur;

/**
 * 
 * @author tcamus2021 & rguezennec2021
 *
 */
public interface UtilisateurManager {
	/**
	 * Pour se connecter en tant qu'utilisateur
	 * 
	 * @throws BLLexception
	 */
	public void seConnecter() throws BLLexception;

	/**
	 * Pour s'inscrire en tant que nouvel utilisateur
	 * 
	 * @param utilisateur
	 * @throws BLLexception
	 */
	public void inscription(Utilisateur utilisateur) throws BLLexception;

	/**
	 * Pour se déconnecter
	 * 
	 * @throws BLLexception
	 */
	public void seDeconnecter() throws BLLexception;

	/**
	 * Pour afficher un profil d'utilisateur
	 * 
	 * @return
	 * @throws BLLexception
	 */
	public Utilisateur getUtilisateurByPseudo() throws BLLexception;

	/**
	 * Pour afficher tous les utilisateur
	 * 
	 * @return
	 * @throws BLLexception
	 */
	public List<Utilisateur> getAll() throws BLLexception;

	/**
	 * Pour mettre à jour un utilisateur
	 * 
	 * @param utilisateur
	 * @return
	 * @throws BLLexception
	 */
	public Utilisateur update(Utilisateur utilisateur) throws BLLexception;

	/**
	 * Pour supprimer un utilsateur
	 * 
	 * @param utilisateur
	 * @return
	 * @throws BLLexception
	 */
	public void delete(Utilisateur utilisateur) throws BLLexception;

}
