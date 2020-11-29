package StepDefinations;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import Pojo.AddPlace;
import Pojo.Location;
import Resources.Apiresources;
import Resources.TestDataBuild;
import Resources.Utils;
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

public class StepDefination extends Utils {
	
	RequestSpecification res;
	Response response;
	ResponseSpecification rs;
	JsonPath jp;
	static String placeid;
	
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws Exception {
	   	
		 res=given().spec(requestspecif()).body(data.addPlace(name,language,address));
		
	}

	@When("user call {string} with {string} http request")
	public void user_call_with_http_request(String resource, String method) {
		
		Apiresources apires=Apiresources.valueOf(resource);
		
		 rs=new ResponseSpecBuilder().expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.build();
		 
	    if(method.equalsIgnoreCase("POST"))
	    {
		response=res.when().post(apires.getResource());
		//.then().spec(rs).extract().response();
	    }
	    
	    else if(method.equalsIgnoreCase("GET"))
	    {
	    	response=res.when().get(apires.getResource());
	    }
	}
	@Then("the API call got successful with status code {int}")
	public void the_api_call_got_successful_with_status_code(Integer int1) {
	    
		assertEquals(response.getStatusCode(),200);
		
	}
	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String Expectedkey, String ExpectedValue) {
			
		assertEquals(getJsonPath(response,Expectedkey),ExpectedValue);
	    
	}
	
	@Then("Verify placed_Id created maps to {string} using {string}")
	public void verify_placed_id_created_maps_to_using(String expectedName, String getresoucre) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	   
		 placeid=getJsonPath(response,"place_id");
		
		res=given().spec(requestspecif()).queryParam("place_id", placeid);
		
		user_call_with_http_request(getresoucre,"GET");
		
		String actualname=getJsonPath(response,"name");
		
		assertEquals(actualname,expectedName);
		
	}


	@Given("DeletePlace payload")
	public void delete_place_payload() throws Exception{
	    // Write code here that turns the phrase above into concrete actions
	   
		res=given().spec(requestspecif()).body(data.deletePlacePayload(placeid));
		
	}


}
