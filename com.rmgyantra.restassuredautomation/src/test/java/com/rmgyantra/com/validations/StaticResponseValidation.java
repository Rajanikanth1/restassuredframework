package com.rmgyantra.com.validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticValidate()
	{
		
		String expectedProid="TY_PROJ_1003";
		
		Response response = when()
		.get("http://localhost:8084/projects");
		
		String actualProid = response.jsonPath().get("[0].projectId");
		System.out.println(actualProid);
		
		response.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		Assert.assertEquals(actualProid, expectedProid);
		response.then().log().all();
	}
	
	
	
}
