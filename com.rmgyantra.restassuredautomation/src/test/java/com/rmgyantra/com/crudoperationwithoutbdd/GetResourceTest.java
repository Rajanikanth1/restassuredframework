package com.rmgyantra.com.crudoperationwithoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetResourceTest {

	@Test
	
	
	public void getresource()
	{
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		ValidatableResponse vr = response.then();
		
		
		vr.log().all();//we get body and header
		
		
		response.prettyPrint();//we get response body
		response.prettyPeek();//we get body and header
		response.asString();//we get values in single line
		
		response.then().assertThat().statusCode(201);
		response.then().assertThat().contentType(ContentType.JSON);
		response.then().log().all();
	}
	
	
	
	
	
}
