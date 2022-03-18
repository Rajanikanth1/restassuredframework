package com.rmgyantra.genericutils;

import java.util.Random;
/**
 * java utility class
 * @author Vandhana
 *
 */

public class JavaUtility {
/**
 * this method will return random number for the test script
 * @return
 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		return randomNumber;
	}
	
	
	
	
}
