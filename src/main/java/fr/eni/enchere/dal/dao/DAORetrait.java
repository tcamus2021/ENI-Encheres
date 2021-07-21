package fr.eni.enchere.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DALexception;
import fr.eni.enchere.dal.DAOEniEnchere;
import fr.eni.enchere.dal.connexion.JDBCtools;

public class DAORetrait implements DAOEniEnchere<Retrait> {
	private String insertCommande = "INSERT INTO RETRAITS VALUES(?, ?, ?, ?);";
	private String getAllCommande = "SELECT * FROM RETRAITS;";
	private String getByIdCommande = "SELECT * FROM RETRAITS WHERE no_article = ?;";
	private String updateCommande = "UPDATE RETRAITS " + "SET rue = ?, " + "code_postal = ?, " + "ville = ? "
			+ "WHERE no_article = ?;";
	private String deleteCommande = "DELETE FROM RETRAITS WHERE no_article = ?;";

	@Override
	public void insert(Retrait retrait) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement insert = connexion.prepareStatement(insertCommande);
			insert.setInt(1, retrait.getArticle().getNoArticle());
			insert.setString(2, retrait.getRue());
			insert.setString(3, retrait.getCodePostal().toString());
			insert.setString(4, retrait.getVille());
			insert.executeUpdate();
		} catch (Exception e) {
			throw new DALexception("Erreur à l'insertion du lieu de retrait");
		}
	}

	@Override
	public List<Retrait> getAll() throws DALexception {
		List<Retrait> retour = new ArrayList<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement getAll = connexion.prepareStatement(getAllCommande);
			ResultSet resultat = getAll.executeQuery();
			while (resultat.next()) {
				Retrait retraitCourant = new Retrait();
				retraitCourant.setRue(resultat.getString("rue"));
				retraitCourant.setCodePostal(Integer.parseInt(resultat.getString("code_postal")));
				retraitCourant.setVille(resultat.getString("ville"));
				retour.add(retraitCourant);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur à la récupération des lieux de retrait");
		}
		return retour;
	}

	@Override
	public Retrait getById(Integer idDarticle) throws DALexception {
		Retrait retour = new Retrait();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement getById = connexion.prepareStatement(getByIdCommande);
			getById.setInt(1, idDarticle);
			ResultSet resultat = getById.executeQuery();
			retour.setRue(resultat.getString("rue"));
			retour.setCodePostal(Integer.parseInt(resultat.getString("code_postal")));
			retour.setVille(resultat.getString("ville"));
		} catch (Exception e) {
			throw new DALexception("Erreur à la récupération du lieu de retrait");
		}
		return retour;
	}

	@Override
	public void update(Retrait retrait) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement update = connexion.prepareStatement(updateCommande);
			update.setString(1, retrait.getRue());
			update.setString(2, retrait.getCodePostal().toString());
			update.setString(3, retrait.getVille());
			update.setInt(4, retrait.getArticle().getNoArticle());
			update.executeUpdate();
		} catch (Exception e) {
			throw new DALexception("Erreur à la mise à jour du lieu de retrait");
		}

	}

	@Override
	public void delete(Integer idDarticle) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement delete = connexion.prepareStatement(deleteCommande);
			delete.setInt(1, idDarticle);
			delete.executeUpdate();
		} catch (Exception e) {
			throw new DALexception("Erreur à la suppression du lieu de retrait");
		}

	}

}
