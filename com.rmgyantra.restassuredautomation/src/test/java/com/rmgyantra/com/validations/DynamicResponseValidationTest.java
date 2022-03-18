package com.rmgyantra.com.validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {

	@Test
	public void validation()
	{
		String expectedProId="TY_PROJ_1003";
		
		Response response = when()
				.get("http://localhost:8084/projects");
		
		
		List<String> actualProIds = response.jsonPath().get("projectId");
		
		boolean flag=false;
		
		for(String proid:actualProIds)
		{
			if(proid.equals(expectedProId)) {
				System.out.println("value is matching");
				flag=true;
			}
			
		}
		
		Assert.assertEquals(flag,true);
		
	}
	
	
	
	
	
	
}
