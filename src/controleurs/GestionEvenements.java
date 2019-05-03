package controleurs;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modeles.Album;
import modeles.Artiste;
import utilitaire.ControleurConnexion;

public class GestionEvenements {

	public static ArrayList<Album> remplirAlbums() {
		String req = "SELECT * FROM Album";

		ControleurConnexion.connecter();
		ArrayList<Album> listeAlbum = new ArrayList<Album>();
		Statement statement;

		try {
			statement = ControleurConnexion.getLaConnexion().createStatement();
			ResultSet jeuResultats = statement.executeQuery(req);

			Album album;

			while (jeuResultats.next()) {
				int numero = Integer.parseInt(jeuResultats.getString("numero"));
				String titre = jeuResultats.getString("titre");
				String genre = jeuResultats.getString("genre");
				int annee = Integer.parseInt(jeuResultats.getString("annee"));
				String image = jeuResultats.getString("image");
				int numeroArtiste = Integer.parseInt(jeuResultats.getString("numeroArtiste"));

				album = new Album(numero, titre, genre, annee, image, numeroArtiste);

				listeAlbum.add(album);

			}
		} catch (SQLException e) {
			System.out.println("Impossible de naviger dans le RS d'album");
			e.printStackTrace();
		}

		ControleurConnexion.fermerSession();

		return listeAlbum;
	}

	public static ArrayList<Artiste> remplirArtistes() {
		String req = "SELECT * FROM Artiste";

		ControleurConnexion.connecter();
		ArrayList<Artiste> listeArtiste = new ArrayList<Artiste>();
		Statement statement;

		try {
			statement = ControleurConnexion.getLaConnexion().createStatement();
			ResultSet jeuResultats = statement.executeQuery(req);

			Artiste artiste;

			while (jeuResultats.next()) {
				int numero = Integer.parseInt(jeuResultats.getString("numero"));
				String nom = jeuResultats.getString("nom");
				int membre = Integer.parseInt(jeuResultats.getString("membre"));
				String photo = jeuResultats.getString("photo");

				artiste = new Artiste(numero, nom, membre, photo);

				listeArtiste.add(artiste);

			}
		} catch (SQLException e) {
			System.out.println("Impossible de naviger dans le RS d'artiste");
			e.printStackTrace();
		}

		ControleurConnexion.fermerSession();

		return listeArtiste;
	}

}
