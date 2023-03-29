package socialmedia;

import java.io.Serializable;

import org.w3c.dom.css.Counter;

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
    BadSocialMedia platform = new BadSocialMedia();
    public int getNoEndorsements(){
        Counter = 0;
        for(Endorsements endorsement : platform.endorsementList){
            if(endorsement.postID == this.postID){
                Counter ++;
            }
        }
        return Counter;
    }
    
    public int getNoComments(){
        Counter = 0;
        for(Comments comment : platform.commentList){
            if(comment.commentPostId == this.postID){
                Counter ++;
            }
        }
        return Counter;
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

        public Comments(){
            
        }

    }




   





