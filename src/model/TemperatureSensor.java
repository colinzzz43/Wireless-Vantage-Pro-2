package model;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;

/**
 * The sensor dedicated to the temperature provided by the device.
 */
public class TemperatureSensor extends AbstractSensor{
	
	public Timer timer;
	
	/**
	 * Holds the value of the temperature
	 */
    private int temp;

    /**
     * Constructor. Initializes temp to 0°.
     * To change temp value, call recalibrateData();
     */
    public TemperatureSensor(){
        temp = 0;
    }

    /**
     * Returns int representation of temperature in range of -40 to 150 F
     * 
     * @returns Temperature as an int
     */
    public int getSensorReading(){
        return temp;
    }

    /**
     * Returns string representation of temperature
     * in format of "0° F"
     * 
     * @return A string representation of temperature
     */
    public String toString() {
        return (temp + "° F");
    }

    /**
     * Sets the temp in this class by pulling from raw data (in this case, the proxy class). 
     * If out of range (-40 to 150 F) rounds to nearest edge value. 
     */
	@Override
	public void recalibrateData() {
    	temp = random.nextInt(150); //again 2 byte maximum yikes that's extreme. the documentation doesn't specify but we can assume this is a signed 2s complement value
		if(random.nextBoolean()) {
			temp = -temp; //50% chance to be negative value
		}
    	
    	if(temp < -40) {
    		temp = -40;
    	}
    	else if(temp > 150) {
    		temp = 150;
    	}		
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
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
            public void run() {
                Main.myIntegratedSensorSuite.reinitializeTemperatureData();
            }
		}, 0, 10000); //runs once initially then again every 10 seconds
	}
}
