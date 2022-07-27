Coverage: 83.9%

# QA-Hobby-Project
Week 10 (Week 8) Project

This project is for storing data for a bicycle event, It will be able to create, add, update, and delete riders from a database using a front-end web page. You will be able to either see all riders or search by team name.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Pre-requisits:
Java https://www.java.com/download/ie_manual.jsp
Eclipse IDE from https://www.eclipse.org/downloads/
MySQL and Workbench from https://www.mysql.com/products/workbench/
SpringBoot from https://spring.io/tools
Apache https://maven.apache.org/
Dependencies for POM.XML from https://mvnrepository.com/
Git https://git-scm.com/downloads and GitHub https://github.com/
JIRA https://www.atlassian.com/software/jira

### Installing

To install this you will need to clone it down from the repo then import the back end into Eclipse

The front end can be opened in Visual Studio and opened via the live server plugin to use in your browser on the localhost.

Once imported into Eclipse Run the poject as a springboot project, the file is set to create a schema and table in SQL but once created the "create" on line 5 of application-prod.properties can be changed to "validate".

Connect the MySQL localinstance by going to "connect database".

As long as the dbproperties file has the correct address (in this case as it is ran locally it will be a localhost address), the correct username for MySQL, and the correct password, then the Runner class should work.

After entering data in the fields and hitting submite you will see something similar:

![image](https://user-images.githubusercontent.com/30010257/181365346-586866e1-d67d-4d97-938d-4975d983d872.png)

You can also go to SQL workbench and check the data is correct in there by doing a SELECT statement:

![image](https://user-images.githubusercontent.com/30010257/181365571-8b7c7eec-8a03-4fee-ab11-f9553565055e.png)

## Running the tests

Tests are done with JUnit for coverage and unit testing. These can be run by running the project as "JUnit"

### Unit Tests 

A JUnit test is where the system goes through the code with an expected result you have given and checks to see that it runs and outputs the expected result, this can be done using another class set up with an @Test annotation. There is a test for each of the CRUD functionality methods which have passed:

![image](https://user-images.githubusercontent.com/30010257/181366121-be9ec41a-7fe4-4788-8dae-da23298cd50a.png)

### Integration Tests 

Integration tests are done in this system using Mockito. I have not been able to complete testing with Mockito at this time. This will be revisted at a later date and a branch has been created to do this on.

## Deployment

This can be deployed using Maven and SpringBoot.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://spring.io/tools) - Application framework and inversion-of-control container

## Versioning

We use Git and GitHub (http://github.com/) for versioning.

## Authors
* **Devin Patel** - *Project work from initial created by Chirs Perrins* - [D-Pats](https://github.com/D-Pats)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thanks to Jordan Harrison (https://github.com/JHarry444) for teaching Spring and Javascript
