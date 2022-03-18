package com.rmgyantra.com.DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.genericutils.PojoClassForCreatingresource;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SameRequestWithMultipleDataTest {

	@Test(dataProvider="getData")
	public void create(String createdBy,String projectName,String status,int teamSize)
	{
		PojoClassForCreatingresource pojo = new PojoClassForCreatingresource(createdBy,projectName,status,teamSize);
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][]objArray=new Object[4][4];//creating object for 2d object array
		
		objArray[0][0]="dravid";
		objArray[0][1]="cricket";
		objArray[0][2]="completed";
		objArray[0][3]=11;

		objArray[1][0]="sachin";
		objArray[1][1]="cricket1";
		objArray[1][2]="completed";
		objArray[1][3]=11;
		
		objArray[2][0]="ganguly";
		objArray[2][1]="cricket2";
		objArray[2][2]="completed";
		objArray[2][3]=11;
		
		objArray[3][0]="sehwag";
		objArray[3][1]="cricket3";
		objArray[3][2]="completed";
		objArray[3][3]=11;
		return objArray;
	}
	
	
	
}
