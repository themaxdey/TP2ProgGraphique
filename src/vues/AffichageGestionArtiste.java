package vues;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controleurs.GestionEvenements;
import modeles.Album;
import modeles.Artiste;
import modeles.GestionArtiste;

public class AffichageGestionArtiste extends JFrame {
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox checkBox1;
	private DefaultListModel<String> listModel;

	private ArrayList<Artiste> listeArtistes;
	private ArrayList<Album> listeAlbums;

	private String[][] donnees;
	private String[] nomColonne = {"No", "Nom", "Membre"};

	public AffichageGestionArtiste() {
		listeArtistes = GestionEvenements.remplirArtistes();
		listeAlbums = GestionEvenements.remplirAlbums();
		remplir();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestion des artistes");
		frame.setBounds(500, 500, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(new ImageIcon("images/icon.png").getImage());
		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setBounds(10, 11, 255, 14);
		frame.getContentPane().add(lblRechercherUnArtiste);

		textField = new JTextField();
		textField.setBounds(10, 26, 229, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(249, 25, 111, 21);
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
		labelImage.setIcon( new ImageIcon(scaleImage("images/image.png")));
		frame.getContentPane().add(labelImage);

		JButton btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setBounds(10, 225, 100, 30);
		frame.getContentPane().add(btnRemplacer);

		TableModel model = new DefaultTableModel(donnees, nomColonne) {
			private static final long serialVersionUID = 1L;
			
			public String getColumnName(int index) {

				return nomColonne[index];
			}

			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		table = new JTable(model);  
		table.setBounds(120, 117, 240, 138);
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					String num = target.getValueAt(row, 0).toString();
					afficherArtiste(num);
				}
				if(e.getClickCount() == 2) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					String num = target.getValueAt(row, 0).toString();
					//System.out.println(num);
					editArtiste(num);
				}
			}
			
		});
		frame.getContentPane().add(table);

		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(385, 117, 89, 23);
		frame.getContentPane().add(btnNouveau);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(385, 151, 89, 23);
		frame.getContentPane().add(btnAjouter);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(385, 185, 89, 23);
		btnModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int checked = 0;
				if(checkBox1.isSelected()) {
					checked = 1;
				}
				Artiste artiste = new Artiste(Integer.parseInt(textField_1.getText()), textField_2.getText(), checked, null);
				GestionArtiste.modifierArtiste(artiste, listeArtistes);
			}
			
		});
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
		lblMembre.setBounds(10, 365, 64, 14);
		frame.getContentPane().add(lblMembre);

		checkBox1 = new JCheckBox("");
		checkBox1.setBounds(62, 361, 97, 23);
		checkBox1.setEnabled(false);
		frame.getContentPane().add(checkBox1);

		textField_1 = new JTextField();
		textField_1.setBounds(63, 312, 86, 20);
		textField_1.setEditable(false);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(63, 337, 86, 20);
		textField_2.setEditable(false);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		listModel = new DefaultListModel<>();
		JList<String> list1 = new JList<String>(listModel);
		list1.setBounds(175, 315, 185, 100);
		frame.getContentPane().add(list1);

		JLabel labelAlbum = new JLabel();
		labelAlbum.setBounds(374, 315, 100, 100);
		labelAlbum.setIcon( new ImageIcon(scaleImage("images/albumCover.png")));
		frame.getContentPane().add(labelAlbum);

		frame.setVisible(true);
	}

	public void remplir() {
		int g = listeArtistes.size();
		int i = 0;

		donnees = new String[g][3];

		for (Artiste a : listeArtistes) {
			donnees[i][0] = Integer.toString(a.getNumero());
			donnees[i][1] = a.getNom();

			if (a.getMembre() == 1) {
				donnees[i][2] = "Oui";
			} else {
				donnees[i][2] = "Non";
			}
			i++;
		}
	}

	private Image scaleImage(String stringImg) {
		ImageIcon imageIcon = new ImageIcon(stringImg);
		Image img = imageIcon.getImage();
		BufferedImage resizedImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, 100, 100, null);
		g2.dispose();

		return resizedImg;
	}
	
	private void afficherArtiste(String num) {
		Artiste artiste = new Artiste();
		for(int i = 0; i < listeArtistes.size(); i++) {
			artiste = listeArtistes.get(i);
			if(artiste.getNumero() == Integer.parseInt(num)) {
				textField_1.setText(num);
				break;
			}
		}
		textField_2.setText(artiste.getNom());
		if(artiste.getMembre() == 1) {
			checkBox1.setSelected(true);
		}else {
			checkBox1.setSelected(false);
		}
		
		int o = 0;
		for(Album a : listeAlbums) {
			if(a.getNumeroArtiste() == artiste.getNumero()) {
				o++;
			}
		}
		int i = 0;
		String[] liste = new String[o];
		for(Album a : listeAlbums) {
			if(a.getNumeroArtiste() == artiste.getNumero()) {
				liste[i] = (a.getAnnee() + " - " + a.getTitre());
				i++;
			}
		}
		listModel.clear();
		for(int oups = 0; oups < liste.length; oups++) {
			listModel.addElement(liste[oups]);
		}
	}
	
	private void editArtiste(String num) {
		Artiste artiste = new Artiste();
		for(int i = 0; i < listeArtistes.size(); i++) {
			artiste = listeArtistes.get(i);
			if(artiste.getNumero() == Integer.parseInt(num)) {
				break;
			}
		}
		textField_2.setEditable(true);
		checkBox1.setEnabled(true);
		
	}

}
