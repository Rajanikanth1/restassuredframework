package com.rmgyantra.com.crudoperationwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;



public class CreateResource {

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
