package fr.eni.enchere.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALexception;
import fr.eni.enchere.dal.DAOEniEnchere;
import fr.eni.enchere.dal.connexion.JDBCtools;

public class DAOUtilisateurs implements DAOEniEnchere<Utilisateur> {
	private String insertCommande = "INSERT INTO UTILISATEURS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String selectAllCommande = "SELECT * FROM UTILISATEURS;";
	private String deleteCommande = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private String updateCommande = "UPDATE UTILISATEURS SET pseudo = ?, " + "nom = ?, " + "prenom = ?, "
			+ "email = ?, " + "telephone = ?, " + "rue = ?, " + "code_postal = ?, " + "ville = ?, "
			+ "mot_de_passe = ?," + "credit = ?," + "administrateur = ? " + "WHERE no_utilisateur = ?;";
	private String getByIdCommande = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";

	@Override
	public void insert(Utilisateur utilisateur) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
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
			throw new DALexception("Erreur à l'insertion de l'objet dans la base de données");
		}
	}

	@Override
	public List<Utilisateur> getAll() throws DALexception {
		List<Utilisateur> ret = new ArrayList<>();
		try(Connection connexion = JDBCtools.getConnection()){
			PreparedStatement selectAll = connexion.prepareStatement(selectAllCommande);
			ResultSet resultat = selectAll.executeQuery();
			while(resultat.next()) {
				Utilisateur utilisateurCourant = new Utilisateur();
				utilisateurCourant.setNoUtilisateur(resultat.getInt("no_utilisateur"));
				utilisateurCourant.setPseudo(resultat.getString("pseudo"));
				utilisateurCourant.setNom(resultat.getString("nom"));
				utilisateurCourant.setPrenom(resultat.getString("prenom"));
				utilisateurCourant.setEmail(resultat.getString("email"));
				utilisateurCourant.setTelephone(resultat.getString("telephone"));
				utilisateurCourant.setRue(resultat.getString("rue"));
				utilisateurCourant.setCodePostal(Integer.parseInt(resultat.getString("code_postal")));
				utilisateurCourant.setVille(resultat.getString("ville"));
				utilisateurCourant.setMotDePasse(resultat.getString("mot_de_passe"));
				utilisateurCourant.setCredit(resultat.getInt("credit"));
				utilisateurCourant.setAdministrateur(resultat.getBoolean("administrateur"));
				ret.add(utilisateurCourant);
			}
		} catch (Exception e) {
			throw new DALexception("Erreur à la récupération de la liste dans la BDD");
		}
		return ret;
	}

	@Override
	public Utilisateur getById(Integer id) throws DALexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur t) throws DALexception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws DALexception {
		// TODO Auto-generated method stub
	}

}
