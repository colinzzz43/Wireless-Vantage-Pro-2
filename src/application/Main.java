package application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import model.*;
import view.*;

/**
 * TCSS 360 Group project#1 - Group 01
 * Driver class for Vantage Pro2 Integrated Sensor Suite software
 * @author richardbankhead
 * 
 * Team: I added some vague class names based on Chapter 6 info. 
 * We don't need to use these but they might be a good place to start
 */
public class Main {

    public static IntegratedSensorSuite myIntegratedSensorSuite = new IntegratedSensorSuite(1);
    
    public static String FILE_NAME = "data.txt";
    
	public static void main(String[] args) {
		
		new ConsoleView();
		
	}

    /**
   * A method which takes a filepath name and object to serialize. The file can then be deserialized to return the object. 
   * @param theFileName
   * @param theObject
   */
  public static void serialization(String theFilePath, Object theObject) {
         try
          {    
              //This will clear the file of any previous data
              PrintWriter writer = new PrintWriter(theFilePath);
              writer.print("");
              writer.close();
             
              //Saving of object in a file 
              FileOutputStream file = new FileOutputStream(theFilePath); 
              ObjectOutputStream out = new ObjectOutputStream(file); 
                
              // Method for serialization of object 
              out.writeObject(theObject); 
                
              out.close(); 
              file.close(); 
                
              System.out.println("Object has been serialized"); 
    
          } 
            
          catch(IOException ex) 
          { 
              System.out.println("Serialization Failed."); 
              ex.printStackTrace();
          } 
  }
  
  /**
   * For testing purposes, a method to deserialize the data.
   * @param theFilePath
   */
  public static void deserialization(String theFilePath) {
      try
      {    
          // Reading the object from a file 
          FileInputStream file = new FileInputStream(theFilePath); 
          ObjectInputStream in = new ObjectInputStream(file); 
            
          // Method for deserialization of object 
          IntegratedSensorSuite theSuite = (IntegratedSensorSuite) in.readObject(); 
            
          in.close(); 
          file.close(); 
            
          System.out.println("Object has been deserialized"); 
          
          System.out.println(theSuite.toString());
      } 
        
      catch(IOException ex) 
      { 
          System.out.println("IOException is caught"); 
      } 
        
      catch(ClassNotFoundException ex) 
      { 
          System.out.println("ClassNotFoundException is caught"); 
      } 
  }
}
