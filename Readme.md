## Exit Test - Red Bus

#[Github Repository Link](https://github.com/jkapoor24/Redbus_ExitAssignment.git)

## `https://github.com/jkapoor24/Redbus_ExitAssignment.git`


** How to create Maven Project **
* Open File
* Go to New
* Click on Other
* Type Maven Project then Next and again Next
* Now Select Artifact Id with the name maven-archetype-quickstart  1.1
* Now Write Group Id and Artifact Id and Click finish

** How to run Maven Project normally **

**Method 1 :- Using Maven Project**


* Right click on Project Name
* Go to Run As
* Click on Maven Clean
* Then Click on Maven Install


**Method 2 :- Using TestNG file**


* Open testNG.xml file
* Right click on file
* Go to Run As
* Select Test Suite


**Method 3 :- Using Batch file**


* Go to project location
* Now double click on run.bat file


**Method 4 :- Using Jenkins**


* Instructions related to installation and configuration is attached in WORD file.
* After installation and configuration. To run test suite in Jenkins follow below steps -
* First redirect to localhost with port number selected during installation - `http://localhost:8443/`
* Now in Dashboard - Select New Item
* Enter an item name
* After entering Select Maven Project
* Now configure maven project in GENERAL
* Check Github Project option in Maven Info Plugin Configuration
* Now Enter Github URL
* Now in Source Code Management - Select GIT
* Enter Repository URL mentioned at top of ReadMe
* Now in BUILD in Goals and options - Enter command - `clean install`
* Finally apply and save
* Now just go to dashboard select that same project and Click on Build now.


** How to run Maven Project in Parallel using Docker **


**Method 1 :- Using Batch file**


* Go to project location
* Now double click on start-dockergrid.bat file
* Now open testNG.xml file and add one argument in this `<suite name="Suite">` i.e., `parallel="classes"`

_Like this - <suite name="Suite" parallel="classes">_

* Now open `config.properties` file in Resources folder and change variable named `parallel` to `true` and also select browser name by changing value of `browserName` variable to whether `chrome`, `gecko` and `edge`.

* Now after execution again navigate to project location and double click on stop-dockergrid.bat file


### Drivers

**Includes Drivers For Different Browsers**
* chromedriver.exe - For Chrome Browser
* geckodriver.exe - For Firefox Browser
* msedgedriver.exe - For MS Edge Browser

### Packages

** 1. Pages - Includes Java Files **

* LoginPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button. 


* BusHirePage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


* DonatePage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


* FooterPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.
 
 
* HelpPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


* HomePage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


* RPoolPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


* SearchBusPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


* SitemapPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


* TopOperatorPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.


** 2. Utils - Includes Java Files ** 

* ReadExcel.java File - This file contains method which fetches Test Data from Excel Sheets.

* ReusableMethods.java - This file contains methods for switching to window handles and closing existing handles.

* ScreenShots.java File - This file contains method which takes Screenshot.


** 3. Tests - Includes Java Files ** 

**BaseTest.java File** - This file includes main methods to run our project and also defines when to run individual method by using testNG annotations. 


* Includes methods --
1. setExtent - This method sets the Extent Report
2. endReport - This method ends the Extent Report
3. intializeWebdriver - This method initialize the web driver
4. attachScreenshot - This method attach the failing screenshots
5. openBrowser - This method opens the browser
6. closeBrowser - This method close the browser


**LoginTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. validLogin - To verify login page with valid details
2. invalidPassword - To verify with invalid password
3. invalidEmail - To verify with invalid email address


**BusHireTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. busHireOutstation - To verify Bus hire page for Outstation journey type
2. busHireLocal - To verify Bus hire page for Local journey type
3. busHireAirport - To verify Bus hire page for Airport journey type


**DonateTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. redCareDonate - To verify redbus care donation page


**FooterTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. searchBlog - To verify Blog page by reading and searching blog
2. careers - To verify careers page by applying for a job in naukri website
3. contactUs - To verify contact us page


**HelpTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. helpChatBot - To verify Help chatbot page


**HomePageTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. invalidManageBooking - To verify show my ticket in manage booking by passing invalid details
2. smsAppLink - To verify SMS App link for redbus app
3. navigateToCountry - To verify by navigating to other country page


**RPoolTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. rPoolYoutube - To verify RPool page by playing youtube video


**SearchBusTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. validSearchBus - To verify search bus page by passing valid details
2. toggleSearchBus - To verify toggle button by passing valid search bus details
3. invalidSearchBus - To verify search bus page by passing invalid details


**SitemapTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. bookBus_RTCOperator - To verify sitemap link by booking bus with RTC operators
2. bookPilgrimagePackage - To verify sitemap link by booking pilgrimage package


**TopOperatorTest.java File** - This file includes methods for Data Providers and different test scenarios -- 


1. topOperator - To verify Top operator page by searching bus


** 4. Base - Includes Java Files ** 

* DockerRemoteDriver.java File - This file includes method to initialize and return remote webdriver container for docker for running test cases in parallel

** 5. src/main/resources **
* Includes `log4j.properties` - This file includes all the configuration details for logging


### Other Folders

** 1. FailedScreenshots **
* Includes Screenshots of `FAILED` Test cases
 
     
** 2. Reports **
* Includes Extent Report which contain whole Report in HTML format of each Test Scenario


** 3. Resources **
* Includes `config.properties` file which contains configuration data like url, browserName, implicitWaitTimeout, headless.

*NOTE - End User needs to change this data at Run time for changing functionalities like Browser Name and Whether run in headless mode or not or whether run in parallel/remote mode or not.*
*For Changing browser End User can change the name of browser like for chrome it is "chrome" in small case, for firefox it is "gecko" in small case and for microsoft edge it is "edge" in small case*
*For Changing Headless mode End User can change the headless option to "false" if user doesn't want to run in headless mode and change to "true" if wants to run in headless mode*
*Similarly for Changing Remote/Parallel mode End User can change the remote option to "false" if user doesn't want to run in parallel mode and change to "true" if wants to run in parallel mode using docker*


** 4. TestDataExcel**
* Includes TestData.xlsx file which contains all the sheets(i.e., Test Data) in the same workbook for all test scenarios

*NOTE - User can change the data any time by accessing this file*
*There is an option called "Execution Required", user can turn it to yes or no according to his/her choice of running that individual test case* 


### Other Files

** POM.xml **
* This file is auto generated file which includes all the dependencies, plugins.

** TestNG.xml **
* This file includes how to run Project using testNG and it contains suits, test, groups, classes. We can also pass parameters using testNG.

**docker-compose.yaml**
* This file is used for defining and running multi-container Docker applications. We use YAML file to configure our application's services. It is the simplest way to start a Grid.

* To execute this docker-compose yml file use `docker-compose up` in command prompt.

* To stop the execution of docker-compose yml file use `docker-compose down` in other command prompt.

** run.bat **
* Using this file user can directly run entire test suite by just double clicking.

** start-dockergrid.bat **
* This file is used to execute the test suite in parallel by using docker by just double clicking.

** stop-dockergrid.bat **
* This file is used to stop the execution of the test suite in parallel by using docker by just double clicking.