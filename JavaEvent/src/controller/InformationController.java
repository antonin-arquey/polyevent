package controller;

import database.Event;
import database.User;
import model.InformationModel;
import view.InformationView;

public class InformationController {
	
	FenetreController controller;
	InformationView view;
	InformationModel model;
	
	User user;
	Event event;
	
	public InformationController(FenetreController controller, User user, Event event) {
		this.controller = controller;
		this.view = new InformationView(this);
		this.user = user;
		this.event = event;
		
		view.setTitre(event.getName());
		view.setDescription("Description : " + event.getSummary());
		view.setLieu("Lieu : " + event.getLieu());
		view.setRespo("Responsable : " + event.getCreator().getFirstName());
		view.setParticipants(event.getParticipants() + " / ");
		view.setDate("Début : " + event.getDate_event());
		view.setInscription("Inscriptions ouvertes");
	}
	
	public InformationView getView() {
		return this.view;
	}

}
