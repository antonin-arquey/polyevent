package view;

import javax.swing.JPanel;

/**
 * Chaque vue implémente View car au changement de fenêtre (vue) nous avons besoin
 * de mettre à jour la JFrame en remplacant le panel principal par le nouvel
 * @author Nicolas
 *
 */
public interface View {

	public JPanel getPanel();
	
}
