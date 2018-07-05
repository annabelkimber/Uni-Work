import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * What does the class do?
 */

/**
 * @File 	Main.java
 * @author 	Annabel Kimber, Michael Davies 
 * @version 1.0
 * @date 	March 2018
 * @see  	Encryption.java, FileReader.java, Generating Puzzles.java, KeyLookUp.java, 
 * 			Messages.java, Puzzle.java, DES.java
 * @brief 	Runs the method calls which start the puzzle exchange between Alice and Bob
 */

public class Main {
	
	final static File PUZZLE_FILE = new File("puzzles.bin");
	
	/**
	 * Runs all the method calls
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		Encryption eN = new Encryption();
		PuzzleCracker c = new PuzzleCracker();
		PuzzleGenerator pG = new PuzzleGenerator();
		Messages m = new Messages();
		FileReader f = new FileReader();
		DES dess = null;
		try {
			dess = new DES();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Puzzle> puzzleList = PuzzleGenerator.generatePuzzles(PuzzleGenerator.generateUniqueRandomIds(PuzzleGenerator.PUZZLE_NUMBER));
	
		try {			
			ArrayList<byte[]> encryptedPuzzles = Encryption.encryptPuzzles(puzzleList);
			FileReader.writeToFile(PUZZLE_FILE, encryptedPuzzles);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Read file for Bob
		byte[] receivedEncryptedData = FileReader.readFromFile(PUZZLE_FILE);
		
		int amountOfPuzzles = (receivedEncryptedData.length)/Puzzle.PUZZLE_SIZE_BYTES;
		
		//System.out.println("received encrypted data " + CryptoLib.getHexStringRepresentation(receivedEncryptedData));
		//System.out.println("length:  " + amountOfPuzzles); //2
		
		//Creating ArrayList to store puzzles in byte format
		Puzzle p;
		ArrayList<Puzzle> puzzleListTry = new ArrayList<Puzzle>();
		ArrayList<byte[]> receivedPuzzles = new ArrayList<byte[]>();
		//Creating a temp array to store 32 bytes extracted from the array
		byte[] temp = new byte[32];
		
		//for loop to split each puzzle into 32 bytes
		for(int i=0; i < (receivedEncryptedData.length)/Puzzle.PUZZLE_SIZE_BYTES; i++) {
		//for(int i=0; i < 2; i++) {
			//Splitting receivedEncryptedData into 32 byte sections in multiples of 32
			System.arraycopy(receivedEncryptedData, (i*temp.length), temp, 0, (temp.length));
			//Adding each split item to the receivedPuzzle ArrayList 
			//p = new Puzzle(temp);
			receivedPuzzles.add(temp);
			
			//receivedPuzzles.add(temp);
			//System.out.println("try puzzle arraylist: " + puzzleListTry.get(i));
			//System.out.println("hi" + i);
			//System.out.println("Received " + CryptoLib.getHexStringRepresentation(receivedEncryptedData));
		}
		//System.out.println("Check1");
		Random rand = new Random();
		//Generate random number bounded by the size of receivedPuzzles
		int  n = rand.nextInt(receivedPuzzles.size());
		//gets the puzzles at position "n" in receivedPuzzles
		byte[] chosenRandomPuzzle = receivedPuzzles.get(0);	
		//System.out.println("thats the chosen encrypted  puzzle to decrypt: " + chosenRandomPuzzle);
		Puzzle finalPuzzle;
		try {
			//System.out.println("Check2");
			//Bob's cracked puzzle
			finalPuzzle = PuzzleCracker.crackPuzzle(chosenRandomPuzzle, Puzzle.KEY_LENGTH);
			System.out.println("final puzzle " + finalPuzzle.toString());
			toString("Bob's key", finalPuzzle.getPuzzleKey());
			System.out.println("key to puzzle " + CryptoLib.getHexStringRepresentation(finalPuzzle.getPuzzleKey()));
			
			SecretKey recipientKey = new DES().generateKeyFromArray(finalPuzzle.getPuzzleKey());
			
			//Alice gets the cracked puzzle number 
			//then finds the corresponding puzzle within her own list
			Puzzle foundPuzzle = KeyLookUp.lookupPuzzle(finalPuzzle.getPuzzleNumber(), puzzleList);
			toString("Alice's key", finalPuzzle.getPuzzleKey());
			SecretKey foundKey = new DES().generateKeyFromArray(foundPuzzle.getPuzzleKey());
			
			//Alice sending a message using foundKey
			//Bob decrypts it using recipientKey
			Messages.receiveMessage(Messages.encryptMessage("Alice", "Hello Bob", recipientKey), foundKey);
			
		} catch (Exception e) {	e.printStackTrace();}
		
	}	
	
	/**
	 * Converts bytes to string so they can be printed out to test
	 * @param text
	 * @param cryptogram
	 */
	public static void toString(String text, byte[] cryptogram) {
		int i=1;
		for(byte b : cryptogram) {			
			//System.out.println(i+text + Integer.toBinaryString(b & 255 | 256).substring(1));
			i++;
		}
	}	
}
	

