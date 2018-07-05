import java.util.ArrayList;
import java.util.Arrays;

/**
 * What does 
 */

/**
 * @File KeyLookUp.java
 * @author Annabel Kimber, Michael Davies 
 * @version 1.0
 * @date March 201
 * @sees CryptoLib.java
 * @brief Manages messages as well as the encryption and what they contain. 
 * \n \n
 * 
 */

public class KeyLookUp {
	/**
	 * An overloaded method that accepts an int, converts it to a byte array
	 * @param puzzleNumber
	 * @param puzzleList
	 * @return p
	 */
		public static Puzzle lookupPuzzle(int puzzleNumber, ArrayList<Puzzle> puzzleList) {
			//Return call to pass puzzleNum through a class, so it can be taken as a byte[]
			//Further down
			return  lookupPuzzle(CryptoLib.smallIntToByteArray(puzzleNumber), puzzleList);
		}
		
		/**
		 * Returns a puzzle from puzzleList based on puzzleNum
		 * @param puzzleNumber
		 * @param puzzleList
		 * @return p
		 */
		public static Puzzle lookupPuzzle(byte[] puzzleNumber, ArrayList<Puzzle> puzzleList) {
			//For each puzzle p in puzzle list
			for(Puzzle p : puzzleList) {
				//Check if the puzzle number of p matches the required puzzle number
				if(Arrays.equals(p.getPuzzleNumber(), puzzleNumber)) {
					//then return that puzzle
					return p;
				}	
			}
			//If not return null
			return null;
		}
}
