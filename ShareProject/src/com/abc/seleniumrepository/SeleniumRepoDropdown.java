package com.abc.seleniumrepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SeleniumRepoDropdown {

	
	/**
	 * @author somasish
	 * @param locator
	 * @param value
	 * Method to Select a value from a dropdown
	 */
	public static boolean selectDropDrownValue(String locator, String value) {
		try {
			WebElement element = SeleniumRepo.findElement(locator);

			if (element != null) {
				Select selectBox = new Select(element);
				selectBox.selectByVisibleText(value);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
	/**
	 * @author somasish
	 * @param field
	 * Return a ArrayList which contains all the Values within a Dropdown
	 */
	public static ArrayList<String> getAllDropDownValue(String field) {

		ArrayList<String> ListofDropdownValues = new ArrayList<>();	
		String value = null;
		try {

			WebElement select = SeleniumRepo.findElement(field);
			List<WebElement> variousOptions = select.findElements(By
					.tagName("option"));

			for (WebElement option : variousOptions) {
				
				ListofDropdownValues.add(option.getText());
				
				//value = value + "," + option.getText();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListofDropdownValues;
	}
	
	
	public static boolean selectDropDrownByIndex(String locator, int Index) {
		try {

			if (locator != null) {
			
				WebElement DropdownElement = SeleniumRepo.findElement(locator);
				Select SelectIndex = new Select(DropdownElement);
				SelectIndex.selectByIndex(Index);
			}
			return false;
		} catch (Exception e) {
			System.out
					.println(" Error occured while selecting the option in the select box *"
							+ locator + " ***" + e.getMessage());
			return false;
		}
	}
}
