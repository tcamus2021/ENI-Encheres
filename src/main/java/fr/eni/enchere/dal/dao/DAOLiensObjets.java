package fr.eni.enchere.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import fr.eni.enchere.dal.DALexception;
import fr.eni.enchere.dal.connexion.JDBCtools;

public class DAOLiensObjets {
	private String lienArticleUtilisateurCommande = "SELECT ARTICLES_VENDUS.no_article, ARTICLES_VENDUS.no_utilisateur FROM ARTICLES_VENDUS;";
	private String lienArticleCategorieCommande = "SELECT ARTICLES_VENDUS.no_article, ARTICLES_VENDUS.no_categorie FROM ARTICLES_VENDUS;";
	private String lienEnchereArticleCommande = "SELECT ENCHERES.no_enchere, ENCHERES.no_article FROM ENCHERES;";
	private String lienEnchereUtilisateurCommande = "SELECT ENCHERES.no_utilisateur, ENCHERES.no_enchere FROM ENCHERES;";

	public Map<Integer, Integer> lienArticleUtilisateur() throws DALexception {
		Map<Integer, Integer> retour = new HashMap<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement lienArticleUtilisateur = connexion.prepareStatement(lienArticleUtilisateurCommande);
			ResultSet resultat = lienArticleUtilisateur.executeQuery();
			while (resultat.next()) {
				retour.put(resultat.getInt(1), resultat.getInt(2));
			}
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur de la recherche du lien entre Article et Utilisateur");
		}
		return retour;
	}

	public Map<Integer, Integer> lienArticleCategorie() throws DALexception {
		Map<Integer, Integer> retour = new HashMap<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement lienArticleUtilisateur = connexion.prepareStatement(lienArticleCategorieCommande);
			ResultSet resultat = lienArticleUtilisateur.executeQuery();
			while (resultat.next()) {
				retour.put(resultat.getInt(1), resultat.getInt(2));
			}
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur de la recherche du lien entre Article et Utilisateur");
		}
		return retour;
	}

	public Map<Integer, Integer> lienEnchereArticle() throws DALexception {
		Map<Integer, Integer> retour = new HashMap<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement lienArticleUtilisateur = connexion.prepareStatement(lienEnchereArticleCommande);
			ResultSet resultat = lienArticleUtilisateur.executeQuery();
			while (resultat.next()) {
				retour.put(resultat.getInt(1), resultat.getInt(2));
			}
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur de la recherche du lien entre Article et Utilisateur");
		}
		return retour;
	}

	public Map<Integer, Integer> lienEnchereUtilisateur() throws DALexception {
		Map<Integer, Integer> retour = new HashMap<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement lienArticleUtilisateur = connexion.prepareStatement(lienEnchereUtilisateurCommande);
			ResultSet resultat = lienArticleUtilisateur.executeQuery();
			while (resultat.next()) {
				retour.put(resultat.getInt(2), resultat.getInt(1));
			}
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur de la recherche du lien entre Article et Utilisateur");
		}
		return retour;
	}
}
