package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;

/**
 * Vue qui s'occupe de gérer l'interface graphique de la partie authentification (login)
 * @author Nicolas
 */
public class LoginView implements View {

	private LoginController controller;
	private JPanel panPrinc;

	private JButton butConnecter;
	private JTextField fieldName;
	private JTextField fieldPassword;

	/**
	 * Construit la vue, la lie avec le controleur et met à jour l'interface graphique
	 * @param controller
	 */
	public LoginView(LoginController controller) {
		this.controller = controller;
		this.afficher();
	}

	/**
	 * Affiche les élements graphiques sur la fenêtre
	 */
	private void afficher() {
		this.panPrinc = new JPanel();
		this.panPrinc.setLayout(new BoxLayout(this.panPrinc, BoxLayout.PAGE_AXIS));

		//Label identifiant
		JLabel labIdentifiant = new JLabel("Identifiant");
		labIdentifiant.setFont(new Font("Arial", Font.PLAIN, 20));
		labIdentifiant.setAlignmentX(Component.CENTER_ALIGNMENT);

		//Label mot de passe
		JLabel labMdp = new JLabel("Mot de passe");
		labMdp.setFont(new Font("Arial", Font.PLAIN, 20));
		labMdp.setAlignmentX(Component.CENTER_ALIGNMENT);

		//Champ de l'identifiant
		this.fieldName = new JTextField();
		this.fieldName.setPreferredSize(new Dimension(150,25));
		this.fieldName.setAlignmentX(Component.CENTER_ALIGNMENT);

		//Champ du mot de passe
		this.fieldPassword = new JTextField();
		this.fieldPassword.setPreferredSize(new Dimension(150,25));
		this.fieldPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

		//Bouton connecter
		butConnecter = new JButton();
		butConnecter.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.panPrinc.add(Box.createVerticalStrut(180));
		this.panPrinc.add(labIdentifiant);
		this.panPrinc.add(this.fieldName);
		this.panPrinc.add(Box.createVerticalStrut(10));
		this.panPrinc.add(labMdp);
		this.panPrinc.add(this.fieldPassword);
		this.panPrinc.add(Box.createVerticalStrut(40));
		this.panPrinc.add(butConnecter);
	}

	public JButton getButConnecter() {
		return this.butConnecter;
	}
	
	public String getName() {
		return this.fieldName.getText();
	}
	
	public String getPassword() {
		return this.fieldPassword.getText();
	}

	@Override
	public JPanel getPanel() {
		return this.panPrinc;
	}

}
