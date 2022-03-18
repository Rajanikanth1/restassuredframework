package com.rmgyantra.diffWaystoPostRequest;

import org.testng.annotations.Test;

import com.rmgyantra.genericutils.PojoClassForCreatingresource;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUsingPojo {

	
	@Test
	public void createResource()
	{
		PojoClassForCreatingresource pobj = new PojoClassForCreatingresource("arjun", "mahabharat", "completed", 5);
		
		
	given()
	.body(pobj)
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
