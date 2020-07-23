package tests;

import org.junit.jupiter.api.Test;

import model.IntegratedSensorSuite;

class TestISS {
	
	IntegratedSensorSuite myISS;

	/**
	 * The sensor suite should not be null when the constructor is called.
	 */
	@Test
	void testConstructor() {
		myISS = new IntegratedSensorSuite(1);
		assert(myISS != null);
	}
	
	/**
	 * The sensor suite should not be null when the constructor is called.
	 */
	@Test
	void testAssorted() {
		myISS = new IntegratedSensorSuite(1);
		assert(myISS != null);
		myISS.startHumiditySensor();
		myISS.startRainCollector();
		myISS.startTemperatureSensor();
		myISS.startWindDirectionSensor();
		myISS.startWindSpeedSensor();
		myISS.pauseHumiditySensor();
		myISS.pauseRainSensor();
		myISS.pauseTemperatureSensor();
		myISS.pauseWindDirectionSensor();
	}
	
	/**
	 * Tests the ability to print data to console.
	 */
	@SuppressWarnings("static-access")
	@Test
	void testInitializeOutputTimer() {
		myISS = new IntegratedSensorSuite(1);
		myISS.initializeOutputTimer();
		assert(myISS.timer != null);
	}
	
	/**
	 * Tests the ability to change all sensor data.
	 */
	@Test
	void testReinitializeAllData() {
		myISS = new IntegratedSensorSuite(1);
		String testString1 = myISS.toString();
		myISS.reinitializeAllData();
		String testString2 = myISS.toString();
		assert(!testString1.contentEquals(testString2));
	}
	
	/**
	 * Test getTransmitterId()
	 */
	@Test
	void testGetTransmitterId() {
		myISS = new IntegratedSensorSuite(1);
		assert(myISS.getTransmitterId() == 1);
	}
	
	/**
	 * Test setTransmitterId()
	 */
	@Test
	void testSetTransmitterId() {
		myISS = new IntegratedSensorSuite(1);
		myISS.setTransmitterId(2);
		assert(myISS.getTransmitterId() == 2);
	}
	
	/**
	 * Test the ability to set sensor readings.
	 */
	@Test
	void testSetSensorReadings() {
		myISS = new IntegratedSensorSuite(1);
		myISS.setSensorReadings(0, 0, 0, 0, 0);
		StringBuilder sb = new StringBuilder();
		sb.append("Wind Direction: 0.");
		sb.append(" Wind Speed: 0.");
		sb.append(" Humidity: 0%.");
		sb.append(" Temperature: 0");
		char degree = 0x00B0;
		sb.append(degree);
		sb.append("F. RainAmount: 0");
		String testString = sb.toString();
		assert(!testString.contentEquals(myISS.toString()));
	}

}
