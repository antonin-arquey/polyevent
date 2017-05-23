package view;

import controller.InformationController;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InformationView {

	InformationController controller;
	
	private JPanel panelPrinc;
	
	public InformationView(InformationController controller) {
		this.controller = controller;
		this.afficher();
	}
	
	public void afficher() {
		JOptionPane.showMessageDialog(this.panelPrinc, "Test test");
	}
	
	public JPanel getPanel() {
		return this.panelPrinc;
	}
	
}
