package com.rmgyantra.diffWaystoPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUsingHashMap {

	@Test
	public void createResource()
	{
		HashMap map = new HashMap();
		
		map.put("createdBy","varun");
		map.put("projectName","dream11");
		map.put("status","completed");
		map.put("teamSize",5);
		
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8085/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	
	
	
}
