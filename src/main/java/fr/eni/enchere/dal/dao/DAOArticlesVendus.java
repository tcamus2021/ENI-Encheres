package fr.eni.enchere.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.dal.DALexception;
import fr.eni.enchere.dal.DAOEniEnchere;
import fr.eni.enchere.dal.connexion.JDBCtools;

public class DAOArticlesVendus implements DAOEniEnchere<ArticleVendu> {
	private String insertCommande = "INSERT INTO ARTICLES_VENDUS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String getAllCommande = "SELECT * FROM ARTICLES_VENDUS;";
	private String updateCommande = "UPDATE ARTICLES_VENDUS SET " + "nom_article = ?, " + "description = ?, "
			+ "date_debut_encheres = ?, " + "date_fin_encheres = ?, " + "prix_initial = ?, prix_vente = ?, "
			+ "no_utilisateur = ?, " + "no_categorie = ?, " + "lien_image = ? " + "WHERE no_article = ?;";
	private String deleteCommande = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?;";

	@Override
	public void insert(ArticleVendu article) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement insert = connexion.prepareStatement(insertCommande);
			insert.setString(1, article.getNomArticle());
			insert.setString(2, article.getDescription());

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = simpleDateFormat.format(article.getDateDebutEncheres());
			java.sql.Date dateSQL = java.sql.Date.valueOf(formattedDate);
			insert.setString(3, dateSQL.toString());

			formattedDate = simpleDateFormat.format(article.getDateFinEncheres());
			dateSQL = java.sql.Date.valueOf(formattedDate);
			insert.setString(4, dateSQL.toString());

			insert.setDouble(5, article.getMiseAPrix());
			insert.setDouble(6, article.getPrixVente());
			insert.setInt(7, article.getUtilisateur().getNoUtilisateur());
			insert.setInt(8, article.getCategorieArticle().getNoCategorie());
			insert.setString(9, article.getLienImage());

			insert.executeUpdate();
			connexion.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur à l'insertion de l'article");
		}
	}

	@Override
	public List<ArticleVendu> getAll() throws DALexception {
		List<ArticleVendu> ret = new ArrayList<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement getAll = connexion.prepareStatement(getAllCommande);
			ResultSet resultat = getAll.executeQuery();
			while (resultat.next()) {
				ArticleVendu articleCourant = new ArticleVendu();
				articleCourant.setNoArticle(resultat.getInt(1));
				articleCourant.setNomArticle(resultat.getString(2));
				articleCourant.setDescription(resultat.getString(3));
				articleCourant.setDateDebutEncheres(resultat.getDate(4));
				articleCourant.setDateFinEncheres(resultat.getDate(5));
				articleCourant.setMiseAPrix(resultat.getInt(6));
				articleCourant.setPrixVente(resultat.getInt(7));
				articleCourant.setLienImage(resultat.getString(10));
				ret.add(articleCourant);
				connexion.close();
			}
		} catch (Exception e) {
			throw new DALexception("Erreur à la récupération des articles");
		}
		return ret;
	}

	@Override
	public ArticleVendu getById(Integer id) throws DALexception {
		ArticleVendu ret = new ArticleVendu();
		try {
			List<ArticleVendu> recherche = getAll();
			for (ArticleVendu articleVendu : recherche) {
				if (articleVendu.getNoArticle() == id) {
					ret = articleVendu;
				}
			}
		} catch (Exception e) {
			throw new DALexception("Erreur à la récupération de l'objet");
		}
		return ret;
	}

	@Override
	public void update(ArticleVendu article) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement update = connexion.prepareStatement(updateCommande);
			update.setString(1, article.getNomArticle());
			update.setString(2, article.getDescription());
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = simpleDateFormat.format(article.getDateDebutEncheres());
			java.sql.Date dateSQL = java.sql.Date.valueOf(formattedDate);
			update.setString(3, dateSQL.toString());

			formattedDate = simpleDateFormat.format(article.getDateFinEncheres());
			dateSQL = java.sql.Date.valueOf(formattedDate);
			update.setString(4, dateSQL.toString());
			
			update.setInt(5, article.getMiseAPrix());
			update.setInt(6, article.getPrixVente());
			update.setInt(7, article.getUtilisateur().getNoUtilisateur());
			update.setInt(8, article.getCategorieArticle().getNoCategorie());
			update.setString(9, article.getLienImage());
			update.setInt(10, article.getNoArticle());
			update.executeUpdate();
			connexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur à la mise à jour");
		}
	}

	@Override
	public void delete(Integer id) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement delete = connexion.prepareStatement(deleteCommande);
			delete.setInt(1, id);
			delete.executeUpdate();
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur à la supression");
		}
	}

}
