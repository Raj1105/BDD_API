package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class before {

	@Before("@DeletePlace")
	public void RunOnlyDeleteMethod() throws IOException {
 
	stepDefinition sD = new stepDefinition();
	if(stepDefinition.place_id == null) {
		sD.add_add_place_payload_with("Raj", "French", "Asia");
		sD.call_with_http_request("AddPlaceAPI", "POST");
		sD.verify_place_id_map_with_using_request("Raj", "GetPlaceAPI");
}
	}
}
