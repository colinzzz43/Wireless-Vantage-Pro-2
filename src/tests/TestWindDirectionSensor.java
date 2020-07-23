package tests;

import org.junit.jupiter.api.Test;

import model.WindDirectionSensor;

class TestWindDirectionSensor {
	
	WindDirectionSensor myWindDirectionSensor = new WindDirectionSensor();

	/**
	 * Wind direction should never be negative
	 */
	@Test
	void testNonNegative() {
		boolean negative = false;
		for (int i = 0; i < 1000; i++) {
			myWindDirectionSensor.recalibrateData();
			negative = Integer.valueOf(myWindDirectionSensor.rawWindDirection()) < 0;
		}
		assert(!negative);
	}
	
	/**
	 * Wind direction should never be above 360
	 */
	@Test
	void testTooHigh() {
		boolean tooHigh = false;
		for (int i = 0; i < 1000; i++) {
			myWindDirectionSensor.recalibrateData();
			tooHigh = Integer.valueOf(myWindDirectionSensor.rawWindDirection()) > 360;
		}
		assert(!tooHigh);
	}
	
	/**
	 * Tests toString() method
	 */
	@Test
	void testToString() {
		myWindDirectionSensor = new WindDirectionSensor();
		char degree = 0x00B0;
		String testString = myWindDirectionSensor.rawWindDirection();
		testString += degree;
		assert(myWindDirectionSensor.getCurrentWindDirection().contentEquals(testString));
	}

}
