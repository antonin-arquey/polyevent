package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.InformationController;

public class InformationView {

	InformationController controller;
	
	private JPanel panelPrinc;
	
	private JLabel labTitre;
	private JLabel labLieu;
	private JLabel labDate;
	private JLabel labParticipants;
	private JLabel labInscription;
	private JTextArea description;
	private JLabel labRespo;
	
	private JButton butRetour;
	private JButton butListe;
	private JButton butParticiper;
	private JButton butModifier;
	private JButton butSupprimer;
	
	public InformationView(InformationController controller) {
		this.controller = controller;
		this.afficher();
	}
	
	public void afficher() {
		this.panelPrinc = new JPanel();
		this.panelPrinc.setLayout(new BoxLayout(this.panelPrinc, BoxLayout.Y_AXIS));
		
		this.labTitre = new JLabel();
		this.labTitre.setFont(new Font("Arial", Font.PLAIN, 40));
		this.labTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel panMid = new JPanel();
		panMid.setLayout(new BoxLayout(panMid, BoxLayout.X_AXIS));
		
		JPanel panMidGauche = new JPanel();
		panMidGauche.setLayout(new BoxLayout(panMidGauche, BoxLayout.Y_AXIS));
		this.labLieu = new JLabel("Lieu : ");
		this.labLieu.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labDate = new JLabel("Début : ");
		this.labDate.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labParticipants = new JLabel("Participants : ");
		this.labParticipants.setFont(new Font("Arial", Font.PLAIN, 20));
		panMidGauche.add(this.labLieu);
		panMidGauche.add(this.labDate);
		panMidGauche.add(this.labParticipants);
		
		this.labInscription = new JLabel("Inscriptions ouvertes");
		this.labInscription.setFont(new Font("Arial", Font.PLAIN, 30));
		panMid.add(panMidGauche);
		panMid.add(Box.createHorizontalStrut(30));
		panMid.add(this.labInscription);
		
		this.description = new JTextArea();
		this.description.setFont(new Font("Arial", Font.PLAIN, 20));
		JScrollPane pane = new JScrollPane(description);
		pane.setPreferredSize(new Dimension(400,240));
		
		this.labRespo = new JLabel("Responsable : ");
		this.labRespo.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JPanel panBut = new JPanel();
		panBut.setLayout(new BoxLayout(panBut, BoxLayout.X_AXIS));
		
		this.butRetour = new JButton("Retour");
		this.butParticiper = new JButton("Participer");
		this.butListe = new JButton("Liste des participants");
		this.butModifier = new JButton("Modifier");
		this.butSupprimer = new JButton("Supprimer");
		panBut.add(this.butRetour);
		panBut.add(Box.createHorizontalStrut(10));
		panBut.add(this.butListe);
		panBut.add(Box.createHorizontalStrut(10));
		panBut.add(this.butParticiper);
		panBut.add(Box.createHorizontalStrut(10));
		panBut.add(this.butModifier);
		panBut.add(Box.createHorizontalStrut(10));
		panBut.add(this.butSupprimer);
		
		this.panelPrinc.add(Box.createVerticalStrut(20));
		this.panelPrinc.add(labTitre);
		this.panelPrinc.add(Box.createVerticalStrut(40));
		this.panelPrinc.add(panMid);
		this.panelPrinc.add(Box.createVerticalStrut(20));
		this.panelPrinc.add(pane);
		this.panelPrinc.add(Box.createVerticalStrut(20));
		this.panelPrinc.add(this.labRespo);
		this.panelPrinc.add(Box.createVerticalStrut(20));
		this.panelPrinc.add(panBut);
		this.panelPrinc.add(Box.createVerticalStrut(20));
		}
	
	public JPanel getPanel() {
		return this.panelPrinc;
	}
	
	public void setTitre(String name) {
		this.labTitre.setText(name);
	}
	
	public void setLieu(String lieu) {
		this.labLieu.setText(lieu);
	}
	
	public void setDate(String date) {
		this.labDate.setText(date);
	}

	public void setParticipants(String part) {
		this.labParticipants.setText(part);
	}

	public void setInscription(String ins) {
		this.labInscription.setText(ins);
	}

	public void setDescription(String des) {
		this.description.setText(des);
	}
	
	public void setRespo(String respo) {
		this.labRespo.setText(respo);
	}
	
}
