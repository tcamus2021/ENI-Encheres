package fr.eni.enchere.bll.implement;

import java.util.List;

import fr.eni.enchere.bll.BLLexception;
import fr.eni.enchere.bll.interfaces.UtilisateurManager;
import fr.eni.enchere.bll.interfaces.VenteManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

public class VenteManagerImpl implements VenteManager, UtilisateurManager {

	@Override
	public void seConnecter() throws BLLexception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inscription(Utilisateur utilisateur) throws BLLexception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seDeconnecter() throws BLLexception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur getUtilisateurByPseudo() throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getAll() throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur delete(Utilisateur utilisateur) throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vendre(ArticleVendu articleVendu) throws BLLexception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> getAllEnchere() throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAllCategorie() throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> getAllRetrait() throws BLLexception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void encherir(Enchere enchere) throws BLLexception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remporterVente(Utilisateur utilisateur) throws BLLexception {
		// TODO Auto-generated method stub
		
	}

}
