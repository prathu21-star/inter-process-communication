// Java Program to Display all directories in a directory

import java.io.*;

public class ContentsOfFolder 
{

	// Driver main method
	public static void main(String[] args)
	{
		File folder = new File("C:/Users/Prathu/OneDrive/Documents/DC_EXP/1.IPC");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) 
			{
			    if (file.isFile()) 
				{
        				System.out.println(file.getName());
    				}
			}
	}
}
