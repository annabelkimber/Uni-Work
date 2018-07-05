import java.util.ArrayList;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * What does the class do?
 */

/**
 * @File Encryption.java
 * @author Annabel Kimber, Michael Davies 
 * @version 1.0
 * @date March 2018 
 * @see DES.java
 * @brief Manages the encryption of the plaintext puzzle. 
 * \n \n
 * 
 */

public class Encryption {
	
	
	/**
	 * Replaces the end 48 zeros 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static SecretKey replaceWithZeroes(byte[] key) throws Exception{
		byte[] zeroes = new byte[8];
		
		System.arraycopy(key, 0, zeroes, 0, 2);
		try {
			SecretKeyFactory sf = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(zeroes);
			return sf.generateSecret(keySpec);
		} catch(Exception e) {e.printStackTrace();}
		//try to think another approach
		return null;
	}
	
	/**
	 * Uses the encrypt method from DES to encrypt the byte array puzzle
	 * @param plainPuzzles
	 * @return encryptedPuzzles
	 * @throws Exception
	 */
	public static ArrayList<byte[]> encryptPuzzles(ArrayList<Puzzle> plainPuzzles) throws Exception { 
		ArrayList<byte[]> encryptedPuzzles = new ArrayList<byte[]>(plainPuzzles.size());
		DES des = new DES(); 
		SecretKey secretKey;
		
		
		for(Puzzle p : plainPuzzles) {
			secretKey = des.generateRandomKey();
			secretKey = replaceWithZeroes(secretKey.getEncoded());
			encryptedPuzzles.add(des.encrypt(p.toByteArray(), secretKey));
			//byte[] encrypted = des.encrypt(p.toByteArray(),sixtyFour);
			//encryptedPuzzles.add(encrypted);
			//System.out.println();
			
			//System.out.println();	
		}
		return encryptedPuzzles;
	}
}
