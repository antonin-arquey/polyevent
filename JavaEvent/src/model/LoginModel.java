package model;

import java.util.Observable;

import controller.LoginController;
import database.User;
import database.UserDAO;

public class LoginModel extends Observable {

	private LoginController controller;
	
	public LoginModel(LoginController controller) {
		this.controller = controller;
	}
	
	public User Connection(String name, String password) throws Exception {
		boolean res = true;
		UserDAO userdao = new UserDAO();
		User user = userdao.connexion(name, password);
		if (res) {
			return user;
		} else {
			throw new Exception("Identifiant ou mot de passe incorrect");
		}
	}
	
}
