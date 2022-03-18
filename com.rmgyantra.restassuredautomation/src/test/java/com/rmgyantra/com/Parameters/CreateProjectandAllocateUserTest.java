package com.rmgyantra.com.Parameters;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rmgyantra.genericutils.PojoClassForCreatingresource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectandAllocateUserTest {

	@Test
	public void createandAllocate()
	{

		
		Random rand = new Random();
		int randomnumber = rand.nextInt(3000);
		//post project
		
		PojoClassForCreatingresource pobj=new PojoClassForCreatingresource("charlie","pedex4"+randomnumber,"completed",10);
		
		Response response = given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		
		.post("http://localhost:8084/addProject");
		
		
		response.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
		//catch the project name
		String proname=response.jsonPath().get("projectName");
		
		//store it in path parameter
		given()
		.pathParam("projectname",proname);
		
		//post employee or user
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("designation","SDET");
		jobj.put("dob","25/05/199");
		jobj.put("email","nithesh@gmail.com");
		jobj.put("empName","nithes");
		jobj.put("experience",5);
		jobj.put("mobileNo","9888777657");
		jobj.put("project","{projectname}");
		jobj.put("role","ROLE_ADMIN");
		jobj.put("username","nithesh"+randomnumber);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/employees")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
	}
	
	
	
	
	
}
