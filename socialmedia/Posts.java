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




   





