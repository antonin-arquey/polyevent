package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import model.LoginModel;
import view.LoginView;

/**
 * Contrôleur de la partie authentification
 * @author Nicolas
 */
public class LoginController {

	FenetreController controller;
	LoginView view;
	LoginModel model;
	
	private Connection actionConnection;
	
	public LoginController(FenetreController controller) {
		this.controller = controller;
		this.view = new LoginView(this);
		this.model = new LoginModel(this);
		
		this.actionConnection = new Connection();
		this.view.getButConnecter().setAction(this.actionConnection);
	}
	
	//oui
	public LoginView getView() {
		return this.view;
	}

	public class Connection extends AbstractAction implements Observer {

		public Connection() {
			super("Connection");
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				model.Connection(view.getName(), view.getPassword());
				controller.eventPage();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		@Override
		public void update(Observable o, Object arg) {

		}
	}
	
}
