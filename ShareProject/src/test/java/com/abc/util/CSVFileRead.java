package com.abc.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

public class CSVFileRead {
	
	/**
	 * @author somasish
	 * @param FilePath - Complete path of the file
	 * Reads CSV File
	 * Example of CSV File
	 * 	"1.0.4.0","1.0.7.255","16778240","16779263","AUSTRALIA"
	 *	"1.0.8.0","1.0.15.255","16779264","16781311","CANADA"
	 *	"1.0.16.0","1.0.31.255","16781312","16785407","JAPAN"
	 *	"1.0.32.0","1.0.63.255","16785408","16793599","CANADA"
	 *	"1.0.64.0","1.0.127.255","16793600","16809983","JAPAN"
	 *	"1.0.128.0","1.0.255.255","16809984","16842751","THAILAND"
	 *	"1.1.0.0","1.1.0.255","16842752","16843007","CANADA"
	 *	"1.1.1.0","1.1.1.255","16843008","16843263","AUSTRALIA"
	 *	"1.1.2.0","1.1.63.255","16843264","16859135","CANADA"
	 *	"1.1.64.0","1.1.127.255","16859136","16875519","JAPAN"
	 *	"1.1.128.0","1.1.255.255","16875520","16908287","THAILAND"
	 */
	 public void readCSVFile(String FilePath, int CollumnNumber) {

			String csvFilePath = FilePath;
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";

			try {

				br = new BufferedReader(new FileReader(csvFilePath));
				while ((line = br.readLine()) != null) {

				        // use comma as separator
					String[] country = line.split(cvsSplitBy);

					System.out.println("Country [code= " + country[3] 
		                                 + " , name=" + country[4] + "]");

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			System.out.println("Done");
		  }
}
