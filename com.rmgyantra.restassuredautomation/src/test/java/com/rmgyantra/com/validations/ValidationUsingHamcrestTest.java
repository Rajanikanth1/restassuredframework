package com.rmgyantra.com.validations;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidationUsingHamcrestTest {

	@Test
	public void validationUsingHamcrestTest()
	{
		
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat().time(Matchers.lessThan(1700L),TimeUnit.MILLISECONDS)
		.log().all();
	
		
		
	}
	
	
	
	
	
}
