package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_POST_getEmployeeData extends TestBase {
	
	@BeforeClass
	public void getEmployeeData() throws InterruptedException {
		
		logger.info("*************Getting Employee Data**********");
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		httpRequest  =  RestAssured.given();
		response = httpRequest.request(Method.GET,"/employee/23");
		Thread.sleep(3000);
	}

	@Test
	void getResponseBody() {
		logger.info("************* Response Body **********");
		String responseBody =  response.getBody().asString();
		System.out.println(responseBody);
		//Assert.assertTrue(responseBody.contains("23"));
	}
	
	@Test
	void getResponseCode() {
		logger.info("***************checking Response code *********");

		int responseCode =  response.statusCode();
		Assert.assertEquals(responseCode, 200);
				
	}
}
