package com.abc.projectpage;

import java.net.UnknownHostException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.abc.seleniumrepository.SeleniumRepo;
import com.abc.util.PropertyFileRead;

public class TestngAnnotations {
	@BeforeMethod(alwaysRun = true)
	public void Beforem()
	{
	/*
	 * @param 1: Browser name -firefox or internetExplorer or chrome
	 *  Below firefox string is being read from the ProjectData.property file in resources package
	 *  
	 *  @param 2: Browser Proxy Yes or No. If yes then port and Host details are read from the Property file
	 */
		System.out.println("TestCase Starts");
		try {
			SeleniumRepo.startBrowser(PropertyFileRead.FileRead("ProjectData.properties","BrowserType"), false);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumRepo.driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void AfterTest() throws UnknownHostException
	{
	System.out.println("TestCase Ends");
		SeleniumRepo.driver.quit();
		
	}
}
