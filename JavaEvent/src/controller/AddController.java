package controller;

import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			if (!this.isNotSet()) {
				try{
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				    Date parsedDate = dateFormat.parse(view.getFieldDateBegin().getText() + " " + view.getSpinnerDebutHeures().getValue() + ":" + view.getSpinnerDebutMinutes().getValue());
				    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
					Event event = new Event(view.getName(), view.getFieldDescription().getText(), view.getFieldLocation().getText(), model.getUser(), timestamp);
					try {
						new EventDAO().create(event);
						controller.eventPage(model.getUser());
					} catch (DAOException d) {
						System.out.println(d.getMessage());
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		
		public boolean isNotSet() {
			if (view.getName().isEmpty() || view.getFieldLieu().getText().isEmpty() ||
					view.getFieldDateBegin().getText().isEmpty()
					|| view.getFieldDateEnd().getText().isEmpty() ||
					view.getFieldDescription().getText().isEmpty() ||
					view.getFieldLocation().getText().isEmpty()) {
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
