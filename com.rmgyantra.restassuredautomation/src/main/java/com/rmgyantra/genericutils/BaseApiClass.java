package com.rmgyantra.genericutils;

import static io.restassured.RestAssured.*;

	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;

	public class BaseApiClass  {
		public DatabaseUtility Datau = new DatabaseUtility();
	  public JavaUtility jlib = new JavaUtility();
		@BeforeSuite
		public void bsconfige() {
			
			Datau.connectToDb();
			baseURI = "http://localhost";
			port=8084;	
		}
		@AfterSuite
		public void afConfige() {
			Datau.closeDb();
		}
	
	
	
	
	
	
}
