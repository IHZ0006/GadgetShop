import javax.swing.*; //Importing the GUI library
import java.util.HashMap; //Importing the HashMap class that stores data by the key-value model, where the key is not an index, like in the ArrayList, but can be any value
import java.util.ArrayList; //Importing the ArrayList class 

/* 
* This is an MP3 class, which is a subclass of the Gadget class and has memory parameter that shows all
* memory of the MP3 and availableMemory that will be used for download and delete methods, which are 
* used for adding and deleting tracks respectively. I've used the HashMap for storing tracks, so you 
* can clear up space by deleting a track by it's name instead of just entering how much space you want 
* to clear up
*/

public class MP3 extends Gadget
{
    //In this block of code we have parameters declaration
    private double memory;
    private double availableMemory;
    
    HashMap<String, Double> allTracks = new HashMap<>(); //Creating a HashMap allTracks which takes a track name(String) as a key and file size(Double) as a value
    
    //Next block of code is a contructor of the MP3 class
    public MP3(double memory, String model, double price, int weight, String size)
    {
        super(model, price, weight, size); //"super" keyword is used to access Gadget's class constructor
        this.memory = memory; //I've used "this" keyword to make a distinction between arguments of a constructor and classe's parameters. "This" refers to the current classe's parameter
        availableMemory = memory; //When we initialise an object of an MP3 class, it's available memory should be equal to the whole memory
    }
    
    //Accessor method 
    public double getMemory()
    {
        return availableMemory;
    }
    
    //Method that puts tracks into the HashMap allTracks. We need to return value so GadgetShop would understand whether download was successful
    public boolean download(String name, double fileSize)
    {
        if(fileSize <= availableMemory) //We check whether there is enough memory for the track
        {
            availableMemory -= fileSize; //Reducing available memory by the file size 
            allTracks.put(name, fileSize); //Adding the track to the HashMap with name argument as a key and fileSize as a value
            return true; //We return true, because download was successful
        }
        else //If there is not enough memory, we show an alert about that in the GadgetShop
        {
            JOptionPane.showMessageDialog(GadgetShop.frame, "Not enough memory"); //We pass frame object that is a part of the GadgetShop class as an argument, so showMessageDialog will be displayed inside our main GUI and not as a separate window
            return false; //Download wasn't successful, so we return false
        }
    }
    
    //delete method is used to remove the track from the HashMap. It requires the key value being passed as an argument
    public boolean delete(String name)
    {
        try{ //If we'll use the name value as a get method's argument which is not a key in the allTracks HashMap, java will throw an error
            double fileSize = allTracks.get(name); //Trying to get the file size from the HashMap by the name key
            availableMemory += fileSize; //Adding the amount of available memory that is equal to the file size
            allTracks.remove(name); //Removing the value form the HashMap
            return true; //Because we successfully deleted the track, we return true
        }
        catch(Exception e) //If the error is thrown, we need to tell the user that the track is not found
        {
            JOptionPane.showMessageDialog(GadgetShop.frame, name + " not found");
            return false; //Because operation wasn't successful, we return false
        }
    }
    
    //Here we override the display method of the Gadget class
    public void display()
    {
        super.display(); //Here we are calling the display method of the Gadget class
        System.out.println("An amount of memory available: " + availableMemory + "; \n"); //Then we are printing a new line in the console
    }
}
