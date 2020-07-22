package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.HumiditySensor;

class TestHumiditySensor {
	
	HumiditySensor myHumiditySensor = new HumiditySensor();

	/**
	 * The constructor should set humidity to 1. This also tests the getter.
	 */
	@Test
	void testConstructor() {
		assert(myHumiditySensor.getSensorReading() == 1);
	}
	
	/**
	 * Tests the toString() method.
	 */
	@Test
	void testToString() {
		assert(myHumiditySensor.toString().contentEquals("1%"));
	}
	
	/**
	 * The function that changes the humidity level should never make it go negative.
	 */
	@Test
	void testRecalibrateData0() {
		boolean isNegative = false;
		for (int i = 0; i < 1000; i++) {
			myHumiditySensor.recalibrateData();
			isNegative = myHumiditySensor.getSensorReading() < 0;
		}
		assert(!isNegative);
	}
	
	/**
	 * The function that changes the humidity level should never make it go above 100.
	 */
	@Test
	void testRecalibrateDate100() {
		boolean isTooHigh = false;
		for (int i = 0; i <1000; i++) {
			myHumiditySensor.recalibrateData();
			isTooHigh = myHumiditySensor.getSensorReading() > 100;
		}
		assert(!isTooHigh);
	}
	
	/* I cant figure out how to test these
	 * 
	 * 
	 * 
	@Test
	void testRun() {
		myHumiditySensor.run();
		myHumiditySensor.cancelTimer();
		assert(myHumiditySensor.getTimerStatus());
	}

	@Test
	void testCancelTimer() {
		myHumiditySensor.cancelTimer();
		assert(myHumiditySensor.getTimerStatus());
	}
	*
	*
	*
	*/
	
	/**
	 * The restarTimer() method should create a timer.
	 */
	@Test
	void testRestartTimer() {
		myHumiditySensor.restartTimer();
		assert(!myHumiditySensor.getTimerStatus());
	}

}
