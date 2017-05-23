package view;

import controller.AddController;
import javax.swing.JPanel;

public class AddView {

	AddController controller;
	private JPanel panPrinc;
	
	public AddView(AddController controller) {
		this.controller = controller;
	}
	
	public JPanel getPanel() {
		return this.panPrinc;
	}
	
}
