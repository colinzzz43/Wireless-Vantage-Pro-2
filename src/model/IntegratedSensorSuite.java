package model;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;

/** The integrated sensor suite is a device that contains many connected sensors which collect data about their environments.
 * 
 * @version July 2, 2020
 */
public class IntegratedSensorSuite implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 4721190505387048162L;

    /** The degree symbol for use in formatted strings regarding temperature or angles. */
    final static char DEGREE_SYMBOL = 0x00B0;
    
    //Serialized fields must be public. 
    public transient WindSpeedSensor myWindSpeedSensor;
    
    public transient WindDirectionSensor myWindDirectionSensor;
    
    public transient HumiditySensor myHumiditySensor;
    
    public transient TemperatureSensor myTemperatureSensor;
    
    public transient RainCollectorSensor myRainSensor;
    
	public static Timer timer;
    
    /** Each Vantage Pro2 console can receive data from up to 8 different wireless transmitters.
     *  The default transmitter ID for the sensor suite is 1, and in most cases it is not necessary to change it.
     */
    public int myTransmitterId = 1;
    
    public String myCurrentWindDirection;
    
    public String myCurrentWindSpeed;
    
    public int myCurrentHumidity;
    
    public int myCurrentTemperature;
    
    public double myCurrentRainAmount;
    
    Thread windSpeedThread;
    
    Thread windDirectionThread;
    
	Thread humidityThread;
	
	Thread rainThread;
	
	Thread temperatureThread;
    
    /** 
     * Constructor of a Integrated Sensor Suite which contains a variety of sensors and stores the current data. 
     * @param theTransmitterId
     */
    public IntegratedSensorSuite(int theTransmitterId) {
        myTransmitterId = theTransmitterId;
        initializeSensors();
        initializeThreads();
        startAllThreads();
        //initializeOutputTimer();
    }
    
    /**
     * initializes the sensor object for each sensor
     */
    public void initializeSensors() {
    	myWindSpeedSensor = new WindSpeedSensor();
    	myWindDirectionSensor = new WindDirectionSensor();
        myHumiditySensor = new HumiditySensor();
        myTemperatureSensor = new TemperatureSensor();
        myRainSensor = new RainCollectorSensor();
    }
    
    /**
     * initializes the individual thread for each sensor
     */
    public void initializeThreads() {
    	windSpeedThread = new Thread(new WindSpeedSensor());
    	windDirectionThread = new Thread(new WindDirectionSensor());
		humidityThread = new Thread(new HumiditySensor());
		rainThread = new Thread(new RainCollectorSensor());
		temperatureThread = new Thread(new TemperatureSensor());
    }
    
    /**
     * starts the individual thread for each sensor
     * TODO: create start and interrupt methods for each individual sensor
     */
    public void startAllThreads() {
    	windSpeedThread.start();
    	windDirectionThread.start();
		humidityThread.start();
		rainThread.start();
		temperatureThread.start();
    }
    
    /**
     * prints all current sensor data to console
     * mostly for testing purposes, GUI will not use this method
     */
    public void initializeOutputTimer() {
    	timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
            public void run() {
                System.out.println(Main.myIntegratedSensorSuite);
            }
		}, 1000, 1000); //runs once after a 1sec delay then again every second
    }

    /**
     * A method which re-initializes the current data of the sensors.
     */
    public void reinitializeAllData() {
        myWindSpeedSensor.recalibrateData();
        myWindDirectionSensor.recalibrateData();
        myHumiditySensor.recalibrateData();
        myTemperatureSensor.recalibrateData();
        myRainSensor.recalibrateData();
        myCurrentRainAmount = myRainSensor.getReading();
        myCurrentWindDirection = myWindDirectionSensor.getCurrentWindDirection();
        myCurrentWindSpeed = myWindSpeedSensor.getCurrentWindSpeed();
        myCurrentHumidity = myHumiditySensor.getSensorReading();
        myCurrentTemperature = myTemperatureSensor.getSensorReading();
    }
    
    
    public void startHumiditySensor() {
        myHumiditySensor = new HumiditySensor();
        myHumiditySensor.restartTimer();
		humidityThread = new Thread(new HumiditySensor());
		humidityThread.start();
    }
    
    public void startRainCollector() {
    	myRainSensor = new RainCollectorSensor();
    	myRainSensor.restartTimer();
    	rainThread = new Thread(new RainCollectorSensor());
    	rainThread.start();
    }
    
    public void startTemperatureSensor() {
    	myTemperatureSensor = new TemperatureSensor();
    	myTemperatureSensor.restartTimer();
        temperatureThread = new Thread(new TemperatureSensor());
		temperatureThread.start();
    }
    
    public void startWindDirectionSensor() {
    	myWindDirectionSensor = new WindDirectionSensor();
    	myWindDirectionSensor.restartTimer();
    	windDirectionThread = new Thread(new WindDirectionSensor());
    	windDirectionThread.start();
    }
    
    public void resumeWindSpeedSensor() {
    	myWindSpeedSensor = new WindSpeedSensor();
    	myWindSpeedSensor.restartTimer();
    	windSpeedThread = new Thread(new WindSpeedSensor());
        windSpeedThread.start();
    }
    
    public void pauseHumiditySensor() {
    	myHumiditySensor.cancelTimer();
    }
    
    public void pauseRainSensor() {
    	myRainSensor.cancelTimer();
    }
    
    public void pauseTemperatureSensor() {
    	myTemperatureSensor.cancelTimer();
    }
    
    public void pauseWindDirectionSensor() {
    	myWindDirectionSensor.cancelTimer();
    }
    
    public void pauseWindSpeedSensor() {
    	myWindSpeedSensor.cancelTimer();
    }
    
    /**
     * A method which re-initializes the current data of the wind sensors.
     */
    public void reinitializeWindSpeedData() {
        myWindSpeedSensor.recalibrateData();
        myCurrentWindSpeed = myWindSpeedSensor.getCurrentWindSpeed();
        
    }
    
    /**
     * A method which re-initializes the current data of the wind sensors.
     */
    public void reinitializeWindDirectionData() {
        myWindDirectionSensor.recalibrateData();
        myCurrentWindDirection = myWindDirectionSensor.getCurrentWindDirection();
        
    }
    
    /**
     * A method which re-initializes the current data of the humidity sensors.
     */
    public void reinitializeHumidityData() {
    	myHumiditySensor.recalibrateData();
    	myCurrentHumidity = myHumiditySensor.getSensorReading();
    }
    
    /**
     * A method which re-initializes the current data of the temperature sensors.
     */
    public void reinitializeTemperatureData() {
    	myTemperatureSensor.recalibrateData();
        myCurrentTemperature = myTemperatureSensor.getSensorReading();
    }
    
    /**
     * A method which re-initializes the current data of the rain sensors.
     */
    public void reinitializeRainData() {
    	myRainSensor.recalibrateData();
    	myCurrentRainAmount = myRainSensor.getReading();
    }
    
    /** Returns the transmitter ID. */
    public int getTransmitterId() {
        return myTransmitterId;
    };
    
    /** Changes the transmitter ID. */
    public void setTransmitterId(int theInt) {
        myTransmitterId = theInt;
    }
    
    /** Changes current sensor readings to exact values (for testing purposes) */
    public void setSensorReadings(int theWindDirection, int theWindSpeed, int theHumidity, int theTemp, double theRain) {
        myCurrentWindDirection = Integer.toString(theWindDirection);
        myCurrentWindSpeed = Integer.toString(theWindSpeed);
        myCurrentHumidity = theHumidity;
        myCurrentTemperature = theTemp;
        myCurrentRainAmount = theRain;
    }
    
    @Override
    public String toString() {
        return "Wind Direction: " + myCurrentWindDirection + ". Wind Speed: " + myCurrentWindSpeed + ". Humidity: " 
                + myCurrentHumidity + "%. Temperature: " + myCurrentTemperature + DEGREE_SYMBOL + "F. " + "RainAmount: " 
                + myCurrentRainAmount;
    }
    
//	/**
//	 * creates a new thread to generate proxy data every 30 seconds
//	 */
//	@Override
//	public void run() {
//		timer = new Timer();
//		timer.schedule(new TimerTask() {
//			@Override
//            public void run() {
//                Main.myIntegratedSensorSuite.reinitializeData();;
//                System.out.println(Main.myIntegratedSensorSuite);
//                Main.serialization("data.txt", Main.myIntegratedSensorSuite);
//            }
//		}, 0, 30000); //runs once initially then again every 30 seconds
//	}
//    
}
