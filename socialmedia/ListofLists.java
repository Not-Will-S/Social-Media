package socialmedia;
import java.io.Serializable;
import java.util.ArrayList;

public class ListofLists implements Serializable {
    private static final long serialVersionUID = 1L;
    public ArrayList<Posts> postsArray;
    public ArrayList<Accounts> accountArray;
    public ArrayList<Comments> commentArray;
    public ArrayList<Endorsements> endorseArray;

    public ListofLists(){
        
    }

    public ListofLists(ArrayList<Posts> postsArray, ArrayList<Accounts> accountArray, ArrayList<Comments> commentArray, ArrayList<Endorsements> endorseArray) {
        this.postsArray = postsArray;
        this.accountArray = accountArray;
        this.commentArray = commentArray;
        this.endorseArray = endorseArray;
    }
}