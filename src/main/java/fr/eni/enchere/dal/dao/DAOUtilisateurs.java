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
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur à la récupération de la liste dans la BDD");
		}
		return ret;
	}

	@Override
	public Utilisateur getById(Integer id) throws DALexception {
		Utilisateur ret = new Utilisateur();
		try(Connection connexion = JDBCtools.getConnection()){
			PreparedStatement selectID = connexion.prepareStatement(getByIdCommande);
			selectID.setInt(1, id);
			ResultSet resultat = selectID.executeQuery();
			while(resultat.next()) {
				ret.setNoUtilisateur(resultat.getInt("no_utilisateur"));
				ret.setPseudo(resultat.getString("pseudo"));
				ret.setNom(resultat.getString("nom"));
				ret.setPrenom(resultat.getString("prenom"));
				ret.setEmail(resultat.getString("email"));
				ret.setTelephone(resultat.getString("telephone"));
				ret.setRue(resultat.getString("rue"));
				ret.setCodePostal(Integer.parseInt(resultat.getString("code_postal")));
				ret.setVille(resultat.getString("ville"));
				ret.setMotDePasse(resultat.getString("mot_de_passe"));
				ret.setCredit(resultat.getInt("credit"));
				ret.setAdministrateur(resultat.getBoolean("administrateur"));
			}
			connexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur à la récupération de l'utilisateur");
		}
		return ret;
	}

	@Override
	public void update(Utilisateur utilisateur) throws DALexception {
		try(Connection connexion = JDBCtools.getConnection()){
			PreparedStatement update = connexion.prepareStatement(updateCommande);
			update.setString(1, utilisateur.getPseudo());
			update.setString(2, utilisateur.getNom());
			update.setString(3, utilisateur.getPrenom());
			update.setString(4, utilisateur.getEmail());
			update.setString(5, utilisateur.getTelephone());
			update.setString(6, utilisateur.getRue());
			update.setString(7, utilisateur.getCodePostal().toString());
			update.setString(8, utilisateur.getVille());
			update.setString(9, utilisateur.getMotDePasse());
			update.setInt(10, utilisateur.getCredit());
			update.setBoolean(11, utilisateur.getAdministrateur());
			update.setInt(12, utilisateur.getNoUtilisateur());
			update.executeUpdate();
			connexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur lors de la mise à jour");
		}
	}

	@Override
	public void delete(Integer id) throws DALexception {
		try(Connection connexion = JDBCtools.getConnection()){
			PreparedStatement delete = connexion.prepareStatement(deleteCommande);
			delete.setInt(1, id);
			delete.executeUpdate();
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur lors de la suppression");
		}
	}

}
