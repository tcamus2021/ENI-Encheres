package fr.eni.enchere.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALexception;
import fr.eni.enchere.dal.DAOEniEnchere;
import fr.eni.enchere.dal.connexion.JDBCtools;

public class DAOUtilisateurs implements DAOEniEnchere<Utilisateur>{
	private String insertCommande = "INSERT INTO UTILISATEURS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	@Override
	public void insert(Utilisateur utilisateur) throws DALexception{
		try(Connection connexion = JDBCtools.getConnection()){
			PreparedStatement insert = connexion.prepareStatement(insertCommande);
			insert.setString(1, utilisateur.getPseudo());
			insert.setString(2, utilisateur.getNom());
			insert.setString(3, utilisateur.getPrenom());
			insert.setString(4, utilisateur.getEmail());
			insert.setString(5, utilisateur.getTelephone());
			insert.setString(6, utilisateur.getRue());
			insert.setString(7, utilisateur.getCodePostal().toString());
			insert.setString(8, utilisateur.getVille());
			insert.setString(9, utilisateur.getMotDePasse());
			insert.setInt(10, utilisateur.getCredit());
			insert.setBoolean(11, utilisateur.getAdministrateur());
			insert.executeUpdate();
			connexion.close();
		} catch (Exception e) {
			//throw new DALexception("Erreur à l'insertion de l'objet dans la base de données");
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
