package vues;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoixTraitements extends JFrame {

	private static final long serialVersionUID = 1L;

	public ChoixTraitements() {

		super("Choix des traitements");
		setSize(250, 200);
		setVisible(true);
		setResizable(false);
		setIconImage(new ImageIcon("icon.png").getImage());

		JPanel p = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(2, 2, 2, 2);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		p.add(new JLabel("Sélectionner la catégorie à modifier"), gbc);

		gbc.gridy = 2;
		p.add(new JButton("Artiste"), gbc);

		gbc.gridy = 3;
		p.add(new JButton("Album"), gbc);

		

		add(p, BorderLayout.NORTH);
		
		gbc.anchor = GridBagConstraints.WEST;

		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(2, 2, 2, 2);
		
		JPanel p1 = new JPanel(new GridBagLayout());
		gbc.gridx = 1;
		gbc.gridy = 6;
		p1.add(new JButton("Aide en ligne"), gbc);
		
		gbc.gridx = 3;
		p1.add(new JButton("Quitter"), gbc);
		
		add(p1, BorderLayout.SOUTH);

		//pack();

		int choix = 0; // Modifier le choix dans le gestionnaire d'evenements

		// choixTraitement(choix);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void choixTraitement(int choix) {

		if (choix == 0) {
			new AffichageGestionArtiste();
		} else {
			new AffichageGestionAlbum();
		}

	}
}
