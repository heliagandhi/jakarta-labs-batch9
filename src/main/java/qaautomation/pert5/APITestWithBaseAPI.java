package qaautomation.pert5;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class APITestWithBaseAPI extends BaseAPITest{
	
	@Test
	public void dashboardAPI() {
		Response responseDashboard = given().spec(loginJsonSpec).param("status", "completed").when().get("/build_cards");
		assertEquals(responseDashboard.statusCode(), 200);
	}

	@Test
	public void configAPI() {
		Response responseConfig = given().spec(commonJsonSpec).when().get("/configurations");
		assertEquals(responseConfig.statusCode(), 200);
	}
	
	@Test
	public void userAPI() {
		Response responseUser = given().spec(loginJsonSpec).param("status", "completed").when().get("/user");
		assertEquals(responseUser.statusCode(), 200);
	}
	
	//public void user api
	
}
