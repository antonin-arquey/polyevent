package controller;

import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import controller.AddController.Cancel;
import database.DAOException;
import database.Event;
import database.EventDAO;
import database.User;
import model.InformationModel;
import view.InformationView;

public class InformationController {
	
	FenetreController controller;
	InformationView view;
	InformationModel model;
	
	User user;
	Event event;
	
	private Back back;
	private Participer participer;
	
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
		
		this.back = new Back();
		this.view.getButRetour().setAction(back);
		
		this.participer = new Participer();
		this.view.getButParticiper().setAction(participer);
	}
	
	public InformationView getView() {
		return this.view;
	}
	
	public class Back extends AbstractAction implements Observer {
		public Back() {
			super("Retour");
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.eventPage(user);
		}
		
		@Override
		public void update(Observable arg0, Object arg1) {
			
		}
	}
	
	public class Participer extends AbstractAction implements Observer {
		public Participer() {
			super("Créer");
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Participation");
				try{
					try {
						new EventDAO().addParticipant(event, user);;
					} catch (DAOException d) {
						System.out.println(d.getMessage());
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
	}
}
