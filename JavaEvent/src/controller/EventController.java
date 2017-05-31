package controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import database.EventDAO;
import database.User;
import model.EventModel;
import view.EventView;

public class EventController {
	
	FenetreController controller;
	EventView view;
	EventModel model;
	
	Ajouter actionAjouter;
	Informations actionInformations;
	
	public EventController(FenetreController controller, User user) {
		this.controller = controller;
		this.view = new EventView(this);
		this.model = new EventModel(this, user);
		
		this.actionAjouter = new Ajouter();
		this.view.getButAjouter().setAction(this.actionAjouter);
		this.actionInformations = new Informations();
		this.view.getButInformations().setAction(this.actionInformations);

		EventDAO events = new EventDAO();
		this.model.setEvents(events.findAll());
		this.view.setList(this.model.getList());
	}
	
	public EventView getView() {
		return this.view;
	}
	
	public class Ajouter extends AbstractAction implements Observer {
		
		public Ajouter() {
			super("+");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.addPage(model.getUser());
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			
		}
		
	}
	
	public class Informations extends AbstractAction implements Observer {
		
		public Informations() {
			super("Plus d'informations");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.informationPage();
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			
		}
		
	}
	
}
