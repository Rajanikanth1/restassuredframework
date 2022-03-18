package com.rmgyantra.genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
public Connection connection=null;
	
/**
 * this method will connect database to java technology
 */
	public void connectToDb()
	{
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");	
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * this method will close the database connection
	 */
	public void closeDb()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		
	
	/**
	 * this method will return all the data from the database
	 * @param query
	 * @return
	 */
	public ResultSet getAlltheData(String query)
	{ResultSet result=null;
		try {
			 result = connection.createStatement().executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	
	
	public String gettheDataandVerify(String query,String actualData,int columnNumber,String expectedData) throws SQLException
	{ResultSet result = connection.createStatement().executeQuery(query);
	boolean flag=false;
	actualData=null;
	
	while(result.next()) {
		
		try {
		if(result.getString(columnNumber).equals(expectedData))
				{
					flag=true;
					actualData=result.getString(columnNumber);
					break;
				}
				
			}			
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		if(flag==true)
		{
			System.out.println("data is verified from database end");
			return actualData;
			
		}
		
		
		
	}
	return actualData;
		
		
	}	}
	

