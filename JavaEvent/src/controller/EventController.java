package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
	Filtre actionFiltre;

	public EventController(FenetreController controller, User user) {
		this.controller = controller;
		this.view = new EventView(this);
		this.model = new EventModel(this, user);

		this.actionAjouter = new Ajouter();
		this.view.getButAjouter().setAction(this.actionAjouter);
		this.actionInformations = new Informations();
		this.view.getButInformations().setAction(this.actionInformations);
		this.actionFiltre = new Filtre();
		this.view.getComboFiltre().setAction(this.actionFiltre);
		
		this.view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (view.getTable().getSelectedRow() == -1) view.getButInformations().setEnabled(false);
				else view.getButInformations().setEnabled(true);
			}
		});
		
		this.view.getTablePart().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (view.getTablePart().getSelectedRow() == -1) view.getButInformations().setEnabled(false);
				else view.getButInformations().setEnabled(true);
			}
		});
		
		this.view.getTableMes().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (view.getTableMes().getSelectedRow() == -1) view.getButInformations().setEnabled(false);
				else view.getButInformations().setEnabled(true);
			}
		});
		
		EventDAO events = new EventDAO();
		this.model.setEvents(events.findAll());
		this.model.setEventsPart(events.getUserEventParticipate(user));
		this.model.setEventsMes(events.getUserEventCreated(user));

		List<String> tmpFiltre = new ArrayList<String>();
		tmpFiltre.add("Tous");

		DefaultTableModel model = (DefaultTableModel) this.view.getTable().getModel();
		for (Vector<String> v : this.model.getList()) {
			model.addRow(v);
			if (!tmpFiltre.contains(v.get(1))) {
				tmpFiltre.add(v.get(1));
			}
		}

		DefaultTableModel model1 = (DefaultTableModel) this.view.getTablePart().getModel();
		for (Vector<String> v : this.model.getListPart()) {
			model1.addRow(v);
		}

		DefaultTableModel model2 = (DefaultTableModel) this.view.getTableMes().getModel();
		for (Vector<String> v : this.model.getListMes()) {
			model2.addRow(v);
		}

		for (String s : tmpFiltre) {
			this.view.getComboFiltre().addItem(s);
		}
	}

	public EventView getView() {
		return this.view;
	}

	public class Filtre extends AbstractAction implements Observer {

		public Filtre() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int selected = ((JComboBox)arg0.getSource()).getSelectedIndex();

			int tabbedIndex = view.getTabbedPane().getSelectedIndex();

			if (tabbedIndex == 0) {
				DefaultTableModel modelTable = (DefaultTableModel) view.getTable().getModel();
				if (modelTable.getRowCount() > 0) {
					for (int i = modelTable.getRowCount() - 1; i > -1; i--) {
						modelTable.removeRow(i);
					}
				}
				if (selected == 0) {
					for (Vector<String> v : model.getList()) {
						modelTable.addRow(v);
					}
				} else {
					String selectedFiltre = (String) ((JComboBox)arg0.getSource()).getSelectedItem();
					for (Vector<String> v : model.getList()) {
						if (v.get(1).equals(selectedFiltre)) modelTable.addRow(v);
					}
				}
			} else if (tabbedIndex == 1) {
				DefaultTableModel modelTable = (DefaultTableModel) view.getTablePart().getModel();
				if (modelTable.getRowCount() > 0) {
					for (int i = modelTable.getRowCount() - 1; i > -1; i--) {
						modelTable.removeRow(i);
					}
				}
				if (selected == 0) {
					for (Vector<String> v : model.getListPart()) {
						modelTable.addRow(v);
					}
				} else {
					String selectedFiltre = (String) ((JComboBox)arg0.getSource()).getSelectedItem();
					for (Vector<String> v : model.getListPart()) {
						if (v.get(1).equals(selectedFiltre)) modelTable.addRow(v);
					}
				}
			} else {
				DefaultTableModel modelTable = (DefaultTableModel) view.getTableMes().getModel();
				if (modelTable.getRowCount() > 0) {
					for (int i = modelTable.getRowCount() - 1; i > -1; i--) {
						modelTable.removeRow(i);
					}
				}
				if (selected == 0) {
					for (Vector<String> v : model.getListMes()) {
						modelTable.addRow(v);
					}
				} else {
					String selectedFiltre = (String) ((JComboBox)arg0.getSource()).getSelectedItem();
					for (Vector<String> v : model.getListMes()) {
						if (v.get(1).equals(selectedFiltre)) modelTable.addRow(v);
					}
				}
			}

		}

		@Override
		public void update(Observable arg0, Object arg1) {

		}

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
			this.setEnabled(false);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int tabbedIndex = view.getTabbedPane().getSelectedIndex();
			String id = "";
			if (tabbedIndex == 0) {
				id = (String) view.getTable().getValueAt(view.getTable().getSelectedRow(), 0);
			} else if (tabbedIndex == 1) {
				id = (String) view.getTablePart().getValueAt(view.getTablePart().getSelectedRow(), 0);
			} else {
				id = (String) view.getTableMes().getValueAt(view.getTableMes().getSelectedRow(), 0);
			}
			controller.informationPage(model.getUser(), new EventDAO().find(Integer.parseInt(id)));
		}

		@Override
		public void update(Observable o, Object arg) {

		}

	}

}
