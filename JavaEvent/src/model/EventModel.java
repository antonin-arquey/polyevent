package model;

import java.util.HashSet;
import java.util.Vector;

import controller.EventController;
import database.Event;
import database.User;

public class EventModel {

	private User user;
	private EventController controller;
	HashSet<Event> events;
	
	public EventModel(EventController controller, User user) {
		this.controller = controller;
		this.user = user;
	}
	
	public void setEvents(HashSet<Event> events) {
		this.events = events;
	}
	
	public Vector<Vector<String>> getList() {
		Vector<Vector<String>> ret = new Vector<Vector<String>>();
		for (Event e: this.events) {
			Vector<String> ite = new Vector<String>();
			ite.add(e.getName());
			ite.add(e.getLieu());
			ite.add(e.getDate_event().toString());
			ite.add("Soon");
			ite.add(Integer.toString(e.getParticipants().size()));
			
			ret.add(ite);
		}
		return ret;
	}
	
	public HashSet<Event> getEvents() {
		return this.events;
	}
	
	public User getUser() {
		return this.user;
	}
	
}
