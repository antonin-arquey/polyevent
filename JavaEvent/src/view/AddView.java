package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.AddController;

public class AddView {

	AddController controller;
	private JPanel panPrinc;

	private JTextField eventName;
	private JTextField fieldLieu;
	private JTextField fieldLocation;
	private JTextField fieldDateBegin;
	private JSpinner spinnerDebutHeures;
	private JSpinner spinnerDebutMinutes;
	private JTextField fieldDateEnd;
	private JSpinner spinnerFinHeures;
	private JSpinner spinnerFinMinutes;
	private JSpinner spinPlaces;
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
		this.eventName = new JTextField();
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
		this.fieldLieu = new JTextField();
		JLabel labAdresse = new JLabel("Adresse : ");
		labAdresse.setFont(new Font("Arial", Font.PLAIN, 20));
		this.fieldLocation = new JTextField();
		this.fieldLocation.setPreferredSize(new Dimension(180,30));
		panMid1.add(labLieu);
		panMid1.add(this.fieldLieu);
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
		SpinnerModel model1 = new SpinnerNumberModel(12, 0, 24, 1);   
		SpinnerModel model2 = new SpinnerNumberModel(0, 0, 59, 1);
        this.spinnerDebutHeures = new JSpinner(model1);
		this.spinnerDebutHeures.setPreferredSize(new Dimension(40,30));
		this.spinnerDebutHeures.setMaximumSize(new Dimension(40,30));
		JLabel labHeures = new JLabel("h");
        this.spinnerDebutMinutes = new JSpinner(model2);
		this.spinnerDebutMinutes.setPreferredSize(new Dimension(40,30));
		this.spinnerDebutMinutes.setMaximumSize(new Dimension(40,30));
		panMid2.add(labDebut);
		panMid2.add(this.fieldDateBegin);
		panMid2.add(labA);
		panMid2.add(this.spinnerDebutHeures);
		panMid2.add(Box.createHorizontalStrut(5));
		panMid2.add(labHeures);
		panMid2.add(Box.createHorizontalStrut(5));
		panMid2.add(this.spinnerDebutMinutes);
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
		SpinnerModel model3 = new SpinnerNumberModel(12, 0, 24, 1);   
		SpinnerModel model4 = new SpinnerNumberModel(0, 0, 59, 1);
        this.spinnerFinHeures = new JSpinner(model3);
		this.spinnerFinHeures.setPreferredSize(new Dimension(40,30));
		this.spinnerFinHeures.setMaximumSize(new Dimension(40,30));
		JLabel labHeures2 = new JLabel("h");
        this.spinnerFinMinutes = new JSpinner(model4);
		this.spinnerFinMinutes.setPreferredSize(new Dimension(40,30));
		this.spinnerFinMinutes.setMaximumSize(new Dimension(40,30));
		panMid3.add(labFin);
		panMid3.add(this.fieldDateEnd);
		panMid3.add(labA2);
		panMid3.add(this.spinnerFinHeures);
		panMid3.add(Box.createHorizontalStrut(5));
		panMid3.add(labHeures2);
		panMid3.add(Box.createHorizontalStrut(5));
		panMid3.add(this.spinnerFinMinutes);
		panMid3.add(Box.createHorizontalGlue());

		JPanel panMid4 = new JPanel();
		panMid4.setLayout(new BoxLayout(panMid4, BoxLayout.X_AXIS));
		JLabel labPlaces = new JLabel("Nombre de places : ");
		labPlaces.setFont(new Font("Arial", Font.PLAIN, 20));
		this.spinPlaces = new JSpinner(); 
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

	public JSpinner getSpinPlaces() {
		return spinPlaces;
	}

	public void setSpinPlaces(JSpinner spinPlaces) {
		this.spinPlaces = spinPlaces;
	}

	public JSpinner getSpinnerDebutHeures() {
		return spinnerDebutHeures;
	}

	public JSpinner getSpinnerDebutMinutes() {
		return spinnerDebutMinutes;
	}

	public JSpinner getSpinnerFinHeures() {
		return spinnerFinHeures;
	}

	public JSpinner getSpinnerFinMinutes() {
		return spinnerFinMinutes;
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
	
	public String getName() {
		return this.eventName.getText();
	}
	
	public void setName(String name) {
		this.eventName.setText(name);
	}
	
	public JTextField getFieldLieu() {
		return this.fieldLieu;
	}

}
