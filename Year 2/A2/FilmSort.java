/**
 * FilmSort.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

/**
 *This class organises the films alphabetically and then prints them 
 *to the screen. 
 */

import java.util.*;

public class FilmSort {
	ArrayList<Film> filmSort = new ArrayList<Film>();
	
	/**
	 * @return The information about the film, (title, director and duration).
	 */
	
	//changing string to toString
	
	public String toString() {
        StringBuilder filmInfo = new StringBuilder();
        Collections.sort(this.filmSort);
        
        for (Film f : filmSort) {
			filmInfo.append("Title: " + f.getTitle()
			+ "\tDirector: " + f.getDirector()
			+ "\tDuration: " + f.getDuration() + "minutes\n");
        }
        return filmInfo.toString();
    }
	
	/**
	 * Creates a profile.
	 * 
	 * @param name The film being added to the arraylist. 
	 */
	
	public void addFilm (Film newFilm) {
		filmSort.add(newFilm);
	}
	
	
}
