# BDD_Cucumber_RestAssured

**This project is a POC for calling API request using the Rest Assured and BDD Cucumber framework.**

1. Used Gherkin syntax for the feature file by downloading the Natural plugin.
2. Impelmented a single value and multi value scenario through data driven by providing it as Examples.
3. Validation checks are done for the retrieved response body using JUnit.
4. API Requests used to perform action in the project are POST, GET, DELTETE and UPDATE.
5. Implemented Serialization and Deserialization concept for the POJO classes in the TestDataBuild class.
6. Implemented the builder pattern using the Request Spec Builder for both Request and the Response.
7. Explicilty loading the baseUrl from properties file through FileInputStream.
8. Explicitly sending all the data to logging.txt file for all the API request called by the user. logging.txt consists of both the Request and Response body for the particular called API.
9. Used Enum class to retrieve the API resource for the called APIs. 
10. Ran the prject through the TestRunner class.
