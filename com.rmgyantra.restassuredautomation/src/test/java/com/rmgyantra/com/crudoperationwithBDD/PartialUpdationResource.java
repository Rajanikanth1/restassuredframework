package com.rmgyantra.com.crudoperationwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PartialUpdationResource {

	@Test
	public void partialupdate()
	{
JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy","raju");
		jobj.put("projectName","pn1");
		jobj.put("status","rajini123");
		jobj.put("teamSize",12);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.patch("https://reqres.in/api/users/2")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	}
	
	
	
}
