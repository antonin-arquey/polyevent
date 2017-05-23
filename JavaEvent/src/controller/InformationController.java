package controller;

import model.InformationModel;
import view.InformationView;

public class InformationController {
	
	FenetreController controller;
	InformationView view;
	InformationModel model;
	
	public InformationController(FenetreController controller) {
		this.controller = controller;
		this.view = new InformationView(this);
	}
	
	public InformationView getView() {
		return this.view;
	}

}
