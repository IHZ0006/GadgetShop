import java.awt.*; //Importing the GUI library for layout
import java.awt.event.*; //Importing library for the GUI events
import javax.swing.*; //Importing main GUI library
import java.util.ArrayList; //Importing the ArrayList class 

/* This is a GadgetShop class, which is used to create GUI, implement user interaction with it, so clicking 
 * each button would call one of the Gadget subclasse's methods, taking field as a parameters. It has four methods: createFrame, clear, displayAll and actionPerformed(it's a method of ActionListener and we've overriden it)
*/
public class GadgetShop implements ActionListener //ActionListener is an interface, which we use for the actionPerformed method
{
    //Creating two separate ArrayLists, one for the instances of the Mobile class, another - of the MP3 class
    ArrayList <Mobile> allMobiles= new ArrayList <>();
    ArrayList <MP3> allMP3 = new ArrayList <>();
    
    public static JFrame frame; //Creating a variable of the JFrame class type. Reference is public, because we use it in other classe's for showMessageDialog and showInputDialog. Keyword static means that this is the only copy of the variable for the entire class and creating new instances doesn't create new copies, so when we pass it as an argument, we know which copy is it exactly
    
    //In the next two blocks of code we are creating all the JtextField and JButton variables, so they will be accessile in each part of the GadgetShop class
    private JTextField model;
    private JTextField price;
    private JTextField weight;
    private JTextField size;
    private JTextField credit;
    private JTextField memory;
    private JTextField phoneNo;
    private JTextField duration;
    private JTextField download;
    private JTextField trackName;
    private JTextField displayNumber;
    
    private JButton mobileButton;
    private JButton mp3Button;
    private JButton clearButton;
    private JButton displayButton;
    private JButton callButton;
    private JButton downloadButton;
    private JButton deleteButton;
    
    //Constructor
    public GadgetShop()
    {
        createFrame(); //When the object of the GadgetShop class is initialised, it is calling the createFrame method
    }
    
    //createFrame method, which is called in the constructor and creates our GUI window
    private void createFrame()
    {
        frame = new JFrame("GadgetShop"); //Creating new JFrame object and assigning it to the frame variable
        frame.setLayout(new GridLayout(26,2)); //Setting frame's layout, creating 26 rows and 2 columns
        
        Container content = frame.getContentPane(); //Here we are getting reference to frame's Container object, that stores all the content of our GUI 
        
        //Creating JLabel and JTextField objects for text fields and text over them and assigning them to variables
        JLabel modelLabel = new JLabel("Model:");
        model = new JTextField();
        
        JLabel priceLabel = new JLabel("Price:");
        price = new JTextField();
        
        JLabel weightLabel = new JLabel("Weight:");
        weight = new JTextField();
        
        JLabel sizeLabel = new JLabel("Size:");
        size = new JTextField();
        
        JLabel creditLabel = new JLabel("Credit:");
        credit = new JTextField();
        
        JLabel memoryLabel = new JLabel("Memory:");
        memory = new JTextField();
        
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNo = new JTextField();
        
        JLabel durationLabel = new JLabel("Duration:");
        duration = new JTextField();
        
        JLabel downloadLabel = new JLabel("Download:");
        download = new JTextField();
        
        JLabel trackNameLabel = new JLabel("Track Name:");
        trackName = new JTextField();
        
        JLabel displayNumberLabel = new JLabel("Display Number:");
        displayNumber = new JTextField();
        
        //Creating Jbutton objects for buttons, assigning them to variables and using addActionListener method on them, passing themselves as a parameter, so we would know when the user clicked on them
        mobileButton = new JButton("Add Mobile");
        mobileButton.addActionListener(this);
        
        mp3Button = new JButton("Add MP3");
        mp3Button.addActionListener(this);
        
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        
        displayButton = new JButton("Display All");
        displayButton.addActionListener(this);
        
        callButton = new JButton("Make A Call");
        callButton.addActionListener(this);
        
        downloadButton = new JButton("Download Music");
        downloadButton.addActionListener(this);
        
        deleteButton = new JButton("Delete Music");
        deleteButton.addActionListener(this);
        
        //Adding each element to the Container, which we've got by calling getContentPane method
        content.add(modelLabel);
        content.add(model);
        content.add(priceLabel);
        content.add(price);
        content.add(weightLabel);
        content.add(weight);
        content.add(sizeLabel);
        content.add(size);
        content.add(creditLabel);
        content.add(credit);
        content.add(memoryLabel);
        content.add(memory);
        content.add(mobileButton);
        content.add(mp3Button);
        content.add(clearButton);
        content.add(displayButton);
        content.add(phoneNoLabel);
        content.add(phoneNo);
        content.add(durationLabel);
        content.add(duration);
        content.add(downloadLabel);
        content.add(download);
        content.add(trackNameLabel);
        content.add(trackName);
        content.add(displayNumberLabel);
        content.add(displayNumber);
        content.add(callButton);
        content.add(downloadButton);
        content.add(deleteButton);
        
        
        frame.pack(); //Here we are creating grafical window with all the elements
        frame.setVisible(true); //And making it visible
    }
    
    //Method to replace all the text fields with empty strings
    private void clear()
    {
        model.setText("");
        price.setText("");
        weight.setText("");
        size.setText("");
        credit.setText("");
        memory.setText("");
        phoneNo.setText("");
        duration.setText("");
        download.setText("");
        trackName.setText("");
        displayNumber.setText("");
        model.setText("");
    }
    
    //Method to print all MP3s and mobiles with all their parameters to the console 
    private void displayAll()
    {
        System.out.println("All Mobile Phones: \n");
        for(Mobile i: allMobiles) //For each mobile object in allMobiles ArrayList we call its display method
        {
            i.display();
        }
        System.out.println("All MP3 players: \n");
        for(MP3 i: allMP3) //For each MP3 object in allMP3 ArrayList we call its display method
        {
            i.display();
        }
    }
    
