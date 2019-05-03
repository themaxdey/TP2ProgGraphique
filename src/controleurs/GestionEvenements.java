package controleurs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modeles.Album;
import modeles.Artiste;
import utilitaire.ControleurConnexion;

public class GestionEvenements {

	@SuppressWarnings("null")
	public static ArrayList<Album> remplirAlbums() {
		String req = "SELECT * FROM Album";

		ControleurConnexion.connecter();
		ArrayList<Album> listeAlbum = null;
		Statement statement;

		try {
			statement = ControleurConnexion.getLaConnexion().createStatement();
			ResultSet jeuResultats = statement.executeQuery(req);

			Album album;

			while (jeuResultats.next()) {
				String titre = jeuResultats.getString("titre");
				int annee = Integer.parseInt(jeuResultats.getString("annee"));
				String photo = jeuResultats.getString("photo");
				int numeroArtisteFK = Integer.parseInt(jeuResultats.getString("numeroArtisteFK"));
				int numeroAlbum = Integer.parseInt(jeuResultats.getString("numeroAlbum"));

				album = new Album(titre, annee, photo, numeroArtisteFK, numeroAlbum);

				listeAlbum.add(album);

			}
		} catch (SQLException e) {
			System.out.println("Impossible de naviger dans le RS d'album");
			e.printStackTrace();
		}

		ControleurConnexion.fermerSession();

		return listeAlbum;
	}

	@SuppressWarnings("null")
	public static ArrayList<Artiste> remplirArtistes() {
		String req = "SELECT * FROM Artiste";

		ControleurConnexion.connecter();
		ArrayList<Artiste> listeArtiste = null;
		Statement statement;

		try {
			statement = ControleurConnexion.getLaConnexion().createStatement();
			ResultSet jeuResultats = statement.executeQuery(req);

			Artiste artiste;

			while (jeuResultats.next()) {
				String nom = jeuResultats.getString("titre");
				String photo = jeuResultats.getString("photo");
				int numero = Integer.parseInt(jeuResultats.getString("numeroArtiste"));
				String membre = jeuResultats.getString("membre");

				artiste = new Artiste(nom, photo, numero, membre);

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
