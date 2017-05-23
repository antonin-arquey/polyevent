package controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import controller.LoginController.Connection;
import model.AddModel;
import model.LoginModel;
import view.AddView;
import view.LoginView;

public class AddController {

	FenetreController controller;
	AddView view;
	AddModel model;
	
	public AddController(FenetreController controller) {
		this.controller = controller;
		this.view = new AddView(this);
		this.model = new AddModel(this);
	}
	
	public AddView getView() {
		return this.view;
	}

	
}
