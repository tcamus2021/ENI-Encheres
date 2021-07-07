package fr.eni.enchere.bll.implement;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bll.BLLFactorySingl;
import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bll.interfaces.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;

public class UtilisateurManagerImpl implements UtilisateurManager {
	UtilisateurManager utilisateurManager = BLLFactorySingl.createInstanceUtilisateur();
	private List<Utilisateur>listeUtilisateurs = new ArrayList<>();
	
	@Override
	public void seConnecter() throws BLLexception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inscription(Utilisateur utilisateur) throws BLLexception {
		this.listeUtilisateurs = DAOFactory.getDaoUtilisateurs().getAll(); 
		// mise à jour de la liste utilisateurs à partir de la liste en BDD
		
		
		Utilisateur nouvelUtilisateur = new Utilisateur();
		nouvelUtilisateur.setCredit(100);
		
		if (nouvelUtilisateur.getPseudo().equals(utilisateur.getPseudo())){
			throw new BLLexception("Utilisateur déjà existant, veuillez vous connecter");
		}
	
		if (nouvelUtilisateur.getEmail().equals(utilisateur.getEmail())){
			throw new BLLexception("Utilisateur déjà existant, veuillez vous connecter");
		}
		 //caractères alphanumériques
		try {
		DAOFactory.getDaoUtilisateurs().insert(nouvelUtilisateur);
		}catch (Exception e) {
			throw new BLLexception("Erreur à l'insertion du nouvel utilisateur à la base de données");
		}
	}

	@Override
	public void seDeconnecter() throws BLLexception {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur getUtilisateurByPseudo() throws BLLexception {
		return utilisateurManager.getUtilisateurByPseudo();
	}

	@Override
	public List<Utilisateur> getAll() throws BLLexception {
		return utilisateurManager.getAll();
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) throws BLLexception {
		return utilisateurManager.update(utilisateur);
	}

	@Override
	public void delete(Utilisateur utilisateur) throws BLLexception {
		utilisateurManager.delete(utilisateur);
	}

}
