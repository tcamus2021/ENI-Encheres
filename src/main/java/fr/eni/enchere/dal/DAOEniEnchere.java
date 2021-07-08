package fr.eni.enchere.dal;

import java.util.List;

/**
 * 
 * @author rguezennec2021 & tcamus2021
 *
 */
public interface DAOEniEnchere<T> {
	
	/**
	 * Pour insérer un objet à la base de données 
	 * 
	 */
	public void insert(T t) throws DALexception;
	
	/** Pour récupérer tous les objets dans la base de données
	 * 
	 * @return
	 */
	public List<T> getAll() throws DALexception;
	
	/**
	 * Pour récupérer un objet par son identifiant dans la base de données
	 * @param id
	 * @return
	 */
	public T getById(Integer id) throws DALexception;

	/**
	 * Pour mettre à jour un objet dans la base de données
	 * @param t
	 */
	public void update(T t) throws DALexception;

	/**
	 * Pour supprimer un objet par son identifiant dans la base de données
	 * @param id
	 */
	public void delete(Integer id) throws DALexception;

}
