package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.EventController;

public class EventView {

	private EventController controller;
	private JPanel panPrinc;
	
	private JButton butAjout;
	private JButton butInformations;
	
	private JTable tabEvent;
	private JScrollPane paneEvent;
	
	public EventView(EventController controller) {
		this.controller = controller;
		
		this.afficher();
	}
	
	public void afficher() {
		this.panPrinc = new JPanel();
		this.panPrinc.setLayout(new BorderLayout());
		
		//Panel haut
		JPanel panHaut = new JPanel();
		panHaut.setLayout(new BoxLayout(panHaut, BoxLayout.LINE_AXIS));
		panHaut.setBorder(new EmptyBorder(10, 0, 0, 0));
		JLabel labFiltre = new JLabel("Filtrer le lieu :");
		JComboBox<String> comboFiltre = new JComboBox<String>();
		this.butAjout = new JButton();

		panHaut.add(Box.createHorizontalStrut(50));
		panHaut.add(labFiltre);
		panHaut.add(Box.createHorizontalStrut(10));
		panHaut.add(comboFiltre);
		panHaut.add(Box.createHorizontalStrut(250));
		panHaut.add(this.butAjout);
		panHaut.add(Box.createHorizontalStrut(50));
		
		//Milieu
		JPanel panMid = new JPanel();
		panMid.setLayout(new BoxLayout(panMid, BoxLayout.PAGE_AXIS));
		
		JTabbedPane tabEvent = new JTabbedPane();
		
		Vector<String> labels = new Vector<String>();
		labels.add("Objet");
		labels.add("Lieu");
		labels.add("Date");
		labels.add("Durée");
		labels.add("Nb de participants");
		Vector<String> list = new Vector<String>();
		this.tabEvent = new JTable(list, labels);
		this.tabEvent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.paneEvent = new JScrollPane(this.tabEvent);
		
		tabEvent.add("Tous les évènements", this.paneEvent);
		tabEvent.add("Participations", tabEvent.getTabComponentAt(0));
		tabEvent.add("Mes évènements", tabEvent.getTabComponentAt(0));
		tabEvent.setPreferredSize(new Dimension(700,420));

		panMid.add(Box.createVerticalStrut(20));
		panMid.add(tabEvent);
		
		//Panel bas
		JPanel panBas = new JPanel();
		panBas.setLayout(new BoxLayout(panBas, BoxLayout.PAGE_AXIS));
		this.butInformations = new JButton();

		panBas.add(Box.createVerticalStrut(20));
		panBas.add(this.butInformations);
		
		this.panPrinc.add(panHaut, BorderLayout.NORTH);
		this.panPrinc.add(panMid, BorderLayout.CENTER);
		this.panPrinc.add(panBas, BorderLayout.SOUTH);
	}
	
	public JTable getTable() {
		return this.tabEvent;
	}
	
	public JPanel getPanel() {
		return this.panPrinc;
	}
	
	public JButton getButAjouter() {
		return this.butAjout;
	}
	
	public JButton getButInformations() {
		return this.butInformations;
	}
}
