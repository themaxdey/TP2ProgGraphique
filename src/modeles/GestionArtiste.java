package modeles;

import java.util.ArrayList;

import controleurs.GestionEvenements;

public class GestionArtiste {

	public static ArrayList<Artiste> ajouterArtiste(Artiste artiste, ArrayList<Artiste> ListeArtiste) {

		if (ListeArtiste.contains(artiste)) {
			System.out.println("Erreur, l'artiste est déjà dans la liste d'artiste");
		} else {
			ListeArtiste.add(artiste);
			GestionEvenements.ajouterArtisteBD(artiste);
		}
		return ListeArtiste;
	}

	public static ArrayList<Artiste> modifierArtiste(Artiste artiste, ArrayList<Artiste> ListeArtiste) {
		
		int idArtiste = ListeArtiste.indexOf(artiste) + 1;
		
		ListeArtiste.set(idArtiste, artiste);		
		GestionEvenements.modifierArtisteBD(artiste);

		return ListeArtiste;
	}

	public static ArrayList<Artiste> supprimerArtiste(Artiste artiste, ArrayList<Artiste> ListeArtiste) {
		
		ListeArtiste.remove(artiste);
		GestionEvenements.supprimerArtisteBD(artiste);

		return ListeArtiste;
	}

}
