package com.rmgyantra.genericutils;

import io.restassured.response.Response;

/**
 * JSON utility class
 * @author Vandhana
 *
 */
public class JsonUtility1 {
/**
 * this method will return json response data based on the json path when summoned
 * @return 
 */
	
	public Object getResponseData(Response response,String jsonpath)
	{
	return response.jsonPath().get(jsonpath);
	}
	
	
	
	
	
	
	
}
