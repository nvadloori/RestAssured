package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GET_allEmployees extends TestBase {

	@BeforeClass
	public void getAllEmployees() throws InterruptedException {
		
		logger.info("***************Started TC001_Get_EmployeeDetails*********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		
		Thread.sleep(3);
	}
	

	@Test
	public void validateResponseBody() {
		logger.info("***************checking Response Body *********");
		String responseBody = response.getBody().asString();
		logger.info("Response Body :" +responseBody);
		Assert.assertTrue(responseBody != null);
	}

	@Test
	public void checkStatusCode() {
		logger.info("***************checking status code************");
		int statusCode = response.getStatusCode();
		logger.info("StatusCode :" + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void checkResponseTime() {
		logger.info("***************checking Response Time************");
		long responseTime = response.getTime();
		logger.info("StatusCode =>" +responseTime);
		if (responseTime > 2000) {
			logger.warn("Response time is greater than 2000");
		}
	}
	
	@Test
	public void checkStatusLine() {
		logger.info("***************checking Status Line************");
		String statusLine = response.statusLine();
		logger.info("status line:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("***************Test Completed ************");

	}


}
