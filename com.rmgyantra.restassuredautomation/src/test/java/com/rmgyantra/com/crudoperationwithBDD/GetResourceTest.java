package com.rmgyantra.com.crudoperationwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetResourceTest {

	@Test
	
	public void getresource()
	{
		
		when()
		.get("http://localhost:8085/projects")
		
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		
		.log().all();
	
		
		
	}
	
	
	
	
}
