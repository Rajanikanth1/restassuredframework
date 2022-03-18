package com.rmgyantra.diffWaystoPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingJsonObject {

	@Test
	
	public void createresource()
	{
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","naveen");
		jobj.put("projectName","pn1");
		jobj.put("status","rajini123");
		jobj.put("teamSize",12);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8085/addProject")
	
	.then()
	.assertThat().statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();
		
		
		
	}
	
	
	
	
}
