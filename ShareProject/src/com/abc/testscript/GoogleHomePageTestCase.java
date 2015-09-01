package com.abc.testscript;
import java.net.UnknownHostException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.util.PropertyFileRead;

public class GoogleHomePageTestCase {
	
	
	@BeforeTest
	public void BeforeTest() throws UnknownHostException
	{
		SeleniumRepo.startBrowser(PropertyFileRead.FileRead("ProjectData.properties","BrowserType"), false);
	}
	
	@Test
	public void SearchTest()
	{
		SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","GoogleSiteURL"));
		//Click on the search Box
		SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","SearchBox"));
		//Enter Text to the search Box
		SeleniumRepo.enterText(PropertyFileRead.FileRead("ProjectData.properties","SearchBox"),"Selenium Webdriver");
	}
	
	

}
