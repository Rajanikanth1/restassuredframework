package com.rmgyantra.com.validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.genericutils.PojoClassForCreatingresource;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class ResponsevalidationUsingPostrequest {

	@Test
	public void validate() {
		
		
		String expectedProName="synex2";
		PojoClassForCreatingresource pobj=new PojoClassForCreatingresource("charlie","synex2","completed",10);
		
		
		
		
		Response response=given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		.post("http://localhost:8084/addProject");
		
		
		
		String actProjectName=response.jsonPath().get("projectName");
		
		
		
		Assert.assertEquals(actProjectName, expectedProName); 
		response.then().log().all();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
