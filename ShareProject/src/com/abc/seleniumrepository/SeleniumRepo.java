package com.abc.seleniumrepository;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.abc.util.PropertyFileRead;


public class SeleniumRepo {
	public static WebElement webelement;
	public static List<WebElement> webelements = null;
	public static WebDriver driver = null;
	public static int defaultBrowserTimeOut = 30;
	public static List<String> windowHandlers;
	
	/**
	 * @author somasish
	 * @param browser name
	 * @param url
	 * @return driver of the browser invoked
	 * @throws UnknownHostException
	 */
	
public static WebDriver startBrowser(String browserName, String url, boolean FirefoxBrowserProxy)
			throws UnknownHostException {
	
		deleteTempFile();

		if (browserName.equalsIgnoreCase("firefox")) {
			
			if(FirefoxBrowserProxy)
			{
		driver = proxySetting(); 
				
			}
			else
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("iexplorer")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capabilities.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(capabilities);
		} else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		driver.manage().timeouts()
				.implicitlyWait(defaultBrowserTimeOut, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		// driver.switchTo().alert().dismiss();
		if (browserName.equalsIgnoreCase("iexplorer"))
			SeleniumRepo.SwitchAlert();

		if (windowHandlers == null)
			windowHandlers = new LinkedList<String>();
		else
			windowHandlers.clear();

		windowHandlers.add(driver.getWindowHandle());
		
		return driver;
	
	}

/**
 * @author somasish
 * @return Driver Set with Proxy Setting
 */

public static WebDriver proxySetting()
{
	String serverIP=PropertyFileRead.FileRead("DBDetails.properties","proxyHort"); 
	String port= PropertyFileRead.FileRead("DBDetails.properties","proxyPort");
	WebDriver newDriver;
	FirefoxProfile profile = new FirefoxProfile();  
profile.setPreference("network.proxy.type",1);  
profile.setPreference("network.proxy.ftp",serverIP);  
profile.setPreference("network.proxy.http",serverIP);  
profile.setPreference("network.proxy.socks",serverIP);  
profile.setPreference("network.proxy.ssl",serverIP);  
profile.setPreference("network.proxy.ftp_port",port);  
profile.setPreference("network.proxy.http_port",port);  
profile.setPreference("network.proxy.socks_port",port);  
profile.setPreference("network.proxy.ssl_port",port);  
newDriver = new FirefoxDriver(profile);

return newDriver;
	}



	/**
	 * @author somasish
	 * @return Boolean value for Switch Alert
	 */
public static boolean SwitchAlert() {
	boolean Flag = false;

	try {
		if (driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
			Flag = true;
		}

	}

	catch (NoAlertPresentException e) {
		
	}
	return Flag;

}
	/**
	 * @author somasish
	 * 
	 */
	public static void closeBrowser() {

		if (driver != null)
			driver.close();
		// driver = null;
		// WindowsUtils.tryToKillByName("IEDriverServer.exe");
		/* taskkill /F /IM IEDriverServer.exe - From Command Prompt */
	}

	/**
	 * @author somasish
	 */
	public static void shutDownDriver() {
		if (driver != null)
			driver.quit();
	}
	
	/**
	 * @author somasish
	 * @return	current Driver instance
	 */
	public static WebDriver getWebDriver() {
		return driver;
	}
	
	/**
	 * @author somsahoo
	 * @throws UnknownHostException
	 */
	public static void deleteTempFile() throws UnknownHostException {
		String property = "java.io.tmpdir";
		String temp = System.getProperty(property);
		File directory = new File(temp);
		try {
			delete(directory);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * @author somasish
	 * @param file- Directory and Sub directory to be deleted
	 * @throws IOException
	 */
	public static void delete(File file) throws IOException {
		if (file.isDirectory()) { // directory is empty, then delete it
			if (file.list().length == 0) {
				file.delete();
			} else {
				// list all the directory contents
				String files[] = file.list();
				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);
					// recursive delete
					delete(fileDelete);
				}
				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : "
							+ file.getAbsolutePath());
				}
			}
		} else {
			// if file, then delete it
			file.delete();
		}
	}

	/**
	 * @author somasish
	 * @param locator in particular format mentioned
	 * @return WebElement
	 */
	public static WebElement findElement(String locator) {

		//Locator Values are Expected in string format like "name==abc" or "id==pqr" or "xpath==//*[@id='uname']"
		
		if (locator != null) {
			String[] arrLocator = locator.split("==");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();
			try {
				if (locatorTag.equalsIgnoreCase("id")) {
					webelement = driver.findElement(By.id(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("name")) {
					webelement = driver.findElement(By.name(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("xpath")) {
					webelement = driver.findElement(By.xpath(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("linkText")) {
					webelement = driver.findElement(By.linkText(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("class")) {
					webelement = driver
							.findElement(By.className(objectLocator));
					highlightElement(driver, webelement);
				} else if (locatorTag.equalsIgnoreCase("css")) {
					webelement = driver.findElement(By
							.cssSelector(objectLocator));
					highlightElement(driver, webelement);
				} else {
					String error = "Please Check the Given Locator Syntax :"
							+ locator;
					error = error.replaceAll("'", "\"");
				
					return null;
				}
			} catch (Exception exception) {
				String error = "Please Check the Given Locator Syntax :"
						+ locator;
				error = error.replaceAll("'", "\"");
								exception.printStackTrace();
				return null;
			}
		}
		return webelement;
	}

	/**
	 * @author somasish
	 * @param driver
	 * @param element
	 */
	public static void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
				element, "border: 2px solid DeepPink;");
	}


/**
 * @author somasish
 * @param Web element
 */
	public static void doubleClick(WebElement element) {
		if ((driver != null) && (element != null))
			(new Actions(driver)).doubleClick(element).build().perform();
	}


/**
 * @author somasish
 * @param locator
 * @return True or False whether the Element Present or not
 */
	public static boolean isElementPresent(String locator) {
		List<WebElement> arrElements = null;
		arrElements = SeleniumRepo.findElements(locator);
		if (arrElements.size() > 0 && arrElements != null) {
			System.out.println("Element found");
			return true;
		}
		else
			System.out.println("Element not found");
		

		return false;
	}

	/**
	 * @author somasish
	 * * @param locator
	 * @return list of webelement found
	 */
	public static List<WebElement> findElements(String locator) {

		if (locator != null) {
			String[] arrLocator = locator.split("==");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();

			if (locatorTag.equalsIgnoreCase("id")) {
				webelements = driver.findElements(By.id(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("name")) {
				webelements = driver.findElements(By.name(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("xpath")) {
				webelements = driver.findElements(By.xpath(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("linkText")) {
				webelements = driver.findElements(By.linkText(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("class")) {
				webelements = driver.findElements(By.className(objectLocator));
			} else {
				System.out.println("Please Check the Locator Syntax Given :"
						+ locator);
				return null;
			}
		}
		return webelements;
	}

	/**
	 * @author somasish
	 * @param propertyType
	 * @param propertyValue
	 */
	public void mousehovering(String locator) {
		
		WebElement mouseOverElement = findElement(locator);
		Actions builder = new Actions(driver);  // Configure the Action    
		 Action mouseOver =builder.moveToElement(mouseOverElement).build(); // Get the action    
		 mouseOver.perform(); // Execute the Action 
	}
/**
 * @author somasish
 * @param locator of the Web Element
 * @param attributeName
 * @return attributeValue
 */
	public static String getAttribute(String locator, String attributeName) {
		String attributeValue = null;
		try {

			WebElement element = SeleniumRepo.findElement(locator);
			if (element != null)
				attributeValue = element.getAttribute(attributeName);
			element = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return attributeValue;
	}
	
	/**
	 * @author somasish
	 * @param locator of the Element to be cleared
	 */
	public static void clearElement(String locator) {
			try {

			WebElement element = SeleniumRepo.findElement(locator);
			 element.clear();
			 element = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	/**
	 * @author somasish
	 * @param locator
	 * @param value
	 */
	public static void enterText(String locator, String value) {

		try {

			WebElement element = SeleniumRepo.findElement(locator);
			element.sendKeys(value);
			element = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author somasish
	 * @param locator of Element to be clicked
	 */
	public static void click(String locator) {
		try {
			WebElement element = SeleniumRepo.findElement(locator);
			if (element != null)
				element.click();
			else
				System.out.println("Element Is NULL");
			element = null;		

		} catch (Exception e) {
			System.out.println(" Error occured whlie click on the element "
					+ locator + " *** " + e.getMessage());
			
		}
		
	}
	
	/**
	 * @author somasish
	 * @param locator
	 * @return Text/value of the Element
	 */
	public static String getElementText(String locator) {
		WebElement element;
		String text = null;
		try {
			element = SeleniumRepo.findElement(locator);
			if (element != null)
				
				text = element.getText();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		element = null;

		return text;
	}
	
	
}
