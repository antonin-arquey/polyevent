package controller;

import view.FenetrePrincipale;

/**
 * Contrôleur principal lors du lancement de l'application
 * S'occupe de créer l'interface graphique et de lancer le premier controleur lié à la vue (login)
 * @author Nicolas
 */
public class FenetreController {

	private FenetrePrincipale fenetre;
	
	public FenetreController() {
		//On créer la vue principale qui contient la JFrame (liée à ce contrôleur)
		this.fenetre = new FenetrePrincipale();
		//Puis on affiche la première vraie interface graphique (authentification)
		this.loginPage();
	}
	
	/**
	 * Affiche la partie authentification de l'application
	 */
	public void loginPage() {
		//On créer d'abord le contrôleur (qui créé lui même la vue)
		LoginController login = new LoginController(this);
		//Puis on n'oublie pas de changer le panel affiché sur le JFrame principal
		fenetre.setPanelPrincipale(login.getView().getPanel());
	}
	
}
