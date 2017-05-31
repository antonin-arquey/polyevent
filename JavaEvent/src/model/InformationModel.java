package model;

import controller.AddController;
import controller.InformationController;
import database.User;

public class InformationModel {
	
	InformationController controller;
	User user;
	
	public InformationModel(InformationController controller, User user) {
		this.controller = controller;
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
}
