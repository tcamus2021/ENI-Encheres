package fr.eni.enchere.dal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALexception;
import fr.eni.enchere.dal.DAOEniEnchere;
import fr.eni.enchere.dal.connexion.JDBCtools;

public class DAOEncheres implements DAOEniEnchere<Enchere> {
	private String insertCommande = "INSERT INTO ENCHERES VALUES (?, ?, ?, ?);";
	private String selectAllCommande = "SELECT * FROM ENCHERES;";
	private String deleteCommande = "DELETE FROM ENCHERES WHERE no_enchere = ?";
	private String updateCommande = "UPDATE ENCHERES SET date_enchere = ?," + "montant_enchere = ?, "
			+ "no_article = ?, " + "no_utilisateur = ?," + "WHERE no_enchere = ?;";
	private String getByIdCommande = "SELECT * FROM ENCHERES WHERE no_enchere = ?;";

	@Override
	public void insert(Enchere enchere) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement insert = connexion.prepareStatement(insertCommande);
			insert.setDate(1, (Date) enchere.getDateEnchere());
			insert.setInt(2, enchere.getMontantEnchere());
			insert.setInt(3, enchere.getArticleVendu().getNoArticle());
			insert.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
			insert.executeUpdate();
			connexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur à l'insertion dans la base de données");
		}
	}

	@Override
	public List<Enchere> getAll() throws DALexception {
		List<Enchere> ret = new ArrayList<>();
		try (Connection connexion = JDBCtools.getConnection()) {
			// Récupération des champs dans la table enchères
			PreparedStatement selectAll = connexion.prepareStatement(selectAllCommande);
			ResultSet resultat = selectAll.executeQuery();
			// Traite le résultat pour créer des objets Enchères
			while (resultat.next()) {
				Enchere enchereCourante = new Enchere();
				enchereCourante.setDateEnchere(resultat.getDate("date_enchere"));
				enchereCourante.setMontantEnchere(resultat.getInt("montant_enchere"));

				// Récupérer via le numéro d'article trouvé, l'article correspondant dans sa
				// table
				PreparedStatement selectByIdArticle = connexion
						.prepareStatement("SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?");
				selectByIdArticle.setInt(1, resultat.getInt("no_article"));
				ResultSet resultatSelectByIdArticle = selectByIdArticle.executeQuery();
				ArticleVendu articleCourant = new ArticleVendu();
				// Créer notre Article
				while (resultatSelectByIdArticle.next()) {
					articleCourant.setNoArticle(resultatSelectByIdArticle.getInt("no_article"));
					articleCourant.setNomArticle(resultatSelectByIdArticle.getString("nom_article"));
					articleCourant.setDescription(resultatSelectByIdArticle.getString("description"));
					articleCourant.setDateDebutEncheres(resultatSelectByIdArticle.getDate("date_debut_encheres"));
					articleCourant.setDateFinEncheres(resultatSelectByIdArticle.getDate("date_fin_encheres"));
					articleCourant.setMiseAPrix(resultatSelectByIdArticle.getInt("prix_initial"));
					articleCourant.setPrixVente(resultatSelectByIdArticle.getInt("prix_vente"));
					articleCourant.setUtilisateur(null);
					articleCourant.setCategorieArticle(null);
				}
				// Insertion dans notre enchère
				enchereCourante.setArticleVendu(articleCourant);

				// Récupérer via le numéro d'utilisateur trouvé, l'utilisateur correspondant
				// dans sa table
				PreparedStatement selectByIdUtilisateur = connexion
						.prepareStatement("SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?");
				selectByIdUtilisateur.setInt(1, resultat.getInt("no_utilisateur"));
				ResultSet resultatSelectByIdUtilisateur = selectByIdUtilisateur.executeQuery();
				Utilisateur utilisateurCourant = new Utilisateur();

				// Créer notre utilisateur
				while (resultatSelectByIdUtilisateur.next()) {
					utilisateurCourant.setNoUtilisateur(resultatSelectByIdUtilisateur.getInt("no_utilisateur"));
					utilisateurCourant.setPseudo(resultatSelectByIdUtilisateur.getString("pseudo"));
					utilisateurCourant.setNom(resultatSelectByIdUtilisateur.getString("nom"));
					utilisateurCourant.setPrenom(resultatSelectByIdUtilisateur.getString("prenom"));
					utilisateurCourant.setEmail(resultatSelectByIdUtilisateur.getString("email"));
					utilisateurCourant.setTelephone(resultatSelectByIdUtilisateur.getString("telephone"));
					utilisateurCourant.setRue(resultatSelectByIdUtilisateur.getString("rue"));
					utilisateurCourant
							.setCodePostal(Integer.parseInt(resultatSelectByIdUtilisateur.getString("code_postal")));
					utilisateurCourant.setVille(resultatSelectByIdUtilisateur.getString("ville"));
					utilisateurCourant.setMotDePasse(resultatSelectByIdUtilisateur.getString("mot_de_passe"));
					utilisateurCourant.setCredit(resultatSelectByIdUtilisateur.getInt("credit"));
				}
				// Insertion dans notre enchère
				enchereCourante.setUtilisateur(utilisateurCourant);

				ret.add(enchereCourante);
			}
			connexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALexception("Erreur à la récupération de la liste dans la base de données");
		}
		return ret;
	}

	@Override
	public Enchere getById(Integer id) throws DALexception {
		Enchere ret = new Enchere();
		try (Connection connexion = JDBCtools.getConnection()) {
			PreparedStatement selectID = connexion.prepareStatement(getByIdCommande);
			selectID.setInt(1, id);
			ResultSet resultat = selectID.executeQuery();
			while (resultat.next()) {
				ret.setIdEnchere(id);
				ret.setDateEnchere(resultat.getDate("date_enchere"));
				ret.setMontantEnchere(resultat.getInt("montant_enchere"));
			}
			connexion.close();
		} catch (Exception e) {
			throw new DALexception("Erreur à la récupération de l'enchere");
		}
		return ret;
	}

	@Override
	public void update(Enchere enchere) throws DALexception {
		try (Connection connexion = JDBCtools.getConnection()) {
			System.out.println(enchere);
			PreparedStatement update = connexion.prepareStatement(updateCommande);
			update.setDate(1, (Date) enchere.getDateEnchere());
			update.setInt(2, enchere.getMontantEnchere());
			update.setInt(3, enchere.getArticleVendu().getNoArticle());
			update.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
			update.executeUpdate();

		} catch (Exception e) {
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
