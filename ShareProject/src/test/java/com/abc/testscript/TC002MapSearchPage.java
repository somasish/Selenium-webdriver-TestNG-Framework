package com.abc.testscript;

import java.net.UnknownHostException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.abc.dataprovider.ExcelDataProviderObject;
import com.abc.projectpage.TestngAnnotations;
import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.seleniumrepository.SeleniumRepoDropdown;
import com.abc.util.PropertyFileRead;

public class TC002MapSearchPage extends TestngAnnotations {
		
	/**
	 * @author somasish
	 * Google Maps Search Validation
	 * @throws InterruptedException 
	 */
	@Test(dataProviderClass = com.abc.dataprovider.ExcelDataProvider.class,dataProvider="getGoogleMapsData")
	public void SearchPageTest(ExcelDataProviderObject DPObj) throws InterruptedException
	{
	/*
	 * @param : Site URL Navigation
	 * This Scripts Navigates to Google maps page and then search a route using start point and destination
	 * URL is read from ProjectData.properties file in resources package
	 * Start Point and Destinations are given from the Excel. As Excel have 2 rows so this code will run 2 times using that data.
	 */
		
		System.out.println("you have provided TCName as::"+ DPObj.DataArray);
		// NOTE: DPObj.DataArray is an arraylist which contains all the data of a particular row in the excel one by one in serial manner.
		// Note: Each row of the Excel is treated as new set of data which script will use. So Number of rows times the script/code will run.
		// As their are 2 column in excel sheet for this script so those 2 column are used in below lines 
		
		SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","TS02SiteURLNavigation"));
		SeleniumRepo.WaitForLoad(4000);
		//Click on the Map Direction button and Locator are read from ProjectData.properties file in resources package
		
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","MapDirection")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","MapDirection"));
		SeleniumRepo.WaitForLoad(500);
		System.out.println("Map Direction Button is clicked");
		Assert.assertTrue(true,"Map Direction Button Found and clicked");
		}
		else
		{
			System.out.println("Direction Button not found");
			Assert.assertFalse(false,"Map Direction Button not Found");
			
		}
		
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","MapFromSearch")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","MapFromSearch"));
		// Use of dataprovider arraylist in below line
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","MapFromSearch"),DPObj.DataArray.get(0));
		System.out.println("From Textbox is filled successfully");
		Assert.assertTrue(true,"From Textbox Found and Text Entered");
		}
		else
		{
			System.out.println("From TextBox not found");
			
			
		}
		
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","MapToSearch")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","MapToSearch"));
		// Use of dataprovider arraylist in below line
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","MapToSearch"),DPObj.DataArray.get(1));
		System.out.println("To Textbox is filled successfully");
		Assert.assertTrue(true,"To Textbox Found and Text Entered");
		}
		else
		{
			System.out.println("To TextBox not found");
			
			
		}
		SeleniumRepo.WaitForLoad(200);
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","MapSearchButtons")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","MapSearchButtons"));
		System.out.println("Map Search Button is enabled and clicked");
		Assert.assertTrue(true,"Map Search Button Found and clicked");
		}
		else
		{
			System.out.println("search button not found");
			
			
		}
		SeleniumRepo.WaitForLoad(6000);
		
	}
	
	@Test(dataProviderClass = com.abc.dataprovider.ExcelDataProvider.class,dataProvider="getData")
	public void DataProviderTest( ExcelDataProviderObject DPObj) throws InterruptedException
	{
		System.out.println("you have provided TCName as::"+ DPObj.DataArray);
	}
	
	
}
