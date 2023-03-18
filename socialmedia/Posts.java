package socialmedia;
public class Posts {
    public int postID;
    public String postContent; 
    public String AccountHandleLink;

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
    class Endorsements extends Posts{
        public int endorsedPostId;
        public String endorseAccHandle;
        public String endorsementBody;

         //Construtor for endorsements Object
        public Endorsements(int endorsedPostId, String endorseAccHandle){
            this.endorsedPostId = endorsedPostId;
            this.endorseAccHandle = endorseAccHandle;
        
        }
    }

    class Comments extends Posts{
        public int commentId;
        public String commentPostHandle; 
        public int commentPostId;
        public String commentBody;
        
        //Constructor for comments objects
        public Comments(String commentPostHandle, int commentPostId, String commentBody){
            this.commentPostHandle = commentPostHandle;
            this.commentPostId = commentPostId;
            this.commentBody = commentBody;
        }

        public Comments(){
            
        }

    }




   





