package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;

/**
 * Contrôleur de la partie authentification
 * @author Nicolas
 */
public class LoginController implements ActionListener {

	private FenetreController controller;
	private LoginView view;
	
	public LoginController(FenetreController controller) {
		this.controller = controller;
		this.view = new LoginView(this);
	}
	
	public LoginView getView() {
		return this.view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.view.getButConnecter()) {
			//Faire le code quand il se connecte
		}
	}
	
}