    //Here we override actionPerformed method of the ActionListener interface to make the UI interactive
    public void actionPerformed(ActionEvent event)
    {
        String buttonType = event.getActionCommand(); //getActionCommand method basically gives us the string which we've passed as a parameter of a button that the user clicked in this case
        
        switch (buttonType) //We use switch statement on the buttonType value to compare it with values that go after the case operator. Each time after the user clicked on any of the buttons, we check which button he clicked on exactly. 
        {
            case "Add Mobile"://Block of code to add a Mobile type object to the allMobiles ArrayList 
                try{ //Instead of writing methods to get values from each field, I've decided that it would be better to use methods getting and converting values from the text fields right inside the block of code, where we pass parameters of an object. If values in text fields will be incorrect, then java will throw an error, that's why we use try/catch statement
                    allMobiles.add(new Mobile(Integer.parseInt(credit.getText()), model.getText(), Double.parseDouble(price.getText()), Integer.parseInt(weight.getText()), size.getText())); //Here we are trying to add a new Mobile object to the ArrayList
                    JOptionPane.showMessageDialog(frame, "You've successfuly added a mobile phone");//If previous line won't throw an error, than this line will work. Otherwise java will just quit the try block and will go to the catch block before reaching this line 
                    clear(); //Using the clear method to empty all the text fields
                } 
                catch(Exception e) //In case of java throwing an error, we'll understand that one or more values weren't entered or were entered incorrectly and we'll tell the user about that 
                {
                   JOptionPane.showMessageDialog(frame, "Please, enter all the values that are needed in a correct format!");
                } 
                break;
            case "Add MP3": //Same as case "Add Mobile", but with MP3 objects and allMP3 ArrayList
                try{
                    allMP3.add(new MP3(Integer.parseInt(memory.getText()), model.getText(), Double.parseDouble(price.getText()), Integer.parseInt(weight.getText()), size.getText()));
                    JOptionPane.showMessageDialog(frame, "You've successfuly added an MP3 player");
                    clear();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(frame, "Please, enter all the values that are needed in a correct format!");
                }
                break;
            case "Clear": clear(); break; //Calling the clear method if the "Clear" button is clicked
            case "Display All": displayAll(); break; //Calling the displayAll method if the "Display All" button is clicked
            case "Make A Call": //If user clicks the button "Make A Call", we are trying to get a mobile from the ArrayList and then call its makeAPhoneCall method 
                try{ //If java will throw a NumberFormatException error after trying to call get or makeAPhoneCall methods, than the user typed something in the incorect format or/and left the field(s) empty. If it will throw the IndexOutOfBoundsException after trying to call the get method, then there is no such index in the ArrayList
                    Thread callAction = new callThread(); //Creating new callThread object
                    callAction.start(); //Creating new thread by using start method
                    callAction.join(); //Main thread would wait for the callAction thread to end, so user wouldn't be able to call any methods that require console input
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(frame, "Please, enter all the values that are needed in a correct format!");
                }
                catch(IndexOutOfBoundsException e)
                {
                    JOptionPane.showMessageDialog(frame, "Mobile phone not found");
                }
                catch(InterruptedException e) // we need this block becase java makes you handle interuption exception, if you use join method
                {

                }
                break;
            case "Download Music": //If user clicks the button "Download Music", we are trying to get an MP3 from the ArrayList and then call its download method 
                try{// try/catch statements work the same as with "Make A Call" button block
                   MP3 current = allMP3.get(Integer.parseInt(displayNumber.getText()));
                   boolean checkDownload = current.download(trackName.getText(), Double.parseDouble(download.getText())); //The download method returns boolean value. If our download was successful, than it returns true, otherwise - false
                   if(checkDownload == true) //We check whether the download was successful, if it was, we notify the user and show him the amount of space left
                   {
                       JOptionPane.showMessageDialog(frame, "You've successfuly downloaded music. Remaining memory: " + current.getMemory());
                   }
                   clear();
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(frame, "Please, enter all the values that are needed in a correct format!");
                }
                catch(IndexOutOfBoundsException e)
                {
                    JOptionPane.showMessageDialog(frame, "MP3 player not found");
                }
                break;
            case "Delete Music": //This one works the same as "Download Music", but calls the delete method and instead of checking remaining memory, we actually check if the track's name exist in the HashMap of the MP3 class. There is a try/catch block for that inside the delete method
                try{
                   MP3 current = allMP3.get(Integer.parseInt(displayNumber.getText()));
                   boolean checkTrackAvailability = current.delete(trackName.getText());
                   if(checkTrackAvailability == true)
                   {
                       JOptionPane.showMessageDialog(frame, "You've successfuly deleted music. Remaining memory: " + current.getMemory());
                   }
                   clear();
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(frame, "Please, enter all the values that are needed in a correct format!");
                }
                catch(IndexOutOfBoundsException e)
                {
                    JOptionPane.showMessageDialog(frame, "MP3 player not found");
                }
                break;
        }  
    }
    public class callThread extends Thread //creating callThread class for overriding run method of a Thread class
    {
        public void run() //method overriding
        {
            Mobile current = allMobiles.get(Integer.parseInt(displayNumber.getText())); //getting Mobile from ArrayList
            current.makeAPhoneCall(Integer.parseInt(phoneNo.getText()), Integer.parseInt(duration.getText())); //Making a call
            System.out.println("You've successfuly made a call. Remaining calling minutes: " + current.getRemainingMinutes()); 
            clear();
        }
    }
}
