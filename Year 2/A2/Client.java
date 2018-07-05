/**
 * Client.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

/**
 *This class creates a client using the various attributes
 *declared in the class. 
 */

public class Client {

	private String name;
	private String surname;
	
	private int cardNo;
	private int expiryMonth;
	private int expiryYear;
	private int CSV;
	
	
	/**
	 * Creates a profile.
	 * 
	 * @param name The name of the client.
	 * @param surname  The surname of the client.
	 * @param cardNo The card number of the client.
	 * @param expiryMonth The expiry month of  of the card.
	 * @param expiryYear The expiry year of the card.
	 * @param CSV The security code of the card.
	 */

	public Client(String name, String surname, String email, int phoneNo, int cardNo, int expiryMonth, int expiryYear, int CSV){
		this.name = name;
		this.surname = surname;
		this.cardNo = cardNo;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.CSV = CSV;
		
	}

	/**
	 * @return The name of the client.
	 */
	
	public String getName() {
		return name;
	}

	/**
	  * @param name Sets the name of the person in the profile.
	  */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return The surname of the client.
	 */
	
	public String getSurname() {
		return surname;
	}

	/**
	  * @param name Sets the surname of the client.
	  */
	
	public void setSurname (String surname) {
		this.surname = surname;
	}

	/**
	 * @return The card number of the client's card.
	 */
	
	
	public int getCardNo() {
		return cardNo;
	}

	/**
	  * @param name Sets the card number of the clients card.
	  */
	
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * @return The expiry month of the client's card.
	 */
	
	
	public int getExpiryMonth() {
		return expiryMonth;
	}

	/**
	  * @param name Sets the expiry month of the clients card.
	  */
	
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	/**
	 * @return The expiry year of the client's card.
	 */
	
	
	public int getExpiryYear() {
		return expiryYear;
	}
	
	/**
	  * @param name Sets the expiry year of the clients card.
	  */

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	
	/**
	 * @return The CSV of the client's card.
	 */
	

	public int getCSV() {
		return CSV;
	}
	
	/**
	  * @param name Sets the CSV for the clients card.
	  */

	public void setCSV(int cSV) {
		CSV = cSV;
	}

}
