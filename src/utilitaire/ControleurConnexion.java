package utilitaire;

import java.sql.*;

public class ControleurConnexion {
	private static Connection laConnexion;
	private static String url = "jdbc:sqlite:db.db";

	/**
	 * �tablit la connexion � la BDD si elle n'existe pas. Attention, la connexion
	 * ne doit pas �tre ferm�e
	 */
	public static void connecter() {
		try {
			if (laConnexion == null || laConnexion.isClosed()) {
				Class.forName("org.sqlite.JDBC");
				laConnexion = DriverManager.getConnection(url);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur Class not found : " + e);

		} catch (SQLException sqle) {
			System.out.println("Erreur SQL exception " + sqle);

		}
	}

	public static void fermerSession() {
		try {
			if (laConnexion != null && !laConnexion.isClosed()) {
				laConnexion.close();
			}
		} catch (SQLException sqle) {
			System.out.println("Erreur SQL exception " + sqle);
		}
	}

	public static Connection getLaConnexion() {

		return laConnexion;
	}

}
