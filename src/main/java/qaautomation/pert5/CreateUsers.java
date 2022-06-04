package qaautomation.pert5;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUsers {
	String name = "";
	
	@Test
	public void createUser() {
		RestAssured.baseURI = "https://reqres.in";
		String payload = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		Response response = RestAssured.given().contentType("application/json").body(payload).when().post("/api/users");
		
		name = response.jsonPath().get("name");
		String expectedName = "morpheus";
		
		assertEquals(response.statusCode(), 201);
		assertEquals(name, expectedName);

	}
}
