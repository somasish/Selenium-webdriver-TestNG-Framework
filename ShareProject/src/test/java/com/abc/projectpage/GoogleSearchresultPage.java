package com.abc.projectpage;

public class GoogleSearchresultPage {
	private static String SearchResultDiv = "xpath==.//*[@id='rso']";
	private static String ImageBox = "xpath==.//*[@id='imagebox_bigimages']";
	public static String getSearchResultDiv() {
		return SearchResultDiv;
	}
	public static String getImageBox() {
		return ImageBox;
	}
}
