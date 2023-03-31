package socialmedia;
import java.io.Serializable;

public class Posts implements Serializable{
    public int postID;
    public String postContent; 
    public String AccountHandleLink;
    private static final long serialVersionUID = 1L;

    public Posts(){  
    }

    //Constructor for posts objects 
    public Posts(String postContent, String AccountHandleLink, int AccountIDLink){
        this.postContent = postContent;
        this.AccountHandleLink = AccountHandleLink;

    }  
    public Posts(String postContent){
        this.postContent = postContent;       

    }
    int Counter;
    SocialMedia platform = new SocialMedia();
    public int getNoEndorsements(){ //Finds how many endorsements a post has 
        Counter = 0;
        for(Endorsements endorsement : platform.endorsementList){
            if(endorsement.postID == this.postID){ // loops through ever endorsement relevent to this post object and increments a counter
                Counter ++;
            }
        }
        return Counter; //returns the counter
    }
    
    public int getNoComments(){ //Finds how many comments a post has
        Counter = 0;
        for(Comments comment : platform.commentList){
            if(comment.commentPostId == this.postID){ //loops through every endorsement relevent to this post object and increments a counter
                Counter ++;
            }
        }
        return Counter; //returns the counter
    } 
}    
    class Endorsements extends Posts implements Serializable{
        public int endorsedPostId;
        public String endorseAccHandle;
        public String endorsementBody;

         //Construtor for endorsements Object
        public Endorsements(int endorsedPostId, String endorseAccHandle){
            this.endorsedPostId = endorsedPostId;
            this.endorseAccHandle = endorseAccHandle;     
        }
        //default constructor
        public Endorsements(){

        }
    }

    class Comments extends Posts implements Serializable{
        public int commentId;
        public String commentHandle; 
        public int commentPostId;
        public String commentBody;
        
        //Constructor for comments objects
        public Comments(String commentHandle, int commentPostId, String commentBody){
            this.commentHandle = commentHandle;
            this.commentPostId = commentPostId;
            this.commentBody = commentBody;
        }
        //default constructor
        public Comments(){
            
        }
    }




   





