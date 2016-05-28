import java.io.File;

public class FilesDirectories {
	
	public static void main(String args[])
	{
		File file = new File("E:\\");
		String[] names = file.list();   //List of all files and folders in a directory

		for(String name : names)
		{
		    if (new File("C:\\Users\\Ankit\\" + name).isDirectory())  
		    {
		        System.out.println(name);
		    }
			
			System.out.println(name);
		}
	}

}
