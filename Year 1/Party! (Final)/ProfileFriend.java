/**
 * Used to store the current profile's name and friend's name.
 * 
 * @author Alistair
 * @version 1.0
 */
public class ProfileFriend {
	
	private String currentName;
	private String friendName;
	
	public ProfileFriend(String currentName, String friendName) {
		this.currentName = currentName;
		this.friendName = friendName;
	}
	
	public String getCurrentName() {
		return currentName;
	}
	
	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}
	
	public String getFriendName() {
		return friendName;
	}
	
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	
}
