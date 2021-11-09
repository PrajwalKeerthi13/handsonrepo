package com.handson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {
	
	public static void main(String[] args){
		String sourcefile ="C:/Program Files/Java/jdk1.8.0_65/README.html";
		String destFile =" info.txt";
		
		
		try(FileInputStream fis = new FileInputStream(sourcefile);
				FileOutputStream fos = new FileOutputStream(destFile);){
			
			int size=fis.available();
			byte[] data = new byte[size];
			FileOutputStream fos1 = new FileOutputStream("info.txt");

			fis.read(data);
			fos1.write(data);
			

			fis.close();
			fos1.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

}  

}

		
	}


