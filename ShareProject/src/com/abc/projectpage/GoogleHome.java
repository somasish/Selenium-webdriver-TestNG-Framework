package com.abc.projectpage;
/**
 * 
 * @author somasish
 *This class is for Showing a Page object modeling and Not for Testing
 */
public class GoogleHome {
	private static String SearchBox = "id==lst-ib";
	private static String SigninButton = "xpath==.//*[@id='gb_70']";
	
	
	public static String getSearchBox() {
		return SearchBox;
	}
	
	public static String getSigninButton() {
		return SigninButton;
	}
}
