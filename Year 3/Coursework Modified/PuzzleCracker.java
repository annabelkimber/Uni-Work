import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;

public class PuzzleCracker {
	/**
	 * Cracks the encrypted puzzle
	 * @param chosenRandomPuzzle
	 * @param keyLength
	 * @return
	 * @throws Exception
	 */
	public static Puzzle crackPuzzle(byte[]chosenRandomPuzzle, int keyLength) throws Exception {
		//System.out.println("Check 3");
		int maxKeySize = (int) Math.pow(2, keyLength);
		for(int i = 0; i < maxKeySize; i++) {
			//System.out.println("Check 4");
			byte[] keyNumber = CryptoLib.smallIntToByteArray(i);
			
			SecretKey trialSecretKey = Encryption.replaceWithZeroes(keyNumber);	
			try { 
				byte[] trialDecryptedPuzzle = attemptCrack(chosenRandomPuzzle, trialSecretKey);				
				//System.out.println("Check 5");
				byte[] temp = new byte[16];
				byte[] checkBits = new byte[16];
				System.arraycopy(trialDecryptedPuzzle, 0, checkBits, 0, checkBits.length);
				if(Arrays.equals(checkBits, temp)) {
					System.out.println("Decrypted: " + i);
					return new Puzzle(trialDecryptedPuzzle);
				}
			} catch(BadPaddingException e) {
				System.out.println("This is the wrong key: " + i );
				continue;
			}
		}
		return null;
	}
	
	/**
	 * Attempts to crack the puzzle using the decrypt method
	 * @param puzzle
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] attemptCrack(byte[] puzzle, SecretKey key) throws Exception {
		DES des = new DES();
		byte[] cracked = des.decrypt(puzzle, key); 
		
		return cracked;
	} 
}
