package modeles;

public class Album {
	String titre;
	int annee;
	String photo;
	int numeroArtisteFK;
	int numeroAlbum;
	
	public Album (String titre, int annee, String photo, int numeroArtisteFK, int numeroAlbum) {
		this.titre = titre;
		this.annee = annee;
		this.photo = photo;
		this.numeroArtisteFK = numeroArtisteFK;
		this.numeroAlbum = numeroAlbum;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public int getAnnee() {
		return this.annee;
	}
	public String getPhoto() {
		return this.photo;
	}
	
	public int getNumeroAlbum() {
		return this.numeroAlbum;
	}
	
	public int getNumeroArtisteFK() {
		return numeroArtisteFK;
	}
}
