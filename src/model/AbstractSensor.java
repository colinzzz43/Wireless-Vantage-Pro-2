package model;
import java.util.Random;


/**
 * AbstractSensor includes behavior of a sensor within the Integrated Sensor Suite. A sensor provides data to the Vantage Pro2 Console.
 * @version 6/28/20
 */
public abstract class AbstractSensor implements Runnable{
    
    /** The degree symbol for use in formatted strings regarding temperature or angles. */
    final static char DEGREE_SYMBOL = 0x00B0;
    
    /** This method will reach out to ProxyData for the appropriate static method for the sensor to be to be set to its variable(s).
     */
    public abstract void recalibrateData();
    
    protected static Random random = new Random();
    
    public abstract void cancelTimer();
    
    public abstract void restartTimer();
  
}
