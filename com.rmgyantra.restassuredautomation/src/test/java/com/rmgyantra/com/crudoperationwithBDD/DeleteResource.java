package com.rmgyantra.com.crudoperationwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteResource {

	@Test
	public void delete()
	{
		when()
		.delete("http://localhost:8085/projects/TY_proj_1002")
		
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.log().all();
		
	}
	
	
	
}
