package tests;

import static org.junit.jupiter.api.Assertions.*;
import model.RainCollectorSensor;

import org.junit.jupiter.api.Test;

class TestRainCollectorSensor {
	
	RainCollectorSensor myRainCollector = new RainCollectorSensor();
	
	/**
	 * The constructor should set metric to true.
	 */
	@Test
	void testConstructor() {
		assert(myRainCollector.getMetric());
	}
	
	/**
	 * Tests toString() when units set to metric.
	 */
	@Test
	void testToStringMetric() {
		StringBuilder sb = new StringBuilder();
		sb.append(myRainCollector.getRawResult());
		sb.append(" mm in the collector.");
		String testString = sb.toString();
		assert(myRainCollector.toString().contentEquals(testString));
	}
	
	/**
	 * Should be able to set metric units or not.
	 */
	@Test
	void testMetric() {
		myRainCollector.setUnitsMetric(false);
		assert(!myRainCollector.getMetric());
	}
	
	/**
	 * Tests toString() when units not metric.
	 */
	@Test
	void testToStringNotMetric() {
		myRainCollector.setUnitsMetric(false);
		StringBuilder sb = new StringBuilder();
		sb.append(myRainCollector.getRawResult());
		sb.append(" in. in the collector.");
		String testString = sb.toString();
		assert(myRainCollector.toString().contentEquals(testString));
	}

	/**
	 * The rain collector should not return negative.
	 */
	@Test
	void testForNegative() {
		boolean negative = false;
		for (int i = 0; i < 1000; i++) {
			myRainCollector.recalibrateData();
			if (myRainCollector.getReading() < 0) {
				negative = true;
			}
		}
		myRainCollector.setUnitsMetric(false);
		for (int i = 0; i < 1000; i++) {
			myRainCollector.recalibrateData();
			if (myRainCollector.getReading() < 0) {
				negative = true;
			}
		}
		assert(!negative);
	}

}
