package vues;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AffichageGestionArtiste extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	public AffichageGestionArtiste() {
		initialize();
		remplir();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Choix des traitements");
		frame.setBounds(500, 500, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(new ImageIcon("icon.png").getImage());
		
		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setBounds(10, 11, 255, 14);
		frame.getContentPane().add(lblRechercherUnArtiste);
		
		textField = new JTextField();
		textField.setBounds(10, 26, 229, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(249, 25, 89, 23);
		btnRechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		frame.getContentPane().add(btnRechercher);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(385, 25, 89, 23);
		btnQuitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
			
		});
		frame.getContentPane().add(btnQuitter);
		
		JLabel lblArtistes = new JLabel("Artistes");
		lblArtistes.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtistes.setBounds(10, 68, 139, 38);
		frame.getContentPane().add(lblArtistes);
		
		JLabel labelImage = new JLabel();
		labelImage.setBounds(10, 117, 100, 100);
		labelImage.setIcon( new ImageIcon(scaleImage("albumCover.png")));
		frame.getContentPane().add(labelImage);
		
		JButton btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setBounds(10, 225, 100, 30);
		frame.getContentPane().add(btnRemplacer);
		
		table = new JTable();
		table.setBounds(120, 117, 240, 138);
		frame.getContentPane().add(table);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(385, 117, 89, 23);
		frame.getContentPane().add(btnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(385, 151, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(385, 185, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(385, 232, 89, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JLabel lblInformations = new JLabel("Informations");
		lblInformations.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInformations.setBounds(10, 266, 229, 38);
		frame.getContentPane().add(lblInformations);
		
		JLabel lblNumro = new JLabel("Numéro");
		lblNumro.setBounds(10, 315, 46, 14);
		frame.getContentPane().add(lblNumro);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 340, 46, 14);
		frame.getContentPane().add(lblNom);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setBounds(10, 365, 46, 14);
		frame.getContentPane().add(lblMembre);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(62, 361, 97, 23);
		frame.getContentPane().add(checkBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(63, 312, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(63, 337, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JList<String> list = new JList<String>();
		list.setBounds(175, 315, 185, 100);
		frame.getContentPane().add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(374, 315, 100, 100);
		frame.getContentPane().add(panel_1);
		
		frame.setVisible(true);
	}
	
	public void remplir() {
		
	}
	
	private Image scaleImage(String stringImg){
		ImageIcon imageIcon = new ImageIcon(stringImg);
		Image img = imageIcon.getImage();
	    BufferedImage resizedImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(img, 0, 0, 100, 100, null);
	    g2.dispose();

	    return resizedImg;
	}

}
