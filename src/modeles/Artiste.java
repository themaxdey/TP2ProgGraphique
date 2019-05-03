package modeles;

public class Artiste {
	int numero;
	String nom;
	int membre;
	String photo;
	
	public Artiste(int numero, String nom, int membre, String photo) {
		this.numero = numero;
		this.nom = nom;
		this.membre = membre;
		this.photo = photo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getMembre() {
		return this.membre;
	}
	
	public String getPhoto() {
		return this.photo;
	}
}
