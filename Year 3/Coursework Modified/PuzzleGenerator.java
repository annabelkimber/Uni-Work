import java.util.ArrayList;
import java.util.Collections;

/**
 * Generates puzzleId's as well as the puzzles themselves.

/**
 * @File PuzzleGenerator.java
 * @author Annabel Kimber, Michael Davies 
 * @version 1.0
 * @date March 2018
 * @see 
 * @brief Generates the puzzles and shuffles the puzzleIds.
 * \n \n
 * 
 */

public class PuzzleGenerator {
	final static int PUZZLE_NUMBER = 2;
		
	/**
	 * Generating each unique random ID, by shuffling each puzzleId. 
	 * @param numberOfIds
	 * @return puzzleIds
	 */
	public static ArrayList<Integer> generateUniqueRandomIds(int numberOfIds) {
		ArrayList<Integer> puzzleIds = new ArrayList<Integer>(numberOfIds);
		for (int i=0; i<PUZZLE_NUMBER; i++) {
	    	puzzleIds.add(i);
	    }	    
	    Collections.shuffle(puzzleIds);
		return puzzleIds;
	}

	/**
	 * Creates an array list of generated puzzles through the id list. 
	 * @param idList
	 * @return puzzleArray
	 */
	public static ArrayList<Puzzle> generatePuzzles (ArrayList<Integer> idList){
		ArrayList<Puzzle> puzzleArray = new ArrayList<Puzzle>(idList.size());
		for(int i = 0; i<idList.size(); i++ ) {
			Puzzle p = new Puzzle(idList.get(i));
			puzzleArray.add(p);		
		}
		return puzzleArray;
	}
}
