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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import controller.EventController;

public class EventView {

	private EventController controller;
	private JPanel panPrinc;
	
	private JComboBox<String> comboFiltre;
	
	private JTabbedPane tabbedEvent;
	
	private Vector<Vector<String>> list;
	private Vector<Vector<String>> listPart;
	private Vector<Vector<String>> listMes;
	
	private JButton butAjout;
	private JButton butInformations;
	
	private JTable tabEvent;
	private JScrollPane paneEvent;
	private JTable tabEventPart;
	private JScrollPane paneEventPart;
	private JTable tabEventMes;
	private JScrollPane paneEventMes;
	
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
		this.comboFiltre = new JComboBox<String>();
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
		
		this.tabbedEvent = new JTabbedPane();
		
		Vector<String> labels = new Vector<String>();
		labels.add("ID");
		labels.add("Objet");
		labels.add("Lieu");
		labels.add("Date");
		labels.add("Durée");
		labels.add("Nb de participants");
		this.list = new Vector<Vector<String>>();
		
		Vector<String> labelsPart = new Vector<String>();
		labelsPart.add("ID");
		labelsPart.add("Objet");
		labelsPart.add("Lieu");
		labelsPart.add("Date");
		labelsPart.add("Nb de participants");
		labelsPart.add("Statut");
		this.listPart = new Vector<Vector<String>>();
		
		Vector<String> labelsMes = new Vector<String>();
		labelsMes.add("ID");
		labelsMes.add("Objet");
		labelsMes.add("Lieu");
		labelsMes.add("Date");
		labelsMes.add("Durée");
		labelsMes.add("Nb de participants");
		this.listMes = new Vector<Vector<String>>();
		
		this.tabEvent = new JTable(list, labels);
		this.tabEvent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.paneEvent = new JScrollPane(this.tabEvent);
		
		this.tabEventPart = new JTable(listPart, labelsPart);
		this.tabEventPart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.paneEventPart = new JScrollPane(this.tabEventPart);
		
		this.tabEventMes = new JTable(listMes, labelsMes);
		this.tabEventMes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.paneEventMes = new JScrollPane(this.tabEventMes);
		
		this.tabbedEvent.add("Tous les évènements", this.paneEvent);
		this.tabbedEvent.add("Participations", this.paneEventPart);
		this.tabbedEvent.add("Mes évènements", this.paneEventMes);
		this.tabbedEvent.setPreferredSize(new Dimension(700,420));

		panMid.add(Box.createVerticalStrut(20));
		panMid.add(this.tabbedEvent);
		
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
	
	public JTable getTablePart() {
		return this.tabEventPart;
	}
	
	public JTable getTableMes() {
		return this.tabEventMes;
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
	
	public void setList(Vector<Vector<String>> list) {
		this.list = list;
	}
	
	public JComboBox<String> getComboFiltre() {
		return this.comboFiltre;
	}
	
	public JTabbedPane getTabbedPane() {
		return this.tabbedEvent;
	}
	
}
