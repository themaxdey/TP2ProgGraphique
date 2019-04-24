package modeles;

public class Artiste {
	String nom;
	String photo;
	int numeroArtiste;
	String membre;
	
	public Artiste(String nom, String photo, int numero, String membre) {
		this.nom = nom;
		this.photo = photo;
		this.numeroArtiste = numero;
		this.membre = membre;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getMembre() {
		return this.membre;
	}
	
	public int getNumero() {
		return numeroArtiste;
	}
}
