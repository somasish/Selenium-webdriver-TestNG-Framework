package com.abc.util;

import com.mercury.qualitycenter.otaclient.ClassFactory;
import com.mercury.qualitycenter.otaclient.IBaseFactory;
import com.mercury.qualitycenter.otaclient.IList;
import com.mercury.qualitycenter.otaclient.IRun;
import com.mercury.qualitycenter.otaclient.IRunFactory;
import com.mercury.qualitycenter.otaclient.ITDConnection;
import com.mercury.qualitycenter.otaclient.ITSTest;
import com.mercury.qualitycenter.otaclient.ITestSet;
import com.mercury.qualitycenter.otaclient.ITestSetFolder;
import com.mercury.qualitycenter.otaclient.ITestSetTreeManager;

import com4j.Com4jObject;

/**
 * 
 *
 * QC Integration require com4j.jar, Selenium-server-standalone.jar and otiClient.jar
 *
 */
public class QcIntegration {
   
	 public static void sendRequest(String strTestCaseId, String strStatus) {

	        ITDConnection connection=null;
	        
	        //QC url
	        String url = "http://<QCURL>/qcbin";
	        //username for login
	        String username = "<QC USERNAME>";
	        //password for login
	        String password = "<QC PASSWORD";
	        //domain
	        String domain = "TRAINING";
	        
	        //project
	        String project = "<ProjectName>";
	        String strTestLabPath  = "<Root\\TestLabFolderName>";
	        String strTestSetName = "<TestSetName>";
	        
	       
	           
	            //QC Connection
	        connection = ClassFactory.createTDConnection();
	        	   connection.initConnectionEx(url);
	        	   connection.connectProjectEx(domain, project, username, password);
            
	            //To get the Test Set folder in Test Lab        
	            ITestSetTreeManager objTestSetTreeManager = (connection.testSetTreeManager()).queryInterface(ITestSetTreeManager.class);
	            ITestSetFolder objTestSetFolder =(objTestSetTreeManager.nodeByPath(strTestLabPath)).queryInterface(ITestSetFolder.class);
	                    
	            IList tsTestList = objTestSetFolder.findTestSets(null, true, null);
	                    
	            for (int i=1;i<=tsTestList.count();i++) {
	                Com4jObject comObj = (Com4jObject) tsTestList.item(i);
	                ITestSet tst = comObj.queryInterface(ITestSet.class); 
	                        
	                if(tst.name().equalsIgnoreCase(strTestSetName)){
	                            
	                    IBaseFactory testFactory = tst.tsTestFactory().queryInterface(IBaseFactory.class);
	              
	                    IList testInstances = testFactory.newList("");
	                                
	                    //To get Test Case ID instances
	                    for (Com4jObject testInstanceObj : testInstances){  
	                        ITSTest testInstance = testInstanceObj.queryInterface(ITSTest.class);  
	                                    
	                        if(testInstance.testName().equalsIgnoreCase(strTestCaseId)){
	                            IRunFactory runfactory = testInstance.runFactory().queryInterface(IRunFactory.class);
	                        
	                            IRun run= runfactory.addItem("Selenium").queryInterface(IRun.class);
	                            run.status(strStatus);
	                            run.post();
	                            break;
	                        }
	                    } 
	                }
	            }
	       
	    }
}