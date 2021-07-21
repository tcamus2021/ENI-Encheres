package fr.eni.enchere.dal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALexception;
import fr.eni.enchere.dal.DAOEniEnchere;
import fr.eni.enchere.dal.connexion.JDBCtools;

public class DAOCategories implements DAOEniEnchere<Categorie> {
	private String insertCommande = "INSERT INTO CATEGORIES VALUES(?);";
	private String selectAllCommande = "SELECT * FROM CATEGORIES;";
	private String deleteCommande = "DELETE FROM CATEGORIES WHERE no_categorie = ?";
	private String updateCommande = "UPDATE CATEGORIES SET libelle = ?," + "WHERE no_categorie = ?;";
	private String getByIdCommande = "SELECT * FROM CATEGORIES WHERE no_categorie = ?;";

	@Override
	public void insert(Categorie categorie) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement insert = connexion.prepareStatement(insertCommande);
			insert.setString(1, categorie.getLibelle());
			insert.executeUpdate();
			connexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DALexception("Erreur à l'insertion dans la base de données");
		}
	}

	@Override
	public List<Categorie> getAll() throws DALexception {
		List<Categorie> ret = new ArrayList<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement selectAll = connexion.prepareStatement(selectAllCommande);
			ResultSet resultat = selectAll.executeQuery();
			while (resultat.next()) {
				Categorie categorieCourante = new Categorie();
				categorieCourante.setLibelle(resultat.getString("libelle"));
				ret.add(categorieCourante);
			}
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur à la récupération de la liste dans la base de données");
		}
		return ret;
	}

	@Override
	public Categorie getById(Integer id) throws DALexception {
		Categorie ret = new Categorie();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement selectID = connexion.prepareStatement(getByIdCommande);
			selectID.setInt(1, id);
			ResultSet resultat = selectID.executeQuery();
			while (resultat.next()) {
				ret.setLibelle(resultat.getString("libelle"));
			}
			connexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur à la récupération de la catégorie");
		}
		return ret;
	}

	@Override
	public void update(Categorie categorie) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			System.out.println(categorie);
			PreparedStatement update = connexion.prepareStatement(updateCommande);
			update.setString(1, categorie.getLibelle());
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur lors de la mise à jour de la base de données");
		}

	}

	@Override
	public void delete(Integer id) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement delete = connexion.prepareStatement(deleteCommande);
			delete.setInt(1, id);
			delete.executeUpdate();
		} catch (Exception e) {
			throw new DALexception("Erreur lors de la suppression");
		}

	}

}
