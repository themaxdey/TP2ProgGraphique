package modeles;

public class Artiste {
	String nom;
	String photo;
	int numeroArtiste;
	int membre;
	
	public Artiste(String nom, String photo, int numero, int membre) {
		this.nom = nom;
		this.photo = photo;
		this.numeroArtiste = numero;
		this.membre = membre;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPhoto() {
		return this.photo;
	}
	
	public int getMembre() {
		return this.membre;
	}
	
	public int getNumero() {
		return numeroArtiste;
	}
}
