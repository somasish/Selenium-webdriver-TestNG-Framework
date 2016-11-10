# Selenium-TestNG-Framework

#Install

Clone and import the project as existing Maven project.

# Introduction
Selenium TestNG Framework (Maven Project)

This is a page object model framework. Below are the features that are incorporated and their status.

1) Page Modeling Example with Scripts of Google.com and yahoo.co.in

2) Data are read from Oracle Database. 

        i)Database Connection
    
        ii)Oracle DB Read
    
        iii) Oracle DB Write

3) Read and Write from Excel File

4) Read data from Property file

5) Selenium Repository which contains all possible permutation and  combination of actions,events and etc that can be performed in a web page

6) Browser invocation (Chrome, IE and Firefox)

7) Firefox Proxy Settings

8) XML File Generation Example TestNG.XML

9) Web Services Testing Like Soap and Rest- Yet to Start

10)TestNG Listener Implementation

11)TestNG Reporter Implementataion 

12) HTML End Report Generation- Yet to Start

13) Bug Tracking Tool integration - Yet to Start
        
        i) QC  
        
        ii) Bugzilla
        
        iii) Rally
        
        iv) Jira

14) Email Connection - Completed and Committed

15) Folder Creation with Time Stamp - Completed and Committed

16) TestNG Assertion - Yet to Start

17) TestNg Annotations and DataProvider 

18) Selenium Grid Implementation- Yet to Start

19) Reading a Response XML- Yet to Start

20) Image Comparision - Completed and Committed

21) Firefox geckodriver included

#How to use

Understanding Various Packages included and its use

1) database package (com.abc.database)

        it have a code for retriving single and multiple rows from the database. Database connection details are taken from the property file (DBDetails.property). Passing proper value from property file will automatically connect to the db and return you the result set in proper manner. If your requirement is of a singleton class. Please open a case so that i can assist you accordingly
        
2) listener package ( com.abc.listener) TestNG Listner

        Use of this package is to listen any operation/event that happened during any execution. for this TestNG listner methods like onstart,onfinish,ontestpassed, onTestskipped etc are overwritten. Listener and Reporter has to be implement jointly and in a planned manner as per the requirement. So few sample features are implemented in this project. Please open a case if you require more assistance in Listener and Reporter package/functionality.
   
3) Reporter Package (com.abc.report) TestNg Reporter

        Use this package for custom reporting as per your organisation. This has to be in collabration with the Listner package. Generally all listner methods logs data as per their listened activity which is picked by the reporter at the end to prepare a consoldated report in some format like HTML, PDF. Some sample commented code are available for reference or use. Please open a case for further assistance
 
4) Page Object Package (com.abc.projectpage)

        This package is used for modelling of page objects. various page objects are stored as By class objects which will be used by testscripts and page wise reuseable code. Sample code for Google and Yahoo has been done.
       
       [Note] - Inplace of locators being stored as By Class object i have stored them as string in format "LocatorType==Locator". Example "xpath==.//*[@id='gb_70']" or "id==lst-ib" . Here locator type is id and Locator is lst-ib. 
        benefit of this method is that we can store the locator in other places also in same format as string or key-value pair. So to accomodate this change. code just before the findelement method(selenium method which identify the object in the page) has a string split using "==" and pass then pass the locator to it. you can return back to the page object by using BY object method and little modification of findelement method in seleniumrepo package.
        
5) Selenium Repository Package (com.abc.seleniumrepository)
        
        In this package all the permutation and combination of thing that can be done over a webpage has been build as methods so that they can be used by testscript and no need to write the selenium code each and everytime during the scripting. it almost reduce the scripts lines of code to one-fifth or more.
        Example if you want to click any object over the webpage just pass the locator to click method. or if you want to write something to a textbox then pass the locator and the string to enterText method.
        
        Request you to go through the method as it will give you understanding of how things are working
  
6) Utility Package (com.abc.util)
        
        In this package all the external usable jars and related functionality codes are available to be used in various type of scripting. Present package have functionality like CSV file read, Email Report, Image comparision, Property file read, Taking Screenshot and Read write Excel File.
    
7) Web Service Package (com.abc.webservice)
        
        This Package deal with functionality of webservices. This package should include xml Generation, xml read. Json Parse, Json Generation other file read write. Also various types of connection like ftp connection code can be included in this package. I have only included a XML file generation code. The code will generate you a Testng.xml file.

8) TestScript Package(com.abc.testscript)
          
        Understand the code of a sample testscript
     Each java file in this package have lot many method and each methods are indivisual testscript. Along with the Testscript we have 2 more methods i.e beforemethod and aftermethod which help us in starting and closing browser for each test. you can distiguish a testscript with these two methods by marking the annotaion @test just above a method.
     Now coming to the testscript. For example we have a script which will open a browser will navigate to a specific url, click on some button and enter some text. So my testscript code will contain 3-4 lines of code only. 1st line will be calling seleniumrepo.GotoURL and pass the url as parameter and As the url is present in the propertyfile so we will read through the property file and pass the one as parameter.Example SeleniumRepo.GoToUrl(PropertyFileRead.FileRead("ProjectData.properties","TS01SiteURLNavigation")); .
     our 2nd step is to click on a button so we will call the click method from seleniumrepo again and pass the locator as parameter. locator can be passed from property file or from the pageboject pages. Example SeleniumRepo.click(PropertyFileRead.FileRead("ProjectData.properties","FirstNameErr"));
     Final step will be enter something on the textbox so we will call entertext method from the seleniumrepo and pass the locator and the text to be entered as parameter.
     various kind of validation/assertion can be done by looking into the return type of these seleniumrepo methods. Please go through the sample testscript to understand further.
  
9) propertyfile

        Here we keep all our property files and other excel files for read. Property file are maintained in a key-value pair. We have data like db detail, browsertype and other that are to be used by the scripts.
        
        
 
