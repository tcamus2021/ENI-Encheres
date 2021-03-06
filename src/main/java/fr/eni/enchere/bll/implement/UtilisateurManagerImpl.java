package fr.eni.enchere.bll.implement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bll.interfaces.UtilisateurManager;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;

public class UtilisateurManagerImpl implements UtilisateurManager {
	private List<Utilisateur> listeUtilisateurs = new ArrayList<>();

	@Override
	public void inscription(Utilisateur utilisateur) throws BLLexception {
		try {
			this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll();
		} catch (Exception e) {
			throw new BLLexception("Erreur à la récupération de tous les utilisateurs");
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
				if (utilisateurForEach.getPseudo().equals(pseudo) || utilisateurForEach.getEmail().equals(pseudo)) {
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
			miseAJourListe();
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
				if (utilisateurForEach.getPseudo().equals(utilisateur.getPseudo())) {
					DAOFactory.getDaoUtilisateurs().delete(utilisateurForEach.getNoUtilisateur());
				}
			}
		} catch (Exception e) {
			throw new BLLexception(e.getMessage());
		}
	}

	/**
	 * Pour savoir si un utilisateur est conforme au niveau des données
	 * 
	 * @param utilisateur
	 * @throws BLLexception
	 */
	public void testUtilisateur(Utilisateur utilisateur) throws BLLexception {
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer un pseudo");
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer un nom");
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer un prénom");
		}
		if (utilisateur.getEmail() == null || utilisateur.getEmail().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer un email");
		}
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer un numéro de téléphone");
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer une rue");
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal() == 0) {
			throw new BLLexception("Erreur, veuillez rentrer un code postal");
		}
		if (utilisateur.getVille() == null || utilisateur.getVille().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer une ville");
		}
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().equals("")) {
			throw new BLLexception("Erreur, veuillez rentrer un mot de passe");
		}
		if (utilisateur.getAdministrateur() == null) {
			throw new BLLexception("Erreur, administrateur manquant");
		}
		String testCaractereSpeciaux = utilisateur.getPseudo().replaceAll("[^A-Za-z0-9]", "");
		if (!testCaractereSpeciaux.equals(utilisateur.getPseudo())) {
			throw new BLLexception("Uniquement les caractères alphanumérique dans le pseudo");
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
		for (Utilisateur utilisateurForEach : this.listeUtilisateurs) {
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
			throw new BLLexception("Mot de passe incorrect");
		}
	}

	public void miseAJourListe() throws BLLexception {
		try {
			this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll();

			List<Utilisateur> modification = new ArrayList<>();
			Map<Integer, Integer> lienUtilisateurEncheres = DAOFactory.getDaoLien().lienEnchereUtilisateur();

			for (Map.Entry<Integer, Integer> iteration : lienUtilisateurEncheres.entrySet()) {
				Utilisateur utilisateurCourant = DAOFactory.getDaoUtilisateurs().getById(iteration.getValue());
				Enchere enchereCourant = DAOFactory.getDaoEnchere().getById(iteration.getKey());

				for (Utilisateur utilisateurForEach : modification) {
					if (utilisateurForEach.getNoUtilisateur() == utilisateurCourant.getNoUtilisateur()) {
						utilisateurCourant = utilisateurForEach;
						modification.remove(utilisateurForEach);
					}
				}

				if (enchereCourant.getIdEnchere() != null) {
					enchereCourant.setUtilisateur(utilisateurCourant);
					utilisateurCourant.addListeEncheres(enchereCourant);

					modification.add(utilisateurCourant);
				}
			}

			for (Utilisateur utilisateur : this.listeUtilisateurs) {
				boolean trouve = false;
				for (Utilisateur utilisateurAvecEnchere : modification) {
					if(utilisateur.getNoUtilisateur() == utilisateurAvecEnchere.getNoUtilisateur()) {
						trouve = true;
					}
				}
				if(!trouve) {
					modification.add(utilisateur);
				}
			}

			this.listeUtilisateurs = modification;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BLLexception("Erreur lors de la mise à jour de la liste");
		}
	}
}
