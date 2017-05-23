package model;

import java.util.Observable;

import controller.LoginController;

public class LoginModel extends Observable {

	private LoginController controller;
	
	public LoginModel(LoginController controller) {
		this.controller = controller;
	}
	
	public void Connection(String name, String password) throws Exception {
		boolean res = true;
		if (res) {
			return;
		} else {
			throw new Exception("Identifiant ou mot de passe incorrect");
		}
	}
	
}
