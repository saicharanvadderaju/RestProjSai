package StepDefinations;

import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class WeatherAPI extends Utils{
	
	RequestSpecification res;
	Response response;
	ResponseSpecification rs;
	
	
	@Given("User has API Details")
	public void user_has_api_details() {
	 res=given().spec(weatherReq());
	}

	@When("user call getWeatherAPI with GET http request")
	public void user_call_get_weather_api_with_get_http_request() {
	    
		Response response=res.when().get("/data/2.5/weather");
	}
	

	@Then("Validate status code")
	public void validate_status_code() {
	   System.out.println("pass");
	   rs=new ResponseSpecBuilder().expectStatusCode(200).build();
	   
	}

}
