package com.rmgyantra.com.Authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BarrierTokenTest {

	
	@Test
	public void authentication()
	{
		
		given()
		.auth().oauth2("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")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	
	
	
	
}
