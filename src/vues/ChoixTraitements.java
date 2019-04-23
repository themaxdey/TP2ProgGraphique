package vues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChoixTraitements extends JFrame {

	private static final long serialVersionUID = 1L;

	public ChoixTraitements() {

		super("Choix des traitements");
		setSize(500, 200);
		setVisible(true);
		setResizable(false);
		setIconImage(new ImageIcon("icon.png").getImage());

		creerChoixTraitement();

		String choix = null; // Modifier le choix dans le gestionnaire d'evenements

		choixTraitement(choix);

	}

	private void creerChoixTraitement() {
		JPanel pNord = new JPanel(new FlowLayout());
		JButton[] boutons = new JButton[2];
		boutons[0] = new JButton("Un bouton");
		boutons[1] = new JButton("Un bouton");
		pNord.add(boutons[0]);
		pNord.add(boutons[1]);

		add(pNord, BorderLayout.NORTH);

	}

	private void choixTraitement(String choix) {

		if (choix.equals("gestionArtiste")) {
			new AffichageGestionArtiste();
		} else {
			new AffichageGestionAlbum();
		}

	}
}
