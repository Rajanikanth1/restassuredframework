package com.rmgyantra.diffWaystoPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUsingJsonFile {

	@Test
	public void createResource()
	{
		File file = new File("./src/test/resources/rcb.json");
		
		given()
		.body(file)
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
