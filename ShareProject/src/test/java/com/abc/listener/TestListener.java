package com.abc.listener;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.abc.util.PropertyFileRead;

public class TestListener extends TestListenerAdapter{

	PropertyFileRead PropertyFileRead = new PropertyFileRead();

	/*************************************************************
	 * @author :Somasish
	 * @Method_Name: TestListener
	 * @Description : Constructor Calling Parent Class Constructor
	 ************************************************************/
public TestListener()
{
super();	
}


/*************************************************************
 * @author :Somasish
 * @Method_Name: onStart
 * @Description : Overriding the onStart Method for Loading the Property files and Database connection
 ************************************************************/

@Override
		public void onStart(ITestContext testContext) {
	System.out.println("Execution Starts");
	//Load the Property files
	String DBUserName = PropertyFileRead.FileRead("DBDetail.properties","DatabaseUsername");
	String DBPassword = PropertyFileRead.FileRead("DBDetail.properties","DatabasePassword");
	
	
}


/*************************************************************
 * @author :Somasish
 * @Method_Name: onFinish
 * @Description : Overriding the onFinish Method for closing any browser instance and connection objects
 ************************************************************/

@Override
		public void onFinish(ITestContext testContext) {
	System.out.println("Execution Completed");
	//Load the Property files
	// Ensure all browser instance are closed
	// Ensure you disconnected from the all open connection object
	
	
}
}
