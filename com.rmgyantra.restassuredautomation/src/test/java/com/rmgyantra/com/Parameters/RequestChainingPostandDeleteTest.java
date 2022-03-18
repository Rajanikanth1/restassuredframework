package com.rmgyantra.com.Parameters;

import org.testng.annotations.Test;

import com.rmgyantra.genericutils.PojoClassForCreatingresource;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingPostandDeleteTest {

	
	
	@Test
	public void reqChaining()
	{
		PojoClassForCreatingresource pobj=new PojoClassForCreatingresource("charlie","pedex","completed",10);
		
		Response response =given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		 .when()
		.post("http://localhost:8084/addProject");
		
		
		String projectid=response.jsonPath().get("projectId");
		
		given()
		.pathParam("projectId",projectid)
		
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		
		
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
	
	
	
	
	
}
