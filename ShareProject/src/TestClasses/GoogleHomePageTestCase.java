package TestClasses;
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
		
	}
	
	

}
