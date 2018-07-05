/**
 * Booking.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

/**
 *This class creates a booking using the various attributes
 *declared in the class. 
 */

public class Booking {
	private Client customer;
	private Film movie;
	
	/**
	 * Creates a Booking.
	 * 
	 * @param customer The name of the client making the booking.
	 * @param movie  The movie the client is booking a reservation for.
	 *
	 */
	
	public Booking (Client customer, Film movie){
		this.customer = customer;
		this.movie = movie;
	}
}