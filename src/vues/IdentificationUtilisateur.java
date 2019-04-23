package vues;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class IdentificationUtilisateur extends JFrame{
	private static final long serialVersionUID = 1L;

	public IdentificationUtilisateur() {
		
		super("Authentification");
		setSize(500, 200);
		setVisible(true);
		setResizable(false);
		setIconImage(new ImageIcon("icon.png").getImage());
		
	}

}
