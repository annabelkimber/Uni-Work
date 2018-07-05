import java.util.ArrayList;

/**
 * Class that is used to store a profile with its name, dateOfBirth,
 * townOfResidence, countryOfResidence, nationality, interests and
 * friends.
 * 
 * @author Alistair Cloney
 * @version 1.0
 */
public class Profile {
	
	private String name;
	private Date dateOfBirth;
	private String townOfResidence;
	private String countryOfResidence;
	private String nationality;
	private ArrayList<String> interests = new ArrayList<String>();
	private ArrayList<Profile> friends = new ArrayList<Profile>();
	
	public Profile(String name, Date dateOfBirth,
			String townOfResidence, String countryOfResidence,
			String nationality, ArrayList<String> interests) {
		
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.townOfResidence = townOfResidence;
		this.countryOfResidence = countryOfResidence;
		this.nationality = nationality;
		this.interests = interests;
	}
	
	/**
	 * Makes a relation by searching for the current profile and the
	 * friend's profile and will simply call the method addFriend
	 * from the current profile and use the friend's profile as the
	 * parameter input.
	 * 
	 * This method can potentially throw errors if there is no profile
	 * that exists with a name of either one of the two given names
	 * (the current profile name or the friend's name).
	 * 
	 * @param profileFriend The instance that will hold the current
	 * profile name and the friend's name.
	 * 
	 * @param profilesArrayList The already populated array list
	 * that consists of all the existing profiles.
	 */
	public static void makeRelationship(ProfileFriend profileFriend,
			ArrayList<Profile> profilesArrayList) {
		
		Profile currentProfile = null;
		Profile friendProfile = null;
		
		try {
			//Search for the current profile
			currentProfile = searchArrayListForProfileWithName(profilesArrayList,
					profileFriend.getCurrentName());
			
			//Search for the friend's profile
			friendProfile = searchArrayListForProfileWithName(profilesArrayList,
					profileFriend.getFriendName());
			
		} catch (IllegalArgumentException e) {
			/*
			 * If there are no such profiles with the names given,
			 * an error is caught
			 */
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		currentProfile.addFriend(friendProfile);
	}
	
	/**
	 * Searches the given array list of profiles for a profile with
	 * the name as specified.
	 * 
	 * @param profiles the array list of profiles to search into.
	 * 
	 * @param profileName the name that will be used to find the
	 * profile with that name.
	 * 
	 * @return the profile with the name specified.
	 */
	public static Profile searchArrayListForProfileWithName(
			ArrayList<Profile> profiles, String profileName) throws
	IllegalArgumentException {
		
		/*
		 * Loop through each of the profile elements of the array list
		 * profiles and return the current profile if it has a name
		 * equal to the given name.
		 */
		for(Profile profile : profiles) {
			if(profile.getName().equalsIgnoreCase(profileName)) {
				return profile;
			}
		}
		
		/*
		 * If the program reaches here, it means that it hasn't returned
		 * a profile yet because no profiles were found with the name
		 * equal to the given name.
		 * 
		 * If this is the case an error is thrown.
		 */
		throw new IllegalArgumentException("There is no profile with name \"" +
				profileName + "\" that exists");
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDateOfBirthDate() {
		return dateOfBirth;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth.getBritishDateString();
	}
	
	public String getTownOfResidence() {
		return townOfResidence;
	}
	
	public void setTownOfResidence(String townOfResidence) {
		this.townOfResidence = townOfResidence;
	}
	
	public String getCountryOfResidence() {
		return countryOfResidence;
	}
	
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public ArrayList<String> getInterests() {
		return interests;
	}
	
	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}
	
	public void addFriend(Profile p) {
		friends.add(p);
	}
	
	public Profile getFriend(int index) {
		return friends.get(index);
	}
	
	public int getAmountOfFriends() {
		return friends.size();
	}
	
	public String getDescription() {
		String profileDescription;
		
		profileDescription = "Profile Name: " + getName() + '\n';
		profileDescription += "Date Of Birth: " + getDateOfBirth() + '\n';
		profileDescription += "Town Of Residence: " + getTownOfResidence() + '\n';
		profileDescription += "Country Of Residence: " + getCountryOfResidence() + '\n';
		profileDescription += "Nationality: " + getNationality() + '\n';
		profileDescription += "Interests: " + getInterests() + '\n';
		profileDescription += "Friends: ";
		
		for(Profile friend : friends) {
			profileDescription += friend.getName();
			
			//If we have not reached the end of the list yet
			if(friend != getFriend(getAmountOfFriends()-1)) {
				profileDescription += ", ";
			}
		}
		
		return profileDescription;
	}
	
	@Override
	public String toString() {
		return getDescription();
	}
}
