package socialmedia;
import java.io.Serializable;
import java.util.ArrayList;

public class ListofLists implements Serializable {
    private static final long serialVersionUID = 1L;
    public ArrayList<Posts> postsArray = new ArrayList<Posts>();
    public ArrayList<Accounts> accountArray = new ArrayList<Accounts>();
    public ArrayList<Comments> commentArray = new ArrayList<Comments>();
    public ArrayList<Endorsements> endorseArray = new ArrayList<Endorsements>();

    public ListofLists(){
        
    }

    public ListofLists(ArrayList<Posts> postsArray, ArrayList<Accounts> accountArray, ArrayList<Comments> commentArray, ArrayList<Endorsements> endorseArray) {
        this.postsArray = postsArray;
        this.accountArray = accountArray;
        this.commentArray = commentArray;
        this.endorseArray = endorseArray;
    }

    
    public ArrayList<Accounts> getAccountList() {
        return this.accountArray;
    }
    
    public ArrayList<Endorsements> getEndorsementList() {
        return this.endorseArray;
    }
    
    public ArrayList<Comments> getCommentList() {
        return this.commentArray;
    }
    
    public ArrayList<Posts> getPostList() {
        return this.postsArray;
    }

   
    








}