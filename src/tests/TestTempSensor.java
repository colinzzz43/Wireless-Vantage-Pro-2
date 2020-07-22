package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TemperatureSensor;

class TestTempSensor {
	
	TemperatureSensor myTempSensor = new TemperatureSensor();

	/**
	 * The constructor should set the temp to 0.
	 */
	@Test
	void test() {
		assert(myTempSensor.getSensorReading() == 0);
	}
	
	/**
	 * Test the toString() method.
	 */
	@Test
	void testToString() {
		StringBuilder sb = new StringBuilder();
		sb.append(myTempSensor.getSensorReading());
		sb.append("° F");
		String testString = sb.toString();
		assert(myTempSensor.toString().contentEquals(testString));
	}
	
	/**
	 * Test that the temperature is never below -40.
	 */
	@Test
	void testNeg40() {
		boolean tooLow = false;
		for (int i = 0; i < 10000; i++) {
			myTempSensor.recalibrateData();
			tooLow = myTempSensor.getSensorReading() < -40;
		}
		assert(!tooLow);
	}
	
	/**
	 * Test that the temperature is never above 150.
	 */
	@Test
	void test150() {
		boolean tooHigh = false;
		for (int i = 0; i < 1000; i++) {
			myTempSensor.recalibrateData();
			tooHigh = myTempSensor.getSensorReading() > 150;
		}
		assert(!tooHigh);
	}

}
