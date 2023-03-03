package socialmedia;
import java.security.PublicKey;
import java.util.ArrayList;

public class Accounts{
    //Class attributes 
    public int ID; // ID will increment from 1 upwards
    public String Handle; // Handle is the name of account
    public String Description; // Description stores a short description of the account

    //Array Lists to be used later
    ArrayList<Integer> accountID = new ArrayList<>();


    //This is the constructor for accounts with only the handle
    public Accounts(String handle){
        this.ID = CreateID();
        this.Handle = handle;

    }
    //This is the constructor for accounts with Handles and descriptions
    public Accounts(String handle, String description){
        this.ID = CreateID();
        this.Handle = handle;
        this.Description = description;
    }


 
    public int CreateID(){
        int currentHighest;
        int ID = 0;
        if(accountID.isEmpty()) { //Checks if the accountID array list is empty and adds the first value if it is 
            accountID.add(1);
            ID = 1;      
        } else {
            currentHighest = accountID.get(accountID.size() -1) + 1;
            ID = currentHighest; 

        }
        return ID;
    }




}