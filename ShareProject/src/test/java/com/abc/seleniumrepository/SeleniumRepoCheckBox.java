package com.abc.seleniumrepository;

import java.util.List;

import org.openqa.selenium.WebElement;



public class SeleniumRepoCheckBox {

	/**
	 * @author somasish
	 * @param locator
	 * desc Whether the checkbox is checked or not 
	 */
	public static boolean isCheckboxChecked(String locator) {
		WebElement element = SeleniumRepo.findElement(locator);
		if (element.isSelected())
			return true;
		else
			return false;
	}

	/**
	 * @author somasish
	 * @param locator
	 * desc Check a Checkbox having a particular value as its attribute 
	 */
	public static void CheckCheckBox(String Locator, String Value)
	{
		 List<WebElement> oCheckBox = SeleniumRepo.findElements(Locator);
				 
		 
			// This will tell you the number of checkboxes are present

int iSize = oCheckBox.size();

			// Start the loop from first checkbox to last checkbox

for(int i=0; i < iSize ; i++ ){

			// Store the checkbox name to the string variable, using 'Value' attribute

String sValue = oCheckBox.get(i).getAttribute("value");

				// Select the checkbox it the value of the checkbox is same what you are looking for

if (sValue.equalsIgnoreCase(Value))
	{

  oCheckBox.get(i).click();

  // This will take the execution out of for loop

  break;

  }

}
	}
	
}
