package com.abc.dataprovider;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.abc.util.PropertyFileRead;

public class ExcelDataProvider {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method


@DataProvider
public static Object[][] getData()
{
	// Excel Read
	
	String xlsPath = System.getProperty("user.dir") + "\\data.xls";
	//String xlsPath = PropertyFileRead.FileRead("DBDetail.properties","DataProviderExcelPath"); // Use this path if File is kept in remote location other than project
	int TotalRows =0;
	 FileInputStream fis;
	 Object[][] data = null;
	try {
		fis = new FileInputStream(xlsPath);
	
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
		
        int index = workbook.getSheetIndex(PropertyFileRead.FileRead("DBDetail.properties","DataProviderExcelFileSheetName"));
       
        HSSFSheet sheet = workbook.getSheetAt(index);
        //HSSFSheet sheet = workbook.getSheet("Sheet1");
         TotalRows = sheet.getLastRowNum();
        int TotalCols = sheet.getRow(0).getLastCellNum();
        data = new Object[TotalRows][1];
        System.out.println("Total No of Column found in Excel Data Provider" +TotalCols );
        for (int i = 1; i <= TotalRows; i++) {
        	HSSFRow row = sheet.getRow(i);
        	ArrayList<String> data33 = new ArrayList<String>();
        	//row.getCell(1).getStringCellValue()
        	for (int j = 0; j <= TotalCols-1; j++) {
        		System.out.println("Excel Data in Column number "+ j + " is ::" +row.getCell(j).getStringCellValue());
        		data33.add(row.getCell(j).getStringCellValue());
        		
        	}
        	
        	
        	data[i-1][0] =new ExcelDataProviderObject(data33);
        
        }
	
		} 
	 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

return data;
}





@DataProvider
public static Object[][] getGoogleMapsData()
{
	// Excel Read
	
	String xlsPath = System.getProperty("user.dir") + "\\data.xls";
	//String xlsPath = PropertyFileRead.FileRead("DBDetail.properties","DataProviderExcelPath"); // Use this path if File is kept in remote location other than project
	int TotalRows =0;
	 FileInputStream fis;
	 Object[][] data = null;
	try {
		fis = new FileInputStream(xlsPath);
	
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
		
        int index = workbook.getSheetIndex("GoogleMapData");
       
        HSSFSheet sheet = workbook.getSheetAt(index);
        //HSSFSheet sheet = workbook.getSheet("Sheet1");
         TotalRows = sheet.getLastRowNum();
        int TotalCols = sheet.getRow(0).getLastCellNum();
        data = new Object[TotalRows][1];
        System.out.println("Total No of Column found in Excel Data Provider" +TotalCols );
        for (int i = 1; i <= TotalRows; i++) {
        	HSSFRow row = sheet.getRow(i);
        	ArrayList<String> data33 = new ArrayList<String>();
        	//row.getCell(1).getStringCellValue()
        	for (int j = 0; j <= TotalCols-1; j++) {
        		System.out.println("Excel Data in Column number "+ j + " is ::" +row.getCell(j).getStringCellValue());
        		data33.add(row.getCell(j).getStringCellValue());
        		
        	}
        	
        	
        	data[i-1][0] =new ExcelDataProviderObject(data33);
        
        }
	
		} 
	 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

return data;
}

}
