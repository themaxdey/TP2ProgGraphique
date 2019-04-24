package vues;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class AffichageGestionArtiste extends JFrame{
	private static final long serialVersionUID = 1L;

	public AffichageGestionArtiste() {
		
		super("Gestion des artistes");
		setSize(500, 200);
		setResizable(false);
		setIconImage(new ImageIcon("icon.png").getImage());
		
	}

}
