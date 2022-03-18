package com.rmgyantra.com.crudoperationwithoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchResourceTest {

	@Test
	
	public void patchresource()
	{
		//step1 to pass the body
		JSONObject object = new JSONObject();
		
		object.put("name","ravi");
		object.put("job","trying");
		
		
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(object);
		
		Response response = reqspec.patch("https://reqres.in/api/users/2");
		
		response.then().log().all();
		
	}
	
	
	
}
