/**
 * Profile.java
 * 
 * @version 1.0.0
 * @author Annabel Kimber
 */

import java.util.*;

/**
 *This class creates a profile using the various attributes
 *declared in the class. These profiles are then stored in nodes
 *and used in a binary search tree.
 */

public class Profile {

	private String name;
	private int day;
	private int month;
	private int year;
	private String town;
	private String country;
	private String nationality;
	private ArrayList<String> interests;
	private ArrayList<Profile> friends;
	
	/**
	 * Creates a profile.
	 * 
	 * @param name The name of the person in the profile.
	 * @param day  The day in the persons date of birth.
	 * @param month The month in the persons date of birth.
	 * @param year The year in the persons date of birth.
	 * @param town The town the person is from.
	 * @param country The country the person is from.
	 * @param nationality The nationality of the person.
	 * @param interests The interests of the person.
	 */

	public Profile(String name, int day, int month, int year, String town, String country, String nationality,
			ArrayList<String> interests) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.town = town;
		this.country = country;
		this.nationality = nationality;
		this.interests = interests;
	}

	/**
	 * @return The name of the person in the profile.
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
	 * @return The town the person is from.
	 */

	public String getTown() {
		return town;
	}

	/**
	  * @param town Sets the town of the person in the profile.
	  */
	
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return The country the person is from.
	 */

	public String getCountry() {
		return country;
	}

	/**
	  * @param country Sets the country of the person in the profile.
	  */

	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return The nationality of the person.
	 */

	public String getNationality() {
		return nationality;
	}

	/**
	  * @param nationality Sets the nationality of the person in the profile.
	  */

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return The DOB of the person in dd/mm/yyyy format.
	 * 
	 */

	public String getDOB() {
		if (day <10 && month <10){
			return "0" + day + "/" + "0" + month + "/" + year;
		}if (day < 10){	
			return "0" + day + "/" + month + "/" + year;
		}if (month < 10) {
			return  day + "/" + "0" + month + "/" + year;
		}else{
			return day + "/" + month + "/" + year;
		}		
	}
	
	/**
	 *@param p Adding friends to the friend list.
	 */

	public void addFriend(Profile p) {
		friends.add(p);
	}

	/**
	 * @return The interests of the person in an array list.
	 * 
	 */

	
	public ArrayList<String> getInterests() {
		return interests;
	}

	/**
	  * @param  interests Sets the interests of the person in the profile.
	  */

	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}

	/**
	 * Method to convert a profile to a string.
	 */
	
	public String toString() {
		return "Name:" + " " + name + "\n" 
				+ "Date:" + " " + getDOB() + "\n" 
				+ "Town:" + " " + getTown() + "\n"
				+ "Country:" + " " + getCountry() 
				+ "\n" + "Nationality:" + " " 
				+ getNationality() + "\n" 
				+ "Intrests:"+ " " + interests + "\n";
	}

}
