/* 
 * Gadget is a superclass of MP3 and Mobile classes. All the methods, which names start with "get"
 * are accessors. This class has four parameters: model, price, weight and size. The last method 
 * display is used to print all the values of parameters in the console.
*/




public class Gadget
{
    //In this block of code we have parameters declaration
    private String model;
    private double price;
    private int weight;
    private String size;
    
    //Next block of code is a contructor of the Gadget class
    public Gadget(String model, double price, int weight, String size)
    {
        this.model = model; //I've used "this" keyword to make a distinction between arguments of a constructor and classe's parameters. "This" refers to the current classe's parameter
        this.price = price;
        this.weight = weight;
        this.size = size;
    }
    
    //All the methods lower are accessors 
    public String getModel()
    {
        return model; //Returning variable's value to access it from other classes
    }
    
    public double getPrice()
    {
        return price; 
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public String getSize()
    {
        return size;
    }
    
    //Method display prints all four parameters of an object to the console
    public void display()
    {
        System.out.println("Model: " + model + "; ");
        System.out.println("Price: " + price + "; ");
        System.out.println("Weight: " + weight + "; ");
        System.out.println("Size: " + size + "; ");
    }
}
