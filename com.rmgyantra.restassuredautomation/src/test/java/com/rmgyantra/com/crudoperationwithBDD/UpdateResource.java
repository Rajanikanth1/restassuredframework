package com.rmgyantra.com.crudoperationwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateResource {

	@Test
	
	public void updateresource()
	{
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy","kiran1");
		jobj.put("projectName","pn1");
		jobj.put("status","rajini123");
		jobj.put("teamSize",12);
		
		
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("http://localhost:8085/projects/TY_PROJ_1602")
		
		.then()
		.assertThat()
		
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
	
	
	
	
}
