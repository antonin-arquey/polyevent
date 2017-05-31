package controller;

import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import database.DAOException;
import database.Event;
import database.EventDAO;
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
		
		this.actionCreate = new Create();
		this.view.getButCreate().setAction(this.actionCreate);
		this.actionCancel = new Cancel();
		this.view.getButCancel().setAction(this.actionCancel);
	}
	
	public class Create extends AbstractAction implements Observer {
		public Create() {
			super("Créer");
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (this.isNotSet()) {
				Event event = new Event(view.getName(), view.getFieldDescription().getText(), view.getFieldLocation().getText(), model.getUser(), new Timestamp(System.currentTimeMillis()));
				try {
					new EventDAO().create(event);
				} catch (DAOException d) {
					System.out.println(d.getMessage());
				}
				controller.eventPage(model.getUser());
			}
		}
		
		public boolean isNotSet() {
			if (view.getName() != "" || view.getFieldLieu().getText() != "" ||
					view.getFieldDateBegin().getText() != ""
					|| view.getFieldDateEnd().getText() != "" ||
					view.getFieldDescription().getText() != "" ||
					view.getFieldLocation().getText() != "") {
				return true;
			}
			return false;
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
