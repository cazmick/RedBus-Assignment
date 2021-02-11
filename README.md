#DESCRIPTION:
Implementation of Automation on the __https://www.redbus.in/__ webpage.

#REQUIREMENTS:
* JDK 1.8
* JVM >11.0.1
* Browser:Chrome, Firefox or IE
* Any Java IDE
* Maven

#SPECIFIC GUIDE:
* By defualt browser is set to be chrome it can be updated through updation in configuration file browser value.
* Support for only Chrome, Firefox and IE browser, Keep in mind IE doesn't have support for Headless option.
* By default browser are set to be in Headless mode, It can also work in normal browser after updation or removal of browserType in configuration file.
* While Execution please verify that the DataSet.xlsx file should have Execution set to yes for the operations it is getting executed.

#STRUCTURE:
## in.RedBus
##	..src/main/java
###		in.RedBus.Base
*			- This package consist of two java files Driver.java and PageObject.java, Driver.java provides the initiate to Driver and resposnible for all the Managibility 
			  of Driver on the other hand PageObject.java consist of alll the logical operation required for any specific logical approach and provide that constructor so
			  that all the Synchronus file can utilize it.
###		in.RedBus.Locators
*			- This package consist of files in which Locators are defined in their respective approach Class and Utilizing the PageObject to perform the Actions, Other than
			  than action is defined on the driver according to their Requirements.
###		in.Redbus.Utils
*			- This package consist of all the File Handling operations and responsible for providing all the data form Source and Conditional approach that is linked with 
			  the Source data.
##	..src/main/resources
*			- The above Repository consist of all the Resources Utilized by the main repository files
##	..src/test/java
###		TestAction
*			- This package holds all Test java files and can be exutable using the TestNG.
			  This package is responsible for execution of Test Cases.
##	..src/test/resources
*			- The above repository consist of all the Resources utilized by the test/java files.
##	..Resources
*			- Consist of all the logger operation that is being cached in the Test files.










