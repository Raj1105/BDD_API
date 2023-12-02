package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.ReusableMethod;
import resource.Utils;
import resource.payLoad;

public class stepDefinition extends Utils {

	 ResponseSpecification response;
	 RequestSpecification res;
	 Response respone;
	payLoad pl = new payLoad();
	 static String place_id;

	@Given("Add Add_Place payload with {string} {string} {string}")
	public void add_add_place_payload_with(String name, String language, String address) throws IOException {

		res = given().spec(requestResponseSpecification()).body(pl.addPayloads(name, language, address));
	}

	@When("Call {string} with {string} http request")
	public void call_with_http_request(String resource, String method) {

		ReusableMethod rMethod = ReusableMethod.valueOf(resource);
		System.out.println(rMethod.getMethods());
		response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("post")) {
			respone = res.when().post(rMethod.getMethods());
		} else if (method.equalsIgnoreCase("get")) {
			respone = res.when().get(rMethod.getMethods());
		}
	}

	@Then("verify API sucess with statusCode {int}")
	public void verify_api_sucess_with_status_code(Integer expectedStatusCode) {

		assertEquals(respone.getStatusCode(), 200);
	}

	@Then("check {string} message as {string}")
	public void check_message_as(String keyValue, String expectedValue) {

		assertEquals(getJsonData(respone, keyValue), expectedValue);
	}

	@Then("verify place_id map with {string} using {string} request")
	public void verify_place_id_map_with_using_request(String expectedName, String resource) throws IOException {

		// get place_id
		place_id = getJsonData(respone, "place_id");
		// spec builder to add place_id query parameter
		res = given().spec(requestResponseSpecification()).queryParam("place_id", place_id);
		call_with_http_request(resource, "GET");
		String actualName = getJsonData(respone, "name");
		assertEquals(actualName, expectedName);
	}
	
	@Given("Add delete payload with place_id")
	public void add_delete_payload_with_place_id() throws IOException {
		
		res = given().spec(requestResponseSpecification()).body(pl.getPlaceid(place_id));
	    
	}
}
