import java.security.SecureRandom;

import javax.crypto.spec.SecretKeySpec;

/**
 * @File 	Puzzle.java
 * @author 	Annabel Kimber, Michael Davies 
 * @version 1.0
 * @see 	CryptoLib.java
 * @date 	March 2018 
 * @brief  	Creates a cryptogram puzzle made up of 
 * 			zero bits, puzzle number and a key.
 */
public class Puzzle {
		
	private byte[] zeroBits;
	private byte[] puzzleNumber = new byte[2];
	private byte[] puzzleKey = new byte[8];
	
	final static int PUZZLE_SIZE_BYTES = 32;
	final static int KEY_LENGTH = 16;

	/**
	 * Generating a single puzzle via the constructor.	
	 * @param puzzleID
	 */
	public Puzzle(int puzzleID) {
		try {
			//Setting the zeroBits attribute to a new 16 byte array consisting of 128 bits of value 0 
			zeroBits = new byte[16];
			for(int i = 0; i < zeroBits.length; i++)zeroBits[i] = 0;
			
			Main.toString("Zero", zeroBits);
			//Setting the puzzleNumber attribute to a new 2 byte array
			puzzleNumber = new byte[2];
			puzzleNumber = CryptoLib.smallIntToByteArray(puzzleID);
			Main.toString("Num", puzzleNumber);
			
			//Setting the key attribute to a new 8 byte array
			puzzleKey = new byte[8];
			SecureRandom random = new SecureRandom();
			random.nextBytes(puzzleKey);
			
			//Setting the key attribute to a new 8 byte array
			SecretKeySpec secretKey = new SecretKeySpec(puzzleKey, "DES");
			puzzleKey = secretKey.getEncoded();

			Main.toString("Key", puzzleKey);
			//System.out.println();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a byte array of data made up of 
	 * zero bits, 
	 * @param data
	 */
	public Puzzle (byte[] data) {
		this.zeroBits = new byte[16];
		for(int i = 0; i < zeroBits.length; i++)zeroBits[i] = 0;
		
		System.arraycopy(data, 16, this.puzzleNumber, 0, this.puzzleNumber.length);
		System.arraycopy(data, 18, this.puzzleKey, 0, this.puzzleKey.length);
	}
	/**
	 * 
	 * @return cryptogram
	 */
	//concatting them all together
	public byte[] toByteArray() {
		byte[] cryptogram = new byte[26];
		System.arraycopy(zeroBits, 0, cryptogram, 0, zeroBits.length);		
		System.arraycopy(puzzleNumber, 0, cryptogram, (zeroBits.length), puzzleNumber.length);
		System.arraycopy(puzzleKey, 0, cryptogram, (zeroBits.length + puzzleNumber.length), puzzleKey.length);
		return cryptogram;
	}

	public byte[] getPuzzleNumber() { return this.puzzleNumber;}
	
	public byte[] getPuzzleKey() { return this.puzzleKey;}
	
	
	
	
}
