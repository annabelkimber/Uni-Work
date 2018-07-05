import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Used to load the profiles file and store the data into a binary search tree
 * of profiles.
 * 
 * This also can load the edges file and store the data into the specified
 * profile elements of an already populated profile array list.
 * 
 * @author Alistair
 * @version 1.0
 */
public class FileReader {
	
	/**
	 * Public method that uses the given file name
	 * and attempts to open the file (located with
	 * the given file name) containing profile data
	 * and uses it as a data stream to create a binary
	 * search tree with the individual profiles as
	 * elements.
	 * 
	 * @param fileName The given file name of the
	 * file that contains the profiles.
	 * 
	 * @return Binary search tree with each element
	 * being a profile, each profile should be placed
	 * alphabetically by name (location of profiles
	 * depends on the order given).
	 */
	public static BST readProfiles(String fileName) {
		//Create a file object that can hold the file
		File profilesFile = new File(fileName);
		
		Scanner profilesFileInputStream = null;
		
		/*
		 * Try and use the file for an input stream,
		 * if this is not possible output error message
		 * and close program.
		 */
		try {
			profilesFileInputStream = new Scanner(profilesFile);
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		BST binarySearchTreeProfiles = readProfilesFromDataStream(
				profilesFileInputStream);
		
		profilesFileInputStream.close();
		
		return binarySearchTreeProfiles;
	}
	
	/**
	 * Creates a data stream that will be used to read the file of edges.
	 * 
	 * This method will use the edge list file and the array list of profiles
	 * to add friends to the profiles when defined in the edge list file.
	 * 
	 * @param edgeList The file containing the edges data.
	 * 
	 * @param profilesArrayList The already populated array list that
	 * consists of all the existing profiles.
	 */
	public static void readEdges(File edgeList,
			ArrayList<Profile> profilesArrayList) {
		
		Scanner edgeListFileInputStream = null;
		
		/*
		 * Try and use the file for an input stream,
		 * if this is not possible output error message
		 * and close program.
		 */
		try {
			edgeListFileInputStream = new Scanner(edgeList);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		readEdgesFromDataStream(edgeListFileInputStream, profilesArrayList);
		
		edgeListFileInputStream.close();
	}
	
	/**
	 * Uses the given scanner for reading the profiles file,
	 * reads each line and creates a profile instance to
	 * insert into the newly created binary search tree.
	 * 
	 * @param profilesFileInputStream The given scanner that
	 * will read the file.
	 * 
	 * @return Binary search tree with each element
	 * being a profile, each profile should be placed
	 * alphabetically by name (location of profiles
	 * depends on the order given).
	 */
	private static BST readProfilesFromDataStream(Scanner profilesFileInputStream) {
		BST binarySearchTreeProfiles = new BST();
		
		/*
		 * While the next line exists, get the next line and
		 * create a new profile instance from it and
		 * insert it into the binary tree.
		 */
		while (profilesFileInputStream.hasNextLine()) {
			String profileLine = profilesFileInputStream.nextLine();
			
			Profile profile = getProfileDataFromLine(profileLine);
			binarySearchTreeProfiles.insertProfile(profile);
		}
		
		return binarySearchTreeProfiles;
	}
	
	/**
	 * Creates a profile instance from the given profile line.
	 * 
	 * @param profileLine A line of text that contains data
	 * about a profile.
	 * 
	 * @return A new profile instance consisting of the data
	 * given from the profile line.
	 */
	private static Profile getProfileDataFromLine(String profileLine) {
		/*
		 * Create a new Scanner instance and use the profile line
		 * for an input stream.
		 */
		Scanner profileLineInputStream = new Scanner(profileLine);
		
		//Let the scanner get data separated by a ',' or a ';'
		profileLineInputStream.useDelimiter(",|;");
		
		String profileName = profileLineInputStream.next();
		
		/*
		 * Read the day, month and year and respectively use
		 * this to create a new Date instance.
		 */
		Date profileDateOfBirth = new Date(
				profileLineInputStream.nextInt(),
				profileLineInputStream.nextInt(),
				profileLineInputStream.nextInt());
		
		String profileTown = profileLineInputStream.next();
		String profileCountry = profileLineInputStream.next();
		String profileNationality = profileLineInputStream.next();
		
		/*
		 * For the remaining part of the line, read all of
		 * the interests and for each interest add them onto
		 * an array list.
		 */
		ArrayList<String> interests = new ArrayList<String>();
		
		//While there is more data next
		while(profileLineInputStream.hasNext()) {
			interests.add(profileLineInputStream.next());
		}
		
		profileLineInputStream.close();
		
		Profile newProfile = new Profile(profileName, profileDateOfBirth,
				profileTown, profileCountry, profileNationality, interests);
		
		return newProfile;
	}
	
	/**
	 * Uses the given data stream to read each line and pass them onto
	 * another method, an instance is returned and is used to make a
	 * relationship, an error can occur if there is no profile that
	 * exists with a name of either one of the two given names (the
	 * current profile name or the friend's name).
	 * 
	 * @param edgeListFileInputStream The input stream of the file that
	 * will be used to read each line.
	 * 
	 * @param profileArrayList The already populated array list that
	 * consists of all the existing profiles.
	 */
	private static void readEdgesFromDataStream(Scanner edgeListFileInputStream,
			ArrayList<Profile> profileArrayList) {
		
		//While there is another line to read
		while(edgeListFileInputStream.hasNext()) {
			String edgeLine = edgeListFileInputStream.nextLine();
			
			/*
			 * Get the current profile name and friend name from the line,
			 * this is done by returning an object that consists of two
			 * attributes, one that holds the current profile name and
			 * one that holds the friend's name.
			 */
			ProfileFriend profileFriend = getProfileFriendDataFromLine(edgeLine);
			
			Profile.makeRelationship(profileFriend, profileArrayList);
		}
	}
	
	/**
	 * This method will get the current profile name and the friend's name
	 * from the given edge line.
	 * 
	 * @param edgeLine The line of text that contains data of an edge.
	 * 
	 * @return A new instance that holds the current profile name and the
	 * friend's name.
	 */
	private static ProfileFriend getProfileFriendDataFromLine(String edgeLine) {
		Scanner in = new Scanner(edgeLine);
		in.useDelimiter(",");
		
		String currentName = in.next();
		String friendName = in.next();
		
		ProfileFriend newProfileFriend = new ProfileFriend(currentName,friendName);
		
		in.close();
		
		return newProfileFriend;
	}
	
}
