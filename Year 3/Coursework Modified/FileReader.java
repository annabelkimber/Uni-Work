import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Contains readFromFile and writetoFile methods.
 */

/**
 * @File FileReader.java
 * @author Annabel Kimber, Michael Davies 
 * @version 1.0
 * @date March 2018
 * @see 
 * @brief Manages the reading and writing of files. 
 * \n \n
 * 
 */

public class FileReader{

	/**
	 * Writes the byte array to a binary file
	 * @param encryptFile
	 * @param data
	 */
	public static void writeToFile(File encryptFile, ArrayList<byte[]> data){
		try {
			FileOutputStream fos = new FileOutputStream(encryptFile);
			for(byte[] b : data) {
				fos.write(b);
				Main.toString("puzz", b);
			}
			fos.flush(); 
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads in the data from a binary file
	 * @param file
	 * @return null
	 */
	public static byte[] readFromFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			return data;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}