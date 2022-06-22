# BDD_Cucumber_RestAssured
This project is a POC for calling API request using the Rest Assured and BDD Cucumber framework.
Used Gherkin syntax for the feature file by downloading the Natural plugin.
Impelmented a single value and multi value scenario through data driven by providing it as Examples.
Validation checks are done for the retrieved response body using JUnit.
API Requests used to perform action in the project are POST, GET, DELTETE and UPDATE.
Implemented Serialization and Deserialization concept for the POJO classes in the TestDataBuild class.
Implemented the builder pattern using the Request Spec Builder for both Request and the Response.
Explicilty loading the baseUrl from properties file through FileInputStream.
Explicitly sending all the data to logging.txt file for all the API request called by the user. logging.txt consists of both the Request and Response body for the particular called API.
Used Enum class to retrieve the API resource for the called APIs. 
Ran the prject through the TestRunner class.
