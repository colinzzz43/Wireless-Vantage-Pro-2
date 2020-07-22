package model;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;

/**
 * The anemometer is a sensor that provides readings on the wind speed and direction.
 */
public class WindSpeedSensor extends AbstractSensor {
    
    /** The wind speed being detected by the anemometer and any point in time. */
    private String myWindSpeed;
    
	/** Timer which can be cancel() by Main or Test classes */
	public static Timer timer = new Timer();
    
    
    public WindSpeedSensor() {
    	recalibrateData();
    }
    
    /** Returns the current wind speed at the moment that the method is called. 
     * @return myWindSpeed - a formatted string which reports the speed of the wind
     */
    public String getCurrentWindSpeed() {
        //myWindSpeed += " MPH"; //format string
        return myWindSpeed += " MPH";
    }
    
    /** reinitializes both wind data variables. */
    public void recalibrateData() {
    	myWindSpeed = Integer.toString(random.nextInt(200)); //1 byte max unsigned, 0-200 MPH
    }
    
    @Override
	public void cancelTimer() {
		timer.cancel();
	}

	@Override
	public void restartTimer() {
		timer = new Timer();
	}
    
	/**
	 * creates a new thread to generate proxy data every 30 seconds
	 */
	@Override
	public void run() {
		timer.schedule(new TimerTask() {
			@Override
            public void run() {
                Main.myIntegratedSensorSuite.reinitializeWindSpeedData();
            }
		}, 0, 3000); //runs once initially then again every 3 seconds
	}
    
	/**
	 * get raw windspeed
	 */
	public String rawWindSpeed() {
		return myWindSpeed;
	}
}
