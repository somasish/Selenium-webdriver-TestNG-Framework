package com.abc.util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.IOException; 

public class Screenshot {

	WebDriver driver = SeleniumRepo.getWebDriver();
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	//	FileUtils.copyFile(scrFile, new File("C:\\failure.png"));
}
