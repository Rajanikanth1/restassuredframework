package com.rmgyantra.com.crudoperationwithoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteresourceTest {

	
	@Test
	
	public void delete()
	{
		
		RestAssured.delete("http://localhost:8085/projects/TY_proj_1001");
		
		
		
	}
	
	
	
	
}
