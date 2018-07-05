/**
 * Main.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

/**
 * This class that runs system creating and deleting books
 * as per the request of the client.
 */

public class Main {

	public static void main(String[] args) {

		Film f1 = new Film ("Finding Dory", "Pixar", 120);
		Film f2 = new Film ("Fantastic Beasts", "David Heyman", 260);
	
		FilmSort listFilms = new FilmSort();
		
		listFilms.addFilm(f1);
		
		System.out.println(listFilms.toString());	
		
	}
}