package com.rmgyantra.EndtoEndTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class End2EndTest {

	@Test
	public void end2end() throws SQLException
	{
		Random random = new Random();
		int randomnumber = random.nextInt(2000);
		
		
String expectedProjectName="war"+randomnumber;
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","putin");
		jobj.put("projectName","war"+randomnumber);
		jobj.put("status","invasion");
		jobj.put("teamSize",1200);
		
		Response response = given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		
		
		.when()
		.post("http://localhost:8084/addProject");
		
		
		
		response.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		String actualProjectNamefromresponse=response.jsonPath().get("projectName");
		
		//response validation
		Assert.assertEquals(actualProjectNamefromresponse, expectedProjectName);
		
		
		//database validation
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = conn.createStatement();
		String query="select * from project";
		ResultSet resultset = statement.executeQuery(query);
		
		while(resultset.next())
		{
			String pronamefromdatabase = resultset.getString(4);
			
			if(pronamefromdatabase.equals(actualProjectNamefromresponse))
			{
			Assert.assertEquals(pronamefromdatabase,actualProjectNamefromresponse);
			System.out.println(pronamefromdatabase);
			System.out.println(actualProjectNamefromresponse);
			}
		}	
	}
	
	
	
	
	
	
	
	
}
