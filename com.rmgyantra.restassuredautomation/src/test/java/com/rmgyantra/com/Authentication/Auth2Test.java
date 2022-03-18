package com.rmgyantra.com.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2Test {

	@Test
	public void authentication()
	{
		Response response = given()
		.formParam("client_id","SDET29 1")
		.formParam("client_secret","1d2b6295be46f71c4f28348d81606745")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","https://restassured.com")
		.formParam("code","2960")
		
		
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		response.then().log().all();
		


		
		
		String token=response.jsonPath().get("access_token");
		
		//now i want to pass this token into the next request
		given()
		.auth().oauth2(token)
		.pathParam("User Id",2960)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{User Id}/chickens-feed")
		.then().log().all();
		
		
		given()
		.auth().oauth2(token)
		.pathParam("User Id",2960)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{User Id}/toiletseat-down")
		.then().log().all();
		
		
		given()
		.auth().oauth2(token)
		.pathParam("User Id",2960)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{User Id}/barn-unlock")
		.then().log().all();
		
		
		
	}
	
	
	
	
	
}
