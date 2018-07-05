import java.util.ArrayList;

/**
 * Used to test the profile to see if the constructor and some
 * of the methods work properly.
 * 
 * @author Alistair
 * @version 1.0
 */
public class ProfileMain {
	
	public static void main(String[] args) {
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		
		profiles = createProfiles();
		
		/*
		 * Make profile at index 5 (Owen Reese) be friends with profile
		 * at index 7 (Jess Howard) and vice versa
		 */
		profiles.get(5).addFriend(profiles.get(7));
		profiles.get(7).addFriend(profiles.get(5));
		
		/*
		 * Make profile at index 1 (Luke Jones) have a town of residence
		 * of "Groves Hill" and a country of residence of "Wales"
		 */
		profiles.get(1).setCountryOfResidence("Wales");
		profiles.get(1).setTownOfResidence("Groves Hill");
		
		/*
		 * Make profile at index 3 (Sophie Laurence) have a nationality
		 * of "English"
		 */
		profiles.get(3).setNationality("English");
		
		/*
		 * Set the interests of the profile at index 4 (Kyle Davis) to be
		 * "Football" and "Chemistry".
		 */
		ArrayList<String> newInterests = new ArrayList<String>();
		newInterests.add("Football");
		newInterests.add("Chemistry");
		
		profiles.get(4).setInterests(newInterests);
		
		//Print the description of each profile of the array list
		for(Profile profile : profiles) {
			System.out.println(profile.getDescription());
			System.out.println();
		}
	}
	
	/**
	 * @return an array list of profiles that I have defined
	 */
	public static ArrayList<Profile> createProfiles() {
		ArrayList<String> interests = new ArrayList<String>();
		
		interests.add("Football");
		interests.add("Maths");
		interests.add("Mechanics");
		
		Profile profileJack = new Profile("Jack Lewis",
				new Date(20,6,2000),
				"Groves Hill",
				"Wales",
				"Welsh",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Reading");
		interests.add("Art");
		interests.add("Jogging");
		
		Profile profileLuke = new Profile("Luke Jones",
				new Date(7,2,2010),
				"Dove Lane",
				"England",
				"Spanish",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Origami");
		interests.add("Computer Graphics");
		
		Profile profileAlice = new Profile("Alice Mart",
				new Date(30,12,1998),
				"Red Forest",
				"England",
				"English",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Art");
		interests.add("Physics");
		interests.add("Basketball");
		interests.add("Football");
		
		Profile profileSophie = new Profile("Sophie Laurence",
				new Date(17,9,1995),
				"Rose Lake",
				"France",
				"French",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Jogging");
		interests.add("Swimming");
		interests.add("Geology");
		
		Profile profileKyle = new Profile("Kyle Davis",
				new Date(15,4,1975),
				"Tulip Central",
				"England",
				"Irish",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Tennis");
		interests.add("Sky Diving");
		interests.add("Computer Science");
		
		Profile profileOwen = new Profile("Owen Reese",
				new Date(13,7,1980),
				"Apple Road",
				"Wales",
				"Scottish",
				interests);
		
		interests = new ArrayList<String>();
		
		Profile profileFlan = new Profile("Flan Red",
				new Date(11,8,2002),
				"Base Lane",
				"England",
				"French",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Reading");
		interests.add("Chemistry");
		interests.add("Physics");
		interests.add("Biology");
		
		Profile profileJess = new Profile("Jess Howard",
				new Date(23,5,1999),
				"Grand Hill",
				"Wales",
				"Swedish",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Racing");
		interests.add("Gaming");
		
		Profile profileAlex = new Profile("Alex Crad",
				new Date(27,1,2003),
				"Ludchurch",
				"Wales",
				"Welsh",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Ice Skating");
		interests.add("Cycling");
		interests.add("Drama");
		
		Profile profileMorgan = new Profile("Morgan Hughes",
				new Date(1,3,1995),
				"Cardigan",
				"Wales",
				"Welsh",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Mechanics");
		interests.add("Physics");
		interests.add("Chemistry");
		
		Profile profileAllen = new Profile("Allen Jones",
				new Date(21,9,1988),
				"Blackwood",
				"Ireland",
				"German",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Gaming");
		interests.add("Basketball");
		interests.add("Geography");
		
		Profile profileEmily = new Profile("Emily Richards",
				new Date(28,5,1993),
				"Coatbridge",
				"Scotland",
				"English",
				interests);
		
		interests = new ArrayList<String>();
		
		interests.add("Jogging");
		interests.add("Gardening");
		
		Profile profileCallum = new Profile("Callum Laurence",
				new Date(13,8,1991),
				"Doncaster",
				"England",
				"Australian",
				interests);
		
		profileJack.addFriend(profileLuke);
		profileLuke.addFriend(profileJack);
		
		profileJack.addFriend(profileAlex);
		profileAlex.addFriend(profileJack);
		
		profileAlex.addFriend(profileAllen);
		profileAllen.addFriend(profileAlex);
		
		profileJack.addFriend(profileAlice);
		profileAlice.addFriend(profileJack);
		
		profileAlice.addFriend(profileSophie);
		profileSophie.addFriend(profileAlice);
		
		profileSophie.addFriend(profileKyle);
		profileKyle.addFriend(profileSophie);
		
		profileLuke.addFriend(profileJess);
		profileJess.addFriend(profileLuke);
		
		profileLuke.addFriend(profileMorgan);
		profileMorgan.addFriend(profileLuke);
		
		profileMorgan.addFriend(profileEmily);
		profileEmily.addFriend(profileMorgan);
		
		profileLuke.addFriend(profileAlex);
		profileAlex.addFriend(profileLuke);
		
		profileOwen.addFriend(profileFlan);
		profileFlan.addFriend(profileOwen);
		
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		
		profiles.add(profileJack);
		profiles.add(profileLuke);
		profiles.add(profileAlice);
		profiles.add(profileSophie);
		profiles.add(profileKyle);
		profiles.add(profileOwen);
		profiles.add(profileFlan);
		profiles.add(profileJess);
		profiles.add(profileAlex);
		profiles.add(profileMorgan);
		profiles.add(profileAllen);
		profiles.add(profileEmily);
		profiles.add(profileCallum);
		
		return profiles;
	}
}
