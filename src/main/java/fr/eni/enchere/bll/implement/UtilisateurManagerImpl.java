package fr.eni.enchere.bll.implement;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bll.interfaces.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;

public class UtilisateurManagerImpl implements UtilisateurManager {
	private List<Utilisateur> listeUtilisateurs = new ArrayList<>();

	@Override
	public void inscription(Utilisateur utilisateur) throws BLLexception {
		try {
			this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération de tout les utilisateurs");
		}

		testUtilisateur(utilisateur);

		for (Utilisateur utilisateurForEach : this.listeUtilisateurs) {
			if (utilisateurForEach.getPseudo().equals(utilisateur.getPseudo())) {
				throw new BLLexception("Pseudo déjà existant");
			}
			if (utilisateurForEach.getEmail().equals(utilisateur.getEmail())) {
				throw new BLLexception("Email déjà existant");
			}
		}

		Utilisateur nouvelUtilisateur = new Utilisateur();
		nouvelUtilisateur = utilisateur;
		nouvelUtilisateur.setCredit(100);
		Integer motDePasseChiffrer = nouvelUtilisateur.getMotDePasse().hashCode();
		nouvelUtilisateur.setMotDePasse(motDePasseChiffrer.toString());
		try {
			DAOFactory.getDaoUtilisateurs().insert(nouvelUtilisateur);
		} catch (Exception e) {
			throw new BLLexception(e.getMessage());
		}
	}

	@SuppressWarnings("unused")
	@Override
	public Utilisateur getUtilisateurByPseudo(String pseudo) throws BLLexception {
		Utilisateur ret = new Utilisateur();
		try {
			this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll();
			for (Utilisateur utilisateurForEach : listeUtilisateurs) {
				if (utilisateurForEach.getPseudo().equals(pseudo)) {
					ret = utilisateurForEach;
				}
			}
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération de l'utilisateur");
		}
		if (ret == null) {
			throw new BLLexception("Utilisateur non existant");
		}
		return ret;
	}

	@Override
	public List<Utilisateur> getAll() throws BLLexception {
		try {
			this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération des utilisateurs");
		}
		return this.listeUtilisateurs;
	}

	@Override
	public void update(Utilisateur utilisateur) throws BLLexception {
		try {
			testUtilisateur(utilisateur);
			DAOFactory.getDaoUtilisateurs().update(utilisateur);
		} catch (Exception e) {
			throw new BLLexception(e.getMessage());
		}
	}

	@Override
	public void delete(Utilisateur utilisateur) throws BLLexception {
		try {
			this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll();
			testUtilisateur(utilisateur);
			for (Utilisateur utilisateurForEach : listeUtilisateurs) {
				if(utilisateurForEach.getPseudo().equals(utilisateur.getPseudo())) {
					DAOFactory.getDaoUtilisateurs().delete(utilisateurForEach.getNoUtilisateur());
				}
			}
		} catch (Exception e) {
			throw new BLLexception(e.getMessage());
		}
	}

	public void testUtilisateur(Utilisateur utilisateur) throws BLLexception {
		if (utilisateur.getPseudo() == null) {
			throw new BLLexception("Erreur, veuillez rentrer un pseudo");
		}
		if (utilisateur.getNom() == null) {
			throw new BLLexception("Erreur, veuillez rentrer un nom");
		}
		if (utilisateur.getPrenom() == null) {
			throw new BLLexception("Erreur, veuillez rentrer un prénom");
		}
		if (utilisateur.getEmail() == null) {
			throw new BLLexception("Erreur, veuillez rentrer un email");
		}
		if (utilisateur.getTelephone() == null) {
			throw new BLLexception("Erreur, veuillez rentrer un numéro de téléphone");
		}
		if (utilisateur.getRue() == null) {
			throw new BLLexception("Erreur, veuillez rentrer une rue");
		}
		if (utilisateur.getCodePostal() == null) {
			throw new BLLexception("Erreur, veuillez rentrer un code postal");
		}
		if (utilisateur.getVille() == null) {
			throw new BLLexception("Erreur, veuillez rentrer une ville");
		}
		if (utilisateur.getMotDePasse() == null) {
			throw new BLLexception("Erreur, veuillez rentrer un mot de passet");
		}
		if (utilisateur.getAdministrateur() == null) {
			throw new BLLexception("Erreur,administrateur manquant");
		}
		String testCaractereSpeciaux = utilisateur.getPseudo().replaceAll("[^A-Za-z0-9]", "");
		if (testCaractereSpeciaux.equals(utilisateur.getPseudo())) {
			throw new BLLexception("Uniquement les caractères alphanumérique");
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void verifierInscription(String login, String motDePasse) throws BLLexception {
		try {
			this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll();
		} catch (Exception e) {
			throw new BLLexception(e.getMessage());
		}

		Utilisateur utilisateurCourant = new Utilisateur();
		for (Utilisateur utilisateurForEach : listeUtilisateurs) {
			if (utilisateurForEach.getPseudo().equals(login)) {
				utilisateurCourant = utilisateurForEach;
			}
			if (utilisateurForEach.getEmail().equals(login)) {
				utilisateurCourant = utilisateurForEach;
			}
		}

		if (utilisateurCourant == null) {
			throw new BLLexception("Login erroné");
		}

		Integer motDePasseChiffrer = motDePasse.hashCode();

		if (!motDePasseChiffrer.toString().equals(utilisateurCourant.getMotDePasse())) {
			throw new BLLexception("Mot de passe incorectes");
		}
	}
}
