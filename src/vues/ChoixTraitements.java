package vues;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
		setIconImage(new ImageIcon("images/icon.png").getImage());

		JPanel p = new JPanel(new GridBagLayout());

		File htmlFile = new File("aide/aide.html");

		
		JButton b1 = new JButton("Artiste");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AffichageGestionArtiste();
				dispose();
			}
			
		});
		JButton b2 = new JButton("Album");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AffichageGestionAlbum();
				System.out.println("Ouverture gestion Album");
				dispose();
			}
			
		});
		JButton b3 = new JButton("Aide en ligne");
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		JButton b4 = new JButton("Quitter");
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});

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
		p.add(b1, gbc);

		gbc.gridy = 3;
		p.add(b2, gbc);

		add(p, BorderLayout.NORTH);

		JPanel p1 = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.WEST;
		gbc1.fill = GridBagConstraints.NONE;
		gbc1.insets = new Insets(10, 10, 10, 10);
		p1.add(b3, gbc1);

		gbc1.anchor = GridBagConstraints.EAST;
		p1.add(b4, gbc1);

		add(p1, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
