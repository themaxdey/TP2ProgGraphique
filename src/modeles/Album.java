package modeles;

public class Album {
	
	int numero;
	String titre;
	String genre;
	int annee;
	String image;
	int numeroArtiste;
	
	public Album (int numero, String titre, String genre, int annee, String image, int numeroArtiste) {
		this.numero = numero;
		this.titre = titre;
		this.genre = genre;
		this.annee = annee;
		this.image = image;
		this.numeroArtiste = numeroArtiste;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public int getAnnee() {
		return this.annee;
	}
	public String getImage() {
		return this.image;
	}
	
	public int getNumeroArtiste() {
		return this.numeroArtiste;
	}
}
