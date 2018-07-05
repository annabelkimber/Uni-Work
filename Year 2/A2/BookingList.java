/**
 * BookingList.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

/**
 *This class initiates a booking using an arraylist,
 *it allows the user to create and cancel bookings.
 */

import java.util.*;

public class BookingList {
	ArrayList<Booking> bookings = new ArrayList<Booking>();
	
	public void makeBooking (Booking newBooking) {
		bookings.add(newBooking);
	}
	
	public void cancelBooking (Booking cancel){
		bookings.remove(cancel);
	}
		
}
