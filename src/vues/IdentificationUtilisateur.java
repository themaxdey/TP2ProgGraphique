package vues;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IdentificationUtilisateur extends JFrame{
	private static final long serialVersionUID = 1L;

	public IdentificationUtilisateur() {
		
		super("Authentification");
		setSize(500, 200);
		setResizable(false);
		setIconImage(new ImageIcon("images/icon.png").getImage());
		setLayout(new GridBagLayout());
		
		JLabel c1 = new JLabel("Nom d'Utilisateur : ");
		JTextField c2 = new JTextField();
		JLabel c3 = new JLabel("Mot de Passe : ");
		JTextField c4 = new JTextField();
		JButton b1 = new JButton("Se connecter");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!c2.getText().equals("") && !c4.getText().equals("")) {
					new ChoixTraitements();
					dispose();
				}
			}
			
		});
		JButton b2 = new JButton("Quitter");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		
		GridBagConstraints con = new GridBagConstraints();
		
		con.fill = GridBagConstraints.NONE;
		con.weightx = 1;
		con.weighty = 1;
		con.gridx = 0;
		con.gridy = 0;
		con.insets = new Insets(10, 10, 10, 10);
		
		add(c1, con);
		
		con.gridx = 1;
		con.fill = GridBagConstraints.HORIZONTAL;
		add(c2, con);
		
		con.gridy = 1;
		add(c4, con);
		
		con.gridx = 0;
		con.fill = GridBagConstraints.NONE;
		add(c3, con);
		
		con.gridy = 2;
		con.fill = GridBagConstraints.HORIZONTAL;
		add(b1, con);
		
		con.gridx = 1;
		add(b2, con);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
