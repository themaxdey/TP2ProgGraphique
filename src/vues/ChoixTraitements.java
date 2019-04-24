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
		setSize(350, 175);
		setVisible(true);
		setResizable(false);
		setIconImage(new ImageIcon("icon.png").getImage());

		JPanel p = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(3, 3, 3, 3);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		p.add(new JLabel("Sélectionner la catégorie à modifier"), gbc);

		gbc.gridy = 2;
		p.add(new JButton("Artiste"), gbc); //add action listnener

		gbc.gridy = 3;
		p.add(new JButton("Album"), gbc); //add action listnener

		add(p, BorderLayout.NORTH);

		JPanel p1 = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.WEST;
		gbc1.fill = GridBagConstraints.NONE;
		gbc1.insets = new Insets(10, 10, 10, 10);
		p1.add(new JButton("Aide en ligne"), gbc1); //add action listnener

		gbc1.anchor = GridBagConstraints.EAST;
		p1.add(new JButton("Quitter"), gbc1); //add action listnener

		add(p1, BorderLayout.SOUTH);

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
