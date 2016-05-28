import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	
	public static String checkSum(String path) throws NoSuchAlgorithmException, IOException
	{
		String checksum = null;
		try 
		{
			FileInputStream in = new FileInputStream(path);
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] buffer = new byte [8192];
			int numOfBytesRead;
			while((numOfBytesRead = in.read(buffer)) > 0)
			{
				md.update(buffer, 0, numOfBytesRead);
			}
			byte[] hash = md.digest();
			checksum = new BigInteger(1, hash).toString(16);
			
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checksum;
		
	}
	
	public static void main(String args[]) throws NoSuchAlgorithmException, IOException
	{
		String filePath = "testfile.txt";
		String filePath1 = "testfile1.txt";
		System.out.println("Checksum = " + checkSum(filePath));
		System.out.println("Checksum2 = " + checkSum(filePath1));
	}

}
