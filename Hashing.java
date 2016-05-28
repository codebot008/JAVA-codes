import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	
	public static void checkSum(String path) throws NoSuchAlgorithmException, IOException
	{
		String checksum = null;
		try 
		{
			FileInputStream in = new FileInputStream(path);
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;
			StringBuffer fileContents = new StringBuffer("\0");
			while((line = br.readLine())!= null)
			{
				fileContents.append(line);
			}
			String file = fileContents.toString();
			System.out.println(file);
			file = file.replaceAll("[ \t\n]","");
			System.out.println(file);
			byte[] buffer = file.getBytes("UTF-8");
			 /*
			int numOfBytesRead;
			while((numOfBytesRead = in.read(buffer)) > 0)
			{
				md.update(buffer, 0, numOfBytesRead);
			}*/
			byte[] hash = md.digest();
			checksum = new BigInteger(1, hash).toString(16);
			
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*return checksum;*/
		
	}
	
	public static void main(String args[]) throws NoSuchAlgorithmException, IOException
	{
		String filePath = "testfile.txt";
		String filePath1 = "testfile1.txt";
		checkSum(filePath);
		/*System.out.println("Checksum = " + checkSum(filePath));
		System.out.println("Checksum2 = " + checkSum(filePath1));*/
	}

}
