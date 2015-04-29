package com.abc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;



public class PropertyFileRead {

	
	
	static Properties PropDetails = new Properties();
	InputStream input = null;
	OutputStream output = null;
	
	/*************************************************************
	 * @author :Somasish
	 * @Method_Name: FileRead
	 * @Description : Property File Read
	 * @param: FileName- Complete path of file
	 * @param: ObName- Object to be read from the file
	 * @return: ObValue - Value of the Object read from file
	 * ***********************************************************/
	public static String FileRead(String FileName, String ObName)
	{
		try {
			 System.out.println("Filename =" + FileName );
			
			 InputStream FilePath =  PropertyFileRead.class.getResourceAsStream("/resources/"+FileName);
				 
			// load a properties file
			PropDetails.load(FilePath);
			
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		String ObValue = PropDetails.getProperty(ObName);
		return ObValue;
	}
	/*************************************************************
	 * @author :Somasish
	 * @Method_Name: FileWrite
	 * @Description : Property File Write
	 * @param: FileName- Complete path of file
	 * @param: ObName- Object to be write into the file
	 * @param: ObValue - Value of the Object written to the file
	 * ***********************************************************/
	public void FileWrite(String FileName, String ObName, String ObValue)
	{
		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	    BufferedWriter out = new BufferedWriter(new FileWriter("c://output.txt"));
	    
	        String inputLine = null;
	        do {
	            inputLine=in.readLine();
	            out.write(inputLine);
	            out.newLine();
	        } while (!inputLine.equalsIgnoreCase("eof"));
	        System.out.print("Write Successful");  
	        out.close();
	        in.close();
	    } catch(IOException e1) {
	        System.out.println("Error during reading/writing");
	    } 
	   	
	}
	
	
	
	}
	
	

