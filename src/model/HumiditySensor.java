package model;

import java.util.Timer;
import java.util.TimerTask;

import application.Main;

/**
 * The sensor dedicated to the humidity provided by the device.
 */
public class HumiditySensor extends AbstractSensor{
	
	public Timer timer;
	/**
	 * Holds the value of the humidity sensor
	 */
    private int myHumidity;
    
    //Tells if the timer is cancelled or not
    private boolean timerCancelled;

    /**
     * Constructor. Initializes humidity to 1.
     * To change humidity value, call recalibrateData()();
     */
    public HumiditySensor(){
    	myHumidity = 1;
    	timerCancelled = true;
    }

    /**
     * Returns int representation of humidity in range of 1 to 100 %
     * 
     * @returns humidity as an int
     */
    public int getSensorReading(){
        return myHumidity;
    }

    /**
     * Returns string representation of humidity
     * in format of "1 %"
     * 
     * @return A string representation of humidity percentage
     */
    public String toString(){
        return myHumidity + "%";
    }

    /**
     * Sets the humidity in this class by pulling from raw data (in this case, the proxy class). 
     * If out of range (1 to 100 %) rounds to nearest edge value. 
     */
	@Override
	public void recalibrateData() {
		myHumidity = random.nextInt(101); //from 0-100, field is a percentage
	}
	
	@Override
	public void cancelTimer() {
		timerCancelled = true;
		timer.cancel();
	}

	@Override
	public void restartTimer() {
		timerCancelled = false;
		timer = new Timer();
	}
	
	/**
	 * creates a new thread to generate proxy data every 30 seconds
	 */
	@Override
	public void run() {
		timerCancelled = false;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
            public void run() {
                Main.myIntegratedSensorSuite.reinitializeHumidityData();
            }
		}, 0, 60000); //runs once initially then again every 60 seconds
	}
	
	/**
	 * gets timer status.
	 */
	public boolean getTimerStatus() {
		return timerCancelled;
	}
}
