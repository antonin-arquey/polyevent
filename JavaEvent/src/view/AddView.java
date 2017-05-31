package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.AddController;

public class AddView {

	AddController controller;
	private JPanel panPrinc;

	private JLabel eventName;
	private JTextField fieldLocation;
	private JTextField fieldDateBegin;
	private JTextField fieldDateEnd;
	private JTextArea areaDescription;
	private JButton butCancel;
	private JButton butCreate;

	public AddView(AddController controller) {
		this.controller = controller;
		this.afficher();
	}

	public void afficher() {
		this.panPrinc = new JPanel();
		this.panPrinc.setLayout(new BorderLayout());

		//Panel Haut
		JPanel panHaut = new JPanel();
		panHaut.setLayout(new GridLayout(1, 1));
		panHaut.setBorder(new EmptyBorder(20, 0, 0, 0));
		this.eventName = new JLabel();
		this.eventName.setFont(new Font("Arial", Font.PLAIN, 40));
		this.eventName.setHorizontalAlignment(SwingConstants.CENTER);
		this.eventName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		panHaut.add(this.eventName);

		//Panel Milieu
		JPanel panMid = new JPanel();
		panMid.setLayout(new BoxLayout(panMid, BoxLayout.Y_AXIS));

		JPanel panMid1 = new JPanel();
		panMid1.setLayout(new BoxLayout(panMid1, BoxLayout.X_AXIS));
		JLabel labLieu = new JLabel("Lieu : ");
		labLieu.setFont(new Font("Arial", Font.PLAIN, 20));
		JComboBox<String> comboLieu = new JComboBox<String>();
		comboLieu.setPreferredSize(new Dimension(180,20));
		JLabel labAdresse = new JLabel("Adresse : ");
		labAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		this.fieldLocation = new JTextField();
		this.fieldLocation.setPreferredSize(new Dimension(180,30));
		panMid1.add(labLieu);
		panMid1.add(comboLieu);
		panMid1.add(Box.createRigidArea(new Dimension(40,0)));
		panMid1.add(labAdresse);
		panMid1.add(this.fieldLocation);

		JPanel panMid2 = new JPanel();
		panMid2.setLayout(new BoxLayout(panMid2, BoxLayout.X_AXIS));
		JLabel labDebut = new JLabel("Début : ");
		labDebut.setFont(new Font("Arial", Font.PLAIN, 20));
		this.fieldDateBegin = new JTextField();
		this.fieldDateBegin.setPreferredSize(new Dimension(180,30));
		this.fieldDateBegin.setMaximumSize(new Dimension(180,30));
		JLabel labA = new JLabel("  à  ");
		labA.setFont(new Font("Arial", Font.PLAIN, 20));
		JComboBox<String> comboHeures = new JComboBox<String>();
		comboHeures.setPreferredSize(new Dimension(80,30));
		comboHeures.setMaximumSize(new Dimension(80,30));
		panMid2.add(labDebut);
		panMid2.add(this.fieldDateBegin);
		panMid2.add(labA);
		panMid2.add(comboHeures);
		panMid2.add(Box.createHorizontalGlue());

		JPanel panMid3 = new JPanel();
		panMid3.setLayout(new BoxLayout(panMid3, BoxLayout.X_AXIS));
		JLabel labFin = new JLabel("Fin : ");
		labFin.setFont(new Font("Arial", Font.PLAIN, 20));
		this.fieldDateEnd = new JTextField();
		this.fieldDateEnd.setPreferredSize(new Dimension(180,30));
		this.fieldDateEnd.setMaximumSize(new Dimension(180,30));
		JLabel labA2 = new JLabel("  à  ");
		labA2.setFont(new Font("Arial", Font.PLAIN, 20));
		JComboBox<String> comboHeures2 = new JComboBox<String>();
		comboHeures2.setPreferredSize(new Dimension(80,30));
		comboHeures2.setMaximumSize(new Dimension(80,30));
		panMid3.add(labFin);
		panMid3.add(this.fieldDateEnd);
		panMid3.add(labA2);
		panMid3.add(comboHeures2);
		panMid3.add(Box.createHorizontalGlue());

		JPanel panMid4 = new JPanel();
		panMid4.setLayout(new BoxLayout(panMid4, BoxLayout.X_AXIS));
		JLabel labPlaces = new JLabel("Nombre de places : ");
		labPlaces.setFont(new Font("Arial", Font.PLAIN, 20));
		JSpinner spinPlaces = new JSpinner(); 
		spinPlaces.setPreferredSize(new Dimension(60,30));
		spinPlaces.setMaximumSize(new Dimension(60,30));
		panMid4.add(labPlaces);
		panMid4.add(spinPlaces);
		panMid4.add(Box.createHorizontalGlue());
		
		JPanel panLab = new JPanel();
		panLab.setLayout(new BorderLayout());
		JLabel labDescription = new JLabel("Description", SwingConstants.LEFT);
		labDescription.setFont(new Font("Arial", Font.PLAIN, 20));
		panLab.add(labDescription, BorderLayout.WEST);
		
		this.areaDescription = new JTextArea();
		JScrollPane paneDescription = new JScrollPane(this.areaDescription);
		paneDescription.setPreferredSize(new Dimension(550,150));
		paneDescription.setMaximumSize(new Dimension(550,150));
		this.areaDescription.setLineWrap(true);
		this.areaDescription.setWrapStyleWord(true);
		
		panMid.add(Box.createRigidArea(new Dimension(0,30)));
		panMid.add(panMid1);
		panMid.add(Box.createRigidArea(new Dimension(0,20)));
		panMid.add(panMid2);
		panMid.add(Box.createRigidArea(new Dimension(0,20)));
		panMid.add(panMid3);
		panMid.add(Box.createRigidArea(new Dimension(0,20)));
		panMid.add(panMid4);
		panMid.add(Box.createRigidArea(new Dimension(0,20)));
		panMid.add(panLab);
		panMid.add(paneDescription);
		panMid.add(Box.createRigidArea(new Dimension(0,30)));

		//Panel Bas
		JPanel panBas = new JPanel();
		panBas.setLayout(new BoxLayout(panBas, BoxLayout.X_AXIS));
		this.butCancel = new JButton();
		this.butCancel.setPreferredSize(new Dimension(150,30));
		this.butCreate = new JButton();
		this.butCreate.setPreferredSize(new Dimension(150,30));
		panBas.add(Box.createHorizontalGlue());
		panBas.add(this.butCancel);
		panBas.add(Box.createRigidArea(new Dimension(40,0)));
		panBas.add(this.butCreate);
		panBas.add(Box.createHorizontalGlue());

		this.panPrinc.add(panHaut, BorderLayout.NORTH);
		this.panPrinc.add(panMid, BorderLayout.CENTER);
		this.panPrinc.add(panBas, BorderLayout.SOUTH);
	}

	public JPanel getPanel() {
		return this.panPrinc;
	}
	
	public JButton getButCreate() {
		return this.butCreate;
	}

	public JTextField getFieldLocation() {
		return this.fieldLocation;
	}

	public JTextField getFieldDateBegin() {
		return this.fieldDateBegin;
	}

	public JTextField getFieldDateEnd() {
		return this.fieldDateEnd;
	}

	public JTextArea getFieldDescription() {
		return this.areaDescription;
	}

	public JButton getButCancel() {
		return this.butCancel;
	}
	
	public void setName(String name) {
		this.eventName.setText(name);
	}

}
