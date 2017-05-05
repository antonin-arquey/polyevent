package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Fenetre principale du programme qui contient la JFrame
 * On ne s'occupe que de remplacer panPrinc lorsque l'on change de vue,
 * via la méthode setPanelPrincipale
 * @author Nicolas
 */
public class FenetrePrincipale extends JFrame {

	private JPanel panPrinc;
	
	public FenetrePrincipale() {
		panPrinc = new JPanel();
		this.setLayout(new BorderLayout());
		this.add(panPrinc, BorderLayout.CENTER);
		
		this.setTitle("Event");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Remplacer le panel principale de la JFrame par le nouveau de la nouvelle vue,
	 * voir les controleurs
	 * @param panel le nouveau panel à afficher
	 */
	public void setPanelPrincipale(JPanel panel) {
		this.panPrinc.removeAll();
		this.panPrinc.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
		panPrinc.repaint();
	}
	
}
