package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

// Step definition class should have only logic.

public class StepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	static Response response;
	static String place_id;
	static String address;
	static String key;
	JsonPath js;
	String expectedmsg = "Address successfully updated";

	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}

	@When("User calls the {string} using the {string} http request")
	public void user_calls_using_the_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions

		// Constructor will be called with the value of resource which we pass
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceAPI.getResource());
//			.then().spec(resspec).extract().response()
		} else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getResource());
		}

		else if (method.equalsIgnoreCase("DELETE")) {
			response = res.when().delete(resourceAPI.getResource());
//			.then().spec(resspec).extract().response()
		}
		
		else if(method.equalsIgnoreCase("PUT"))
		{
			response = res.when().put(resourceAPI.getResource());
		}

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@Then("the api call is success with the response code and the status code")
	public static void the_api_call_is_success_with_the_response_code_and_the_status_code() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, keyValue), Expectedvalue);
	}

	@Then("verify place_Id create maps to {string} using {string}")
	public void verify_place_Id_create_maps_to_using(String expectedName, String resource) throws IOException {
		// Use the same Request Spec
		place_id = getJsonPath(response, "place_id");
		
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);

		// Since we need to use Get Method we will call the same method.
		user_calls_using_the_http_request(resource, "GET");

		// Get the 'name' value from the Response body
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expectedName);

	}

	@Given("Delete Place Payload")
	public void delete_place_payload() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
	
	// Update the place.
	
	@Given("Update Place Payload")
	public void update_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		res = given().spec(requestSpecification()).body(data.updatePlacePayload(place_id));
		user_calls_using_the_http_request("updatePlaceAPI", "PUT");
		
		
//		the_api_call_is_success_with_the_response_code_and_the_status_code();
		
		String actualmsg = getJsonPath(response, "msg");
		System.out.println(actualmsg);
//		assertEquals(actualmsg, expectedmsg);
		
	}
}
