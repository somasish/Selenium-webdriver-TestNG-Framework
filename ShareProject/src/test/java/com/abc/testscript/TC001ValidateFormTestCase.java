package com.abc.testscript;
import java.awt.AWTException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

import com.abc.projectpage.TestngAnnotations;
import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.seleniumrepository.SeleniumRepoCheckBox;
import com.abc.seleniumrepository.SeleniumRepoDropdown;
import com.abc.util.PropertyFileRead;
/**
 * 
 * @author somasish
 * Search related functionality testcases
 */

public class TC001ValidateFormTestCase extends TestngAnnotations {
	
	
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
	 * Goes to a specific site and performs Search Suggestion Test
	 * @throws InterruptedException 
	 */
	@Test
	public void FormValidationTest() throws InterruptedException 
	{
	/*
	 * @param : Site URL Navigation
	 * URL is read from ProjectData.properties file in resources package
	 */
		System.out.println("Start Test");
		SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","TS01SiteURLNavigation"));
		SeleniumRepo.WaitForLoad(2000);
		
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","FirstName")))
		{
			SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","FirstName"));
			try {
				SeleniumRepo.PressTab();
				SeleniumRepo.WaitForLoad(1000);
				SeleniumRepo.PressShiftTab();
				SeleniumRepo.WaitForLoad(500);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				// Text Input Suggestion
				if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","FirstNameErr")))
				{
				SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","FirstNameErr"));
				
				String FirstNameSuggestion =SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","FirstNameErr"));
				System.out.println("FirstNameSuggestion = " + FirstNameSuggestion);		
				}
				else
				{
					System.out.println("Input Suggestion not found");
				}
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","FirstName"),"Som");
		System.out.println("First Name Textbox is found and First Name is Entered");
		}
		else
		{
			System.out.println("First Name Textbox not found");
			Assert.assertEquals("First Name TextBox","First Name TextBox Not found	","First Name TextBox Not found");
			
		}
		
		
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","LastName")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","LastName"));
		// Text Input Suggestion
			if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","LastNameErr")))
			{
			SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","LastNameErr"));
			String LastNameSuggestion = SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","LastNameErr"));
			System.out.println("LastNameSuggestion = " + LastNameSuggestion);		
			}
			else
			{
				System.out.println("Input Suggestion not found");
			}
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","LastName"),"Sah");
		System.out.println("Last Name Textbox is found and Last Name is Entered");
		}
		else
		{
			System.out.println("LastName Textbox not found");
		}
				
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Company")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Company"));
		try {
			SeleniumRepo.PressTab();
			SeleniumRepo.WaitForLoad(500);
			SeleniumRepo.PressShiftTab();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// Text Input Suggestion
			if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","CompanyNameErr")))
			{
			SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","CompanyNameErr"));
			String CompanyNameSuggestion = SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","CompanyNameErr"));
			System.out.println("CompanyNameSuggestion = " + CompanyNameSuggestion);	
					}
			else
			{
				System.out.println("Input Suggestion not found");
			}
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Company"),"Acc");
		System.out.println("Company Textbox is found and Company Name is Entered");
		}
		else
		{
			System.out.println("Company TextBox not found");
		}
	
		// Click and Enter the Job Title 						
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","JobTitle")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","JobTitle"));
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","JobTitle"),"Title Job");
		}
		else
		{
			System.out.println("Job Title TextBox not found");
		}
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","EmailID")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","EmailID"));
				try {
			SeleniumRepo.PressTab();
			SeleniumRepo.WaitForLoad(500);
			SeleniumRepo.PressShiftTab();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				// Text Input Suggestion
			if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","EmailErr")))
			{
			SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","EmailErr"));
			String EmailSuggestion = SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","EmailErr"));
			System.out.println("EmailSuggestion = " + EmailSuggestion);	
					}
			else
			{
				System.out.println("Input Suggestion not found");
			}
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","EmailID"),"tmail@gmail.com");
		System.out.println("Email Textbox is found and Email ID is Entered");
		}
		else
		{
			System.out.println("Email TextBox not found");
		}
		// Check if textbox is Present, Text Input Suggestion is available, click and Enter text
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Phone")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Phone"));
		SeleniumRepo.WaitForLoad(500);
		// Text Input Suggestion
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","PhoneErr")))
		{
		
		String PhoneSuggestion = SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","PhoneErr"));
		System.out.println("PhoneSuggestion = " + PhoneSuggestion);	
				}
		else
		{
			System.out.println("Input Suggestion not found");
		}
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Phone"),"12345678");
		System.out.println("Phone Number Textbox is found and Phone Number is Entered");
		}
		else
		{
			System.out.println("Phone TextBox not found");
		}
		// Click on the Dropdown and then select the value
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Country")))
		{
		
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Country"));
				try {
			SeleniumRepo.PressTab();
			SeleniumRepo.WaitForLoad(500);
			SeleniumRepo.PressShiftTab();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				// Selection Suggestion
			if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","CountryErr")))
			{
			SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","CountryErr"));
			String CountrySuggestion = SeleniumRepo.getElementText(PropertyFileRead.FileRead("ProjectData.properties","CountryErr"));
			System.out.println("CountrySuggestion = " + CountrySuggestion);	
					}
			else
			{
				System.out.println("Country Input Suggestion not found");
			}
		
		SeleniumRepoDropdown.selectDropDownValue(PropertyFileRead.FileRead("ProjectData.properties","Country"),"United States");
		System.out.println("Country dropdown is found and Country Name is Selected");
		try {
			SeleniumRepo.WaitForLoad(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Click on the Dropdown and then select the value
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","State")))
		{
		//SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","State"));
		SeleniumRepoDropdown.selectDropDownValue(PropertyFileRead.FileRead("ProjectData.properties","State"),"HI");
		System.out.println("State dropdown is found and State Name is selected");
		}
		else
		{
			System.out.println("State Dropdown not found");
		}
		}
		else
		{
			System.out.println("Country Dropdown not found");
		}
		SeleniumRepo.WaitForLoad(500);
		// Click on the Dropdown and then select the value
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","EmpSize")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","EmpSize"));
		SeleniumRepoDropdown.selectDropDownValue(PropertyFileRead.FileRead("ProjectData.properties","EmpSize"),"100-499");
		System.out.println("Emp Size dropdown is found and Emp size is selected");
		}
		else
		{
			System.out.println("Employee Dropdown not found");
		}
		SeleniumRepo.WaitForLoad(500);
		// Click on the Dropdown and then select the value
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Industry")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Industry"));
		SeleniumRepoDropdown.selectDropDownValue(PropertyFileRead.FileRead("ProjectData.properties","Industry"),"Technology - Aerospace, Biotech, R&D");
		System.out.println("Industry dropdown is found and Industry is selected");
		}
		else
		{
			System.out.println("Industry Dropdown not found");
		}
		// Check the Checkbox
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Checkbox")))
		{
		SeleniumRepoCheckBox.CheckCheckBox(PropertyFileRead.FileRead("ProjectData.properties","Checkbox"), "Reseller");
		System.out.println("Reseller checkbox is found and checked");
		}
		else
		{
			System.out.println("CheckBox not found");
		}
			// Insert the comments
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","Comments")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","Comments"));
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","Comments"),"NewComments");
		System.out.println("comments textarea is found and comments are entered");
		
		}
		else
		{
			System.out.println("Comments text Area not found");
		}
		
		//Click on the submit button
		if(SeleniumRepo.isElementPresent(PropertyFileRead.FileRead("ProjectData.properties","GetStartedButton")))
		{
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","GetStartedButton"));
		System.out.println("Get started button is found and clicked");
		}
		else
		{
			System.out.println("GetStartedButton not found");
		}
		SeleniumRepo.WaitForLoad(4000);
	}
	
	
	

}
