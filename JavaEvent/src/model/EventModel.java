package model;

import controller.EventController;
import database.User;

public class EventModel {

	private User user;
	private EventController controller;
	
	public EventModel(EventController controller, User user) {
		this.controller = controller;
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
	
}
