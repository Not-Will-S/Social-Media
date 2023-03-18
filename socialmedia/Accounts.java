package socialmedia;
import java.security.PublicKey;
import java.util.ArrayList;

public class Accounts{
    //Class attributes 
    public int ID; // ID will increment from 1 upwards
    public String Handle; // Handle is the name of account
    public String Description; // Description stores a short description of the account


    //This is the constructor for accounts with only the handle
    public Accounts(String handle){
        //this.ID = CreateID();
        this.Handle = handle;

    }
    //This is the constructor for accounts with Handles and descriptions
    public Accounts(String handle, String description){
        //this.ID = CreateID();
        this.Handle = handle;
        this.Description = description;
    }

    //For deletion later after complete testing
    //This is the constructor for accounts with Handles and descriptions
    public Accounts(String handle, String description, int ID){
        this.ID = ID;
        this.Handle = handle;
        this.Description = description;
    }
    }




