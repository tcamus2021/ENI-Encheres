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
			
			if(articleVendu.getCategorieArticle().getNoCategorie() == null) {
				throw new BLLexception("Veuillez choisir une catégorie");
			}

			if (articleVendu.getDateDebutEncheres().before(Date.valueOf(LocalDate.now()))) {
				throw new BLLexception("Date de début de la vente antérieur à la date du jour");
			}

			if (articleVendu.getDateDebutEncheres().after(articleVendu.getDateFinEncheres())) {
				throw new BLLexception("Date de début de la vente antérieur à la date de la fin de la vente");
			}
			
			DAOFactory.getDaoArticlesVendus().insert(articleVendu);
			
			this.listeArticleVendu = DAOFactory.getDaoArticlesVendus().getAll();
			for (ArticleVendu articleVenduForEach : listeArticleVendu) {
				if(articleVendu.getNomArticle().equals(articleVenduForEach.getNomArticle())
						&& articleVendu.getDescription().equals(articleVenduForEach.getDescription())){
					articleVendu.setNoArticle(articleVenduForEach.getNoArticle());
				}
			}
			
			DAOFactory.getDaoRetrait().insert(articleVendu.getLieuRetrait());
			
		} catch (Exception e) {
			throw new BLLexception(e.getMessage());
		}
	}

	@Override
	public List<Enchere> getAllEnchere() throws BLLexception {
		try {
			this.listeEncheres = DAOFactory.getDaoEnchere().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération des différentes enchères");
		}
		return this.listeEncheres;
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws BLLexception {
		try {
			this.listeArticleVendu = DAOFactory.getDaoArticlesVendus().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération des différents articles");
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
			stringErreur.append("Date de début de l'article manquant");
		}

		if (articleVendu.getDateFinEncheres() == null) {
			erreur = true;
			stringErreur.append("Date de fin de l'article manquant");
		}

		if (articleVendu.getDescription() == null) {
			erreur = true;
			stringErreur.append("Description de l'article manquant");
		}

		if (articleVendu.getMiseAPrix() == null) {
			erreur = true;
			stringErreur.append("Mise à prix de l'article manquant");
		}

		if (articleVendu.getNomArticle() == null) {
			erreur = true;
			stringErreur.append("Nom de l'article manquant");
		}

		if (articleVendu.getUtilisateur() == null) {
			erreur = true;
			stringErreur.append("Utilisateur de l'article manquant");
		}

		if (erreur) {
			throw new BLLexception(stringErreur.toString());
		}
	}

}
