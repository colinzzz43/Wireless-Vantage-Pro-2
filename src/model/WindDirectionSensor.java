package model;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;

/**
 * The anemometer is a sensor that provides readings on the wind speed and direction.
 */
public class WindDirectionSensor extends AbstractSensor {
    
    /** The wind direction being detected by the anemometer and any point in time. */
    private String myWindDirection;
    
	/** Timer which can be cancel() by Main or Test classes */
	public Timer timer;
    
    
    public WindDirectionSensor() {
    	recalibrateData();
    }
    
    /** Returns the current wind direction at the moment that the method is called. (Finds a random data since these sensors are
     * proxies. 
     * @return myWindDirection - a formatted string which reports the direction of the wind
     */
    public String getCurrentWindDirection() {
        myWindDirection += DEGREE_SYMBOL; //format string
        return myWindDirection;
    }
    
    /** reinitializes both wind data variables. */
    public void recalibrateData() {
    	myWindDirection = Integer.toString(random.nextInt(361)); //from 0-360, represented in degrees. 0 degrees means no wind data
    }
    
	/**
	 * creates a new thread to generate proxy data every 30 seconds
	 */
	@Override
	public void run() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
            public void run() {
                Main.myIntegratedSensorSuite.reinitializeWindDirectionData();
            }
		}, 0, 3000); //runs once initially then again every 3 seconds
	}
    
}
