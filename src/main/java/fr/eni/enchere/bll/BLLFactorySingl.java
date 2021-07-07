package fr.eni.enchere.bll;

import fr.eni.enchere.bll.implement.UtilisateurManagerImpl;
import fr.eni.enchere.bll.implement.VenteManagerImpl;
import fr.eni.enchere.bll.interfaces.UtilisateurManager;
import fr.eni.enchere.bll.interfaces.VenteManager;

public class BLLFactorySingl {
	private static UtilisateurManager instanceUtilisateur;
	private static VenteManager instanceVente;
	
	public static UtilisateurManager createInstanceUtilisateur () {
		if (instanceUtilisateur == null) {
			instanceUtilisateur = new UtilisateurManagerImpl();
		}
		return instanceUtilisateur;
	}
	
	public static VenteManager createInstanceVente () {
		if (instanceVente == null) {
			instanceVente = new VenteManagerImpl();
		}
		return instanceVente;
	}
}
