import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @File Messages.java
 * @author Annabel Kimber, Michael Davies 
 * @version 1.0
 * @see DES.java
 * @date March 2018 
 * @brief Manages messages as well as the encryption and what they contain. 
 * \n \n
 * 
 */

public class Messages {
	/**
	 * Encrypts messages by using the secret key and DES class
	 * @param sender
	 * @param message
	 * @param secretKey
	 * @return encryptedMessage
	 * @throws Exception
	 */
	public static byte[] encryptMessage(String sender, String message, SecretKey secretKey) throws Exception {
		
		System.out.println(sender + ": " + message);
		byte[] encryptedMessage = new DES().encrypt(message, secretKey);
		System.out.println("Encrypted Message: " + CryptoLib.getHexStringRepresentation(encryptedMessage));
		
		return encryptedMessage;
	}
	
	/**
	 * Decrypts messages by using the secret key and DES class
	 * @param encryptedMessage
	 * @param secretKey
	 * @throws Exception
	 */
	public static void receiveMessage(byte[] encryptedMessage, SecretKey secretKey) throws Exception {
			
		byte[] decryptedMessageBytes = new DES().decrypt(encryptedMessage, secretKey);
		System.out.println("Decrypted Message: " + new String(decryptedMessageBytes));
	}
}
