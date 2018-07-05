import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @File 	DES.java
 * @author 	Phillip James, Annabel Kimber, Michael Davies 
 * @version 2.0
 * @see 	
 * @date 	March 2018 *
 * @brief 	Hosts the methods needed to encrypt using DES.
 *
 */

public class DES {
	static Cipher cipher;
	
	public DES() throws Exception {
		cipher = Cipher.getInstance("DES");
		
	}
	
	/**
	 * Encrypts the plaintext byte array using DES
	 * @param plainText
	 * @param secretKey
	 * @return
	 * @throws Exception
	 */

	public byte[] encrypt(byte[] plainText, SecretKey secretKey) throws Exception {
		
		//Convert plain text into byte representation
		//byte[] plainTextByte = plainText.getBytes();
		
		//Initialise the cipher to be in encrypt mode, using the given key.
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		return cipher.doFinal(plainText);
	}

	/**
	 * Encrypts the plaintext string DES
	 * @param plainText
	 * @param secretKey
	 * @return encrypted plaintext
	 * @throws Exception
	 */
	public byte[] encrypt(String plainText, SecretKey secretKey) throws Exception {
		return encrypt(plainText.getBytes(), secretKey);
	}
	
	/**
	 * Decrypts the plaintext byte array using DES
	 * @param encryptedText
	 * @param secretKey
	 * @return decrypted plaintext
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] encryptedText, SecretKey secretKey) throws Exception {
		//Get a new Base64 (ASCII) decoder and use it to convert ciphertext from a string into bytes

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			//Perform the decryption
			byte[] decryptedByte = cipher.doFinal(encryptedText);

			System.out.println("Successful!");
			
			return decryptedByte;
		
		
	}
	
	/**
	 * Generates a random secret key from int
	 * @return secretKey
	 * @throws NoSuchAlgorithmException
	 */
	public SecretKey generateRandomKey() throws NoSuchAlgorithmException{
		//Use java's key generator to produce a random key.
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		SecretKey secretKey = keyGenerator.generateKey();
		
		//print the key
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		//System.out.println(encodedKey);

		return secretKey;
	}
	
	/**
	 * Generates a random secret key from a byte array
	 * @param array
	 * @return secretKey
	 * @throws Exception
	 */
	public SecretKey generateKeyFromArray(byte[] array) throws Exception{
		
		//Generate secret key using
		SecretKeySpec secretKey = new SecretKeySpec(array, "DES");
		
		//print the key
		String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		//System.out.println(encodedKey);
		
		return secretKey;
	}
	
	
}