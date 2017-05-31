package controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import database.User;
import model.AddModel;
import view.AddView;

public class AddController {

	FenetreController controller;
	AddView view;
	AddModel model;
	
	private Create actionCreate;
	private Cancel actionCancel;
	
	public AddController(FenetreController controller, User user) {
		this.controller = controller;
		this.view = new AddView(this);
		this.model = new AddModel(this, user);
		
		this.setEventName();
		
		this.actionCreate = new Create();
		this.view.getButCreate().setAction(this.actionCreate);
		this.actionCancel = new Cancel();
		this.view.getButCancel().setAction(this.actionCancel);
	}
	
	private void setEventName() {
		this.view.setName("Nantarena");
	}
	
	public class Create extends AbstractAction implements Observer {
		public Create() {
			super("Créer");
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			controller.eventPage(model.getUser());
		}
		
		@Override
		public void update(Observable arg0, Object arg1) {
			
		}
	}
	
	public class Cancel extends AbstractAction implements Observer {
		public Cancel() {
			super("Annuler");
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.eventPage(model.getUser());
		}
		
		@Override
		public void update(Observable arg0, Object arg1) {
			
		}
	}
	
	public AddView getView() {
		return this.view;
	}

	
}
