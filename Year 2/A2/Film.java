/**
 * Film.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

/**
 *This class creates a film using the various attributes
 *declared in the class. 
 */

public class Film implements Comparable<Film> {

	private String title;
	private String director;
	private int duration;
	
	/**
	 * Creates a film.
	 * 
	 * @param title The title of the film.
	 * @param director  The name of the director of the film.
	 * @param duration The duration of the film.
	 *
	 */
	
	public Film(String title, String director, int duration) {
		this.title = title;
		this.director = director;
		this.duration = duration;
	}
	
	/**
	 * @return The title of the film.
	 */
	
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return The name of the director.
	 */

	public String getDirector() {
		return director;
	}
	
	/**
	 * @return The duration of the film.
	 */

	public int getDuration() {
		return duration;
	}
	
	/**
	 * @return The comparison of the titles 
	 */
	
	public int compareTo(Film other) {
		return this.title.compareTo(other.getTitle());
	}
	
}
