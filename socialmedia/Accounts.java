package socialmedia;
import java.security.PublicKey;
import java.util.ArrayList;

public class Accounts{
    //Class attributes 
    public int ID; // ID will increment from 1 upwards
    public String Handle; // Handle is the name of account
    public String Description; // Description stores a short description of the account

    //Array Lists to be used later
    //ArrayList<Accounts> accountList = new ArrayList<>();


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

    // for Deletion
    //This is the constructor for accounts with Handles and descriptions
    public Accounts(String handle, String description, int ID){
        this.ID = ID;
        this.Handle = handle;
        this.Description = description;
    }
    // public int CreateID(){
    //     int ID = 0;
    //     int size = 0;
    //     BadSocialMedia account = new BadSocialMedia();
    //     System.out.print("Account size at initialization is: " + account.accountList.size());
    //     if(account.accountList.size() == 0) { //Checks if the accountID array list is empty and adds the first value if it is 
    //         ID = 1;      
    //     } else {
    //         size = account.accountList.size() + 2;          
    //         ID = size; 

    //     }
    //     return ID;
    }




