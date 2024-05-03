import javax.swing.*; //Importing the GUI library
import java.util.Scanner; //Importing Scanner library
/* 
* This is a Mobile class, which is a subclass of the Gadget class and has remainingMinutes parameter
* that shows remaining miutes that can be used for the makeAPhoneCall method. Also there is an 
* errorPrompt method which is used to top up minutes, if not enough for a call and display errors which can occur due to this process
*/

public class Mobile extends Gadget
{
    private int remainingMinutes; //Declaring the remainingMinutes parameter
    
    //Constructor
    public Mobile(int remainingMinutes, String model, double price, int weight, String size)
    {
        super(model, price, weight, size); //"super" keyword is used to access Gadget's class constructor
        this.remainingMinutes = remainingMinutes; //I've used "this" keyword to make a distinction between arguments of a constructor and classe's parameters. "This" refers to the current classe's parameter
    }
    
    //Accessor for remaining minutes
    public int getRemainingMinutes()
    {
        return remainingMinutes;
    }
    
    //errorPrompt method is used for the situation, when there is not enough miutes to make a call
    private void errorPrompt(int errorCode)
    {
        Scanner scanNum; //Creating Scanner variable 
        int remainingMinutesPrompt = 0; //This variable will be used for the added minutes. I've used a separate variable instead of adding a value straight to the remainingMinutes to check whether the user entered 0
        
        try //For the case when user enters not an integer value, we have a try-catch block
        {
            switch(errorCode) //We use switch statement on the errorCode value to compare it with values that go after case operator. There are 3 possible error codes: 0, 1 and 2. 0 is used when the user entered a 0, 1 is used when there is insufficient credit for a call, 2 is used when user entered the value which is not an integer
            {
                case 0: 
                    System.out.println("Enter the value greater than 0");
                    scanNum = new Scanner(System.in); //Creating Scanner object for user input from console
                    remainingMinutesPrompt = scanNum.nextInt(); //Getting number from console user input
                    break;
                case 1: 
                    System.out.println("Insufficient credit. Please, enter the desired number of minutes to top up");
                    scanNum = new Scanner(System.in);
                    remainingMinutesPrompt = scanNum.nextInt(); 
                    break;
                case 2: 
                    System.out.println("Please, enter correct value");
                    scanNum = new Scanner(System.in);
                    remainingMinutesPrompt = scanNum.nextInt(); 
                    break;
            }
            if(remainingMinutesPrompt > 0) //If user topped up the credit, we add those remaining minutes to the main remainingMinutes variable
            {
                remainingMinutes += remainingMinutesPrompt;
            }
            else //If not, we have a recursive call of this function with an errorCode value equal to 0  
            {
                errorPrompt(0);
            }
        }
        catch(Exception e)
        {
            errorPrompt(2); //Here we have a recursive call of this function with an errorCode value equal to 2 
        }
    }
    
    //Method to make a call 
    public void makeAPhoneCall(int phoneNumber, int duration)
    {
        if(remainingMinutes >= duration) //If remaininingMinutes value is bigger than or equal tothe duration of a call, we decrease the remainingMinutes variable by the duration variable and print the phone number and the duration of a call
        {
            remainingMinutes -= duration;
            JOptionPane.showMessageDialog(GadgetShop.frame, "Number: " + phoneNumber + "\nDuration: " + duration + " minute(s)");
        }
        else //If not - we call the errorPrompt function giving a number 1 as na argument's value in a loop, while the remainingMinutes value is less than duration and only then we decrease the remainingMinutes variable by the duration variable and print the phone number and the duration of a call
        {
            while(remainingMinutes < duration)
            {
                errorPrompt(1);
            }
            remainingMinutes -= duration;
            System.out.println("Number: " + phoneNumber + "\nDuration: " + duration + " minute(s)");
        }
    }
    
    //Here we override the display method of the Gadget class
    public void display()
    {
        super.display(); //Here we are calling the display method of the Gadget class
        System.out.println("A number of minutes of calling credit remaining: " + remainingMinutes + "; \n"); //Then we are printing a new line in the console
    }
}
