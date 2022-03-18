package com.rmgyantra.com.validations;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class ValidateUsingTestngTest {

	@Test
	
	public void validate()
	{
		String expectedcontenttype="application/json";
		String expectedheader="Access-Control-Request-Headers";
		
		
		Response response = when()
		.get("http://localhost:8084/projects");
		
		String actualvaryvalue = response.getHeader("vary");
		System.out.println(actualvaryvalue);
		
		
		
		String contentType=response.getContentType();
		System.out.println(contentType);
		Assert.assertEquals(expectedcontenttype, contentType);
		Assert.assertEquals(expectedheader, actualvaryvalue);
		response.then().log().all();
	}
	
	
	
	
	
	
	
}
