package StepDefinations;

import io.cucumber.java.Before;

public class Hooks {
	
	StepDefination m=new StepDefination();
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Exception
	{
		if(m.placeid==null)
		{
		m.add_place_payload_with("sai", "Telugu", "warangal");
		m.user_call_with_http_request("AddPlaceAPI", "POST");
		m.verify_placed_id_created_maps_to_using("sai", "getPlaceApI");
	}
	}
}
