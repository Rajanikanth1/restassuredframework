package com.rmgyantra.com.crudoperationwithoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateResourceTest {

	@Test
	
	public void createresource()
	{
		
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy","rajini123");
		jobj.put("projectName","p1");
		jobj.put("status","rajini123");
		jobj.put("teamSize",12);
		
		
		
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		
		Response response = reqspec.post("http://localhost:8085/addProject");
		
	//response.then().assertThat().statusCode(201);
	//response.then().assertThat().contentType(ContentType.JSON);
	response.then().log().all();
		
		
	}
	
	
	
	
}
