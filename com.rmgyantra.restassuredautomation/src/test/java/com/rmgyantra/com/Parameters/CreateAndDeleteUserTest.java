package com.rmgyantra.com.Parameters;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateAndDeleteUserTest {

	@Test
	
	public void createAndDeleteUser()
	{
		Random rand = new Random();
		int randomnumber = rand.nextInt(3000);
		
		
		//create a user using json object
		
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
		
		
		Response response = given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/employees");
		
		response.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		//catch empID from the response
		String empid=response.jsonPath().get("employeeId");
		
		//store it in path parameter
		given()
		.pathParam("employeeId",empid)
		
		
		//delete the user using empid
		
		.when()
		.delete("http://localhost:8084/employees/{employeeId}")
		
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
	
	
	
	
	
}
