package com.rmgyantra.com.crudoperationwithoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UpdateResourceTest {

	@Test
	
	
	public void updateresource()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","rajini12345");
		jobj.put("projectName","p1");
		jobj.put("status","rajini123");
		jobj.put("teamSize",12);
		
		RequestSpecification rs = RestAssured.given();
		
		rs.contentType(ContentType.JSON);
		rs.body(jobj);
		
		rs.put("http://localhost:8085/projects/TY_PROJ_1402");
		
		
		
		
	}
	
	
	
}
