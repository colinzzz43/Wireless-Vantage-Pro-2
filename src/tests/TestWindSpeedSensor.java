package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.WindSpeedSensor;

class TestWindSpeedSensor {

	WindSpeedSensor myWindSpeedSensor = new WindSpeedSensor();
	
	/**
	 * Wind speed should never be negative
	 */
	@Test
	void testNegative() {
		boolean negative = false;
		for (int i = 0; i < 1000; i++) {
			myWindSpeedSensor.recalibrateData();
			negative = Integer.valueOf(myWindSpeedSensor.rawWindSpeed()) < 0;
		}
		assert(!negative);
	}
	
	/**
	 * Wind speed should never go above 200
	 */
	@Test
	void testTooHigh() {
		boolean tooHigh = false;
		for (int i = 0; i < 1000; i++) {
			myWindSpeedSensor.recalibrateData();
			tooHigh = Integer.valueOf(myWindSpeedSensor.rawWindSpeed()) > 200;
		}
		assert(!tooHigh);
	}
	
	/**
	 * Test getCurrentWindSpeed() method
	 */
	@Test
	void testGetCurrentWindSpeed() {
		String testString = myWindSpeedSensor.rawWindSpeed();
		testString += " MPH";
		assert(myWindSpeedSensor.getCurrentWindSpeed().contentEquals(testString));
	}

}
