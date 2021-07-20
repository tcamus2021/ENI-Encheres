package fr.eni.enchere.bll.implement;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bll.interfaces.VenteManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;

public class VenteManagerImpl implements VenteManager {
	private List<Enchere> listeEncheres = new ArrayList<>();
	private List<ArticleVendu> listeArticleVendu = new ArrayList<>();
	private List<Categorie> listeCategorie = new ArrayList<>();
	private List<Retrait> listeRetrait = new ArrayList<>();

	@Override
	public void vendre(ArticleVendu articleVendu) throws BLLexception {
		try {
			testArticleVendu(articleVendu);

			if (articleVendu.getDateDebutEncheres().before(Date.valueOf(LocalDate.now()))) {
				throw new BLLexception("Date de début antérieur à la date actuelle");
			}

			if (articleVendu.getDateDebutEncheres().after(articleVendu.getDateFinEncheres())) {
				throw new BLLexception("Date de début avant celle de fin");
			}

			articleVendu.setPrixVente(articleVendu.getMiseAPrix());

			if (articleVendu.getLieuRetrait() == null) {
				Retrait adresseUtilisateur = new Retrait();
				adresseUtilisateur.setRue(articleVendu.getUtilisateur().getRue());
				adresseUtilisateur.setCodePostal(articleVendu.getUtilisateur().getCodePostal());
				adresseUtilisateur.setVille(articleVendu.getUtilisateur().getVille());
				articleVendu.setLieuRetrait(adresseUtilisateur);
			}
			
			DAOFactory.getDaoArticlesVendus().insert(articleVendu);
		} catch (Exception e) {
			throw new BLLexception(e.getMessage());
		}
	}

	@Override
	public List<Enchere> getAllEnchere() throws BLLexception {
		try {
			this.listeEncheres = DAOFactory.getDaoEnchere().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération des différentes Enchères");
		}
		return this.listeEncheres;
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws BLLexception {
		try {
			this.listeArticleVendu = DAOFactory.getDaoArticlesVendus().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération des différents Articles");
		}
		return this.listeArticleVendu;
	}

	@Override
	public List<Categorie> getAllCategorie() throws BLLexception {
		try {
			this.listeCategorie = DAOFactory.getDaoCategories().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération des différentes catégories");
		}
		return this.listeCategorie;
	}

	@Override
	public List<Retrait> getAllRetrait() throws BLLexception {
		try {
			this.listeRetrait = DAOFactory.getDaoRetrait().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération de la liste de point de retrait");
		}
		return this.listeRetrait;
	}

	@Override
	public void encherir(Utilisateur utilisateur, Integer montant, ArticleVendu articleVendu) throws BLLexception {
		Enchere nouvelleEnchere = new Enchere();
		nouvelleEnchere.setDateEnchere(Date.valueOf(LocalDate.now()));
		nouvelleEnchere.setMontantEnchere(montant);

		if (utilisateur.getCredit() - nouvelleEnchere.getMontantEnchere() < 0) {
			throw new BLLexception("Montant insuffisant");
		}

		if (nouvelleEnchere.getDateEnchere().after(articleVendu.getDateFinEncheres())) {
			throw new BLLexception("Vente finie");
		}

		if (articleVendu.getPrixVente() >= nouvelleEnchere.getMontantEnchere()) {
			throw new BLLexception("Enchère insuffisante");
		}

		nouvelleEnchere.setArticleVendu(articleVendu);
		nouvelleEnchere.setUtilisateur(utilisateur);
		this.listeEncheres.add(nouvelleEnchere);
		try {
			DAOFactory.getDaoEnchere().insert(nouvelleEnchere);
		} catch (Exception e) {
			throw new BLLexception("Erreur à l'insertion de l'enchère dans la base de données");
		}
	}

	@Override
	public void remporterVente(Utilisateur utilisateur) throws BLLexception {
		// TODO Auto-generated method stub
	}

	public void testArticleVendu(ArticleVendu articleVendu) throws BLLexception {
		boolean erreur = false;
		StringBuilder stringErreur = new StringBuilder();

		if (articleVendu.getCategorieArticle() == null) {
			erreur = true;
			stringErreur.append("Catégorie de l'article manquant");
		}

		if (articleVendu.getDateDebutEncheres() == null) {
			erreur = true;
			stringErreur.append("Catégorie de l'article manquant");
		}

		if (articleVendu.getDateFinEncheres() == null) {
			erreur = true;
			stringErreur.append("Catégorie de l'article manquant");
		}

		if (articleVendu.getDescription() == null) {
			erreur = true;
			stringErreur.append("Catégorie de l'article manquant");
		}

		if (articleVendu.getMiseAPrix() == null) {
			erreur = true;
			stringErreur.append("Catégorie de l'article manquant");
		}

		if (articleVendu.getNomArticle() == null) {
			erreur = true;
			stringErreur.append("Catégorie de l'article manquant");
		}

		if (articleVendu.getUtilisateur() == null) {
			erreur = true;
			stringErreur.append("Catégorie de l'article manquant");
		}

		if (erreur) {
			throw new BLLexception(stringErreur.toString());
		}
	}

}
