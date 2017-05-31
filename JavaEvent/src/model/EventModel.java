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
	HashSet<Event> eventsPart;
	HashSet<Event> eventsMes;
	
	public EventModel(EventController controller, User user) {
		this.controller = controller;
		this.user = user;
	}
	
	public void setEvents(HashSet<Event> events) {
		this.events = events;
	}
	
	public void setEventsPart(HashSet<Event> events) {
		this.eventsPart = events;
	}
	
	public void setEventsMes(HashSet<Event> events) {
		this.eventsMes = events;
	}
	
	public Vector<Vector<String>> getList() {
		Vector<Vector<String>> ret = new Vector<Vector<String>>();
		for (Event e: this.events) {
			Vector<String> ite = new Vector<String>();
			ite.add(Long.toString(e.getId()));
			ite.add(e.getName());
			ite.add(e.getLieu());
			ite.add(e.getDate_event().toString());
			ite.add("Soon");
			ite.add(Integer.toString(e.getParticipants().size()));
			
			ret.add(ite);
		}
		return ret;
	}
	
	public Vector<Vector<String>> getListPart() {
		Vector<Vector<String>> ret = new Vector<Vector<String>>();
		for (Event e: this.eventsPart) {
			Vector<String> ite = new Vector<String>();
			ite.add(Long.toString(e.getId()));
			ite.add(e.getName());
			ite.add(e.getLieu());
			ite.add(e.getDate_event().toString());
			ite.add(Integer.toString(e.getParticipants().size()));
			ite.add("?");
			
			ret.add(ite);
		}
		return ret;
	}
	
	public Vector<Vector<String>> getListMes() {
		Vector<Vector<String>> ret = new Vector<Vector<String>>();
		for (Event e: this.eventsMes) {
			Vector<String> ite = new Vector<String>();
			ite.add(Long.toString(e.getId()));
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
