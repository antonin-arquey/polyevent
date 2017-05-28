package model;

import controller.AddController;
import database.User;

public class AddModel {

	AddController controller;
	User user;
	
	public AddModel(AddController controller, User user) {
		this.controller = controller;
		this.user = user;
	}
	
	public boolean createEvent(String name, String summary, String date) {
		return true;
	}
	
	public User getUser() {
		return this.user;
	}
	
}
