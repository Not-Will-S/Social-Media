package socialmedia;
import java.io.Serializable;
public class Accounts implements Serializable{
    //Class attributes 
    public int ID; // ID will increment from 1 upwards
    public String Handle; // Handle is the name of account
    public String Description; // Description stores a short description of the account
    private static final long serialVersionUID = 1L;


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

    public String getHandle() {
        return Handle;
    }

    public int getId() {
        return ID;
    }
    }




