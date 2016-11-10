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

import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.seleniumrepository.SeleniumRepoDropdown;
import com.abc.util.PropertyFileRead;

public class TC002MapSearchPage {
	@BeforeMethod
	public void BeforeTest() throws UnknownHostException
	{
	/*
	 * @param 1: Browser name -firefox or internetExplorer or chrome
	 *  Below firefox string is being read from the ProjectData.property file in resources package
	 *  
	 *  @param 2: Browser Proxy Yes or No. If yes then port and Host details are read from the Property file
	 */
		System.out.println("TestCase Starts");
		SeleniumRepo.startBrowser(PropertyFileRead.FileRead("ProjectData.properties","BrowserType"), false);
		SeleniumRepo.driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void AfterTest() throws UnknownHostException
	{
	System.out.println("TestCase Ends");
		SeleniumRepo.driver.quit();
		
	}
	
	/**
	 * @author somasish
	 * Google Maps Search Validation
	 * @throws InterruptedException 
	 */
	@Test
	public void SearchPageTest() throws InterruptedException
	{
	/*
	 * @param : Site URL Navigation
	 * URL is read from ProjectData.properties file in resources package
	 */
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
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","MapFromSearch"),"Bangalore");
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
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","MapToSearch"),"Chennai");
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
	
	
}
