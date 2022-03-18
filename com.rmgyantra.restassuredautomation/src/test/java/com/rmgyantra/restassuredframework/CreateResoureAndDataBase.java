package com.rmgyantra.restassuredframework;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.genericutils.BaseApiClass;
import com.rmgyantra.genericutils.EndPoints;
import com.rmgyantra.genericutils.PojoClassForCreatingresource;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class CreateResoureAndDataBase extends BaseApiClass {

	
	@Test
	public void create() throws Throwable {
		int rand = jlib.getRandomNumber();
		String ExpectedData = "airtel " + rand;
		System.out.println(ExpectedData);
		
		  PojoClassForCreatingresource pojo = new PojoClassForCreatingresource("rajanikanth111",ExpectedData,"completed", 20);
		 
		 Response response = given()
		 .body(pojo)
		 .contentType(ContentType.JSON)
		 
		 .when()
		 .post(EndPoints.ADDPROJECT);
		 
		 
		String projectNamefromResponse = response.jsonPath().get("projectName");
		 
		  response.then()
		  .assertThat()
		  .contentType(ContentType.JSON)
		  .statusCode(201)
		  .log().all();
		  
		  String query="select * from project";
		  String projectnamefromdatabase = Datau.gettheDataandVerify(query, projectNamefromResponse, 4, ExpectedData);
		  
		  System.out.println(projectNamefromResponse);
		  System.out.println(projectnamefromdatabase);
		 Assert.assertEquals(projectnamefromdatabase, projectNamefromResponse);
	}

}

	
	
	
	
	
	

