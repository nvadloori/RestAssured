package testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_POST_createEmployee extends TestBase {
	
	@BeforeClass
	public void createEmployee() throws InterruptedException {
		logger.info("***************Creating employee *********");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		JSONObject params = new JSONObject();
		params.put("name", "csddfd");
		params.put("salary", 23333);
		params.put("age", 34);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(params.toJSONString());
		
		response = httpRequest.request(Method.POST,"/create");
		
		Thread.sleep(2000);
	}
	
	@Test
	public void responseBody() {
		logger.info("***************checking Response Body *********");

		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("csddfd"),true);
	}
	
	

}
