package socialmedia;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.IOException;
import java.io.*;
import java.io.FileNotFoundException;

//public class BadSocialMedia implements SocialMediaPlatform {
  public class BadSocialMedia implements SocialMediaPlatform, Serializable {
	public ArrayList<Accounts> accountList = new ArrayList<Accounts>(); //accountList will store account objects
	public ArrayList<Posts> postList = new ArrayList<Posts>(); // postList will store post objects
	public ArrayList<Endorsements> endorsementList = new ArrayList<Endorsements>(); // endorsementList will store endorsement objects
	public ArrayList<Comments>  commentList = new ArrayList<Comments>(); // commentList will store comment objects


	//getter method so array can be accessed in other classes
	public ArrayList<Accounts> getMyArray(){
		return accountList;
	}

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException{
		//checks if handle is free
		for (Accounts account : accountList) {
			if (account.getHandle().equals(handle)) {
				// gives exception if handle is reocgnised 
				throw new IllegalHandleException("The handle '" + handle + "' is taken");
			}
		}
		// gives exception if handle does not meet requirements
		if (handle.trim().isEmpty()) {
			throw new InvalidHandleException("The handle cannot be empty");
		} else if (handle.length() > 30) {
			throw new InvalidHandleException("The handle cannot exceed 30 characters");
		} else if (handle.contains(" ")) {
			throw new InvalidHandleException("The handle cannot contain white spaces");
		}
		//instantiates Accounts to create a new object
		Accounts account = new Accounts(handle);
		//finds next account ID should be by finding the total number of accounts and incrementing it
		account.ID = accountList.size() + 1;
		//adds account object
		accountList.add(account);
		return 0;
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		//checks to see if account Handle is free or not
		for (Accounts account : accountList) {
			if (account.getHandle().equals(handle)) { 
				throw new IllegalHandleException("The handle '" + handle + "' is taken");
			}
		}
		if (handle.trim().isEmpty()) {
			throw new InvalidHandleException("The handle cannot be empty");
		} else if (handle.length() > 30) {
			throw new InvalidHandleException("The handle cannot exceed 30 characters");
		} else if (handle.contains(" ")) {
			throw new InvalidHandleException("The handle cannot contain white spaces");
		}
		//instantiates Accounts to create a new object with a description
		Accounts account = new Accounts(handle, description);
		account.ID = accountList.size() + 1;
		accountList.add(account);
		return 0;
		}
		
	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {		
		//removes all accounts where account id matches the value passed into the function
		for (Accounts account : accountList) {
			if (Integer.valueOf(account.getId()).equals(id)) {
				accountList.remove(account);
				return;
			}
		}
		throw new AccountIDNotRecognisedException("The Id'" + id + "'was not recognised");
	}

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		//removes all accounts where account handle matches the value passed into the function
		for (Accounts account : accountList) {
			if (account.getHandle().equals(handle)) {
				accountList.remove(account);
				return;
			}
		}

		//Removes all endorsements associalted with the main account
		ArrayList<Endorsements> endorseRemove = new ArrayList<Endorsements>(); // Creates an arrayList storing the endorsements to be removed
			for(Endorsements endorsement : endorsementList){ 
				if(endorsement.AccountHandleLink == handle){ //Checks through every endorsement and only finds the ones relevant to the account being removed
					endorseRemove.add(endorsement);					
				}
			}
			for(Endorsements eR : endorseRemove){//Removes every endorsement associated with the account
				endorsementList.remove(eR);
			}

		//Removes every comment associated with the removed account
		ArrayList<Comments> commentRemove = new ArrayList<Comments>(); //creates an array to store comments ready to be removed
			for(Comments comment : commentList){
				if(comment.commentHandle == handle){ //only finds the relevant comments 
					commentRemove.add(comment);				
				}
			}
			for(Comments cR : commentRemove){ // removes every comment associated with the account
					cR.commentPostId = 0;
					cR.AccountHandleLink = "";
			}
		throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
	}
	
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle) throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		Accounts matchingAccount = null;
		for (Accounts account : accountList){
			if (account.getHandle().equals(oldHandle)) {
				//indicates that handle entered has been recognised
				matchingAccount = account;
				break;
			}
		}
		//throws exception if no matching account found
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + oldHandle + "' was not recognised");
		}
		for (Accounts account : accountList) {
			if (account.getHandle().equals(newHandle)) {
				throw new IllegalHandleException("The handle '" + newHandle + "' is taken");
			}
		}
		if (newHandle.trim().isEmpty()) {
			throw new InvalidHandleException("The handle cannot be empty");
		} else if (newHandle.length() > 30) {
			throw new InvalidHandleException("The handle cannot exceed 30 characters");
		} else if (newHandle.contains(" ")) {
			throw new InvalidHandleException("The handle cannot contain white spaces");
		}
		//sets old handle to new handle
		matchingAccount.Handle = newHandle;
	}
	
	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		//searches the accountList until an account matching the handle is found
		for(Accounts account : accountList){ 
			if(account.Handle == handle){
				//changes description if handle recognised
				account.Description = description;
				return;
			}
		}
		throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		//intialises matchingAccount to null
		Accounts matchingAccount = null;
		//loops through each account and display account details if found
		for(Accounts account : accountList){
			if (account.getHandle().equals(handle)) { 
				matchingAccount = account;
				//displays a string detailing the entire account
				System.out.print("\nID: " + account.ID +  "\nHandle: " + account.Handle + "\nDescription: " +  account.Description + "\n");
			}
		}
		//throws exception if no handle recognised
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
		}
		return null;
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		Accounts matchingAccount = null;
		//creates new post object with given message
		Posts post = new Posts(message);
		//assigns account handle to post object
		post.AccountHandleLink = handle;
		for (Accounts account : accountList){
			if(account.getHandle().equals(handle)){
				if (message.trim().isEmpty()) {
					throw new InvalidPostException("The message cannot be empty");
				} else if (message.length() > 100) {
					throw new InvalidPostException("The message cannot exceed 100 characters");
				}
				matchingAccount = account;
				post.postID = account.ID;
				post.postID = postList.size() + 1;
				//adds post to postList if handle matches with an account
				postList.add(post);				
			}
		}
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
		}
		return 0;
	}

	@Override
	public int endorsePost(String handle, int id) throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		foundFlag = false;
		Accounts matchingAccount = null;
		for (Accounts account : accountList){
			//checks if the handle is valid
			if(account.getHandle().equals(handle)){
				matchingAccount = account;
				//creates an endorsement post
				Endorsements endorsePost = new Endorsements(id, handle);
				endorsementList.add(endorsePost);
				String endorsedHandle = null; 
				//finds the post being endorsed by ID
				for (Posts post : postList){
					if(post.postID == id){
						foundFlag = true;
						//checks if the post is an endorsement post
						if (post instanceof Endorsements) {
							throw new NotActionablePostException("Cannot endorse an endorsement post");
						}
						//assigns the handle of the account being endorsed
						endorsedHandle = post.AccountHandleLink; 
						endorsePost.endorsementBody = "\nEP@" + endorsedHandle + ": " + post.postContent;						
					}
				}
				if(foundFlag == false){
						throw new PostIDNotRecognisedException("The post ID '" + id + "' was not recognised");
				}					
			}
		}		
			
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
		}	
		return 0; 
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		for (Accounts account : accountList) {
			if (account.getHandle().equals(handle)) {				
				//searches for post that matches ID provided
				for (Posts post : postList) {
					if (post.postID == id) {
						//checks if post is endorsement post or longer than 100 characters
						if (post instanceof Endorsements) {
							throw new NotActionablePostException("Cannot endorse an endorsement post");
						} else if (message.length() > 100) {
							throw new InvalidPostException("Cannot exceed 100 characters");
						}
						//creates a new comment and adds it to comment list
						Comments comment = new Comments(handle, id, message);
						comment.commentId = commentList.size() + 1;
						commentList.add(comment);
						comment.commentBody = "\nComment of PostID " + id + ": " + message;						
						return 0;
					}
				}
				//throws exception if no post is found with ID provided
				throw new PostIDNotRecognisedException("The post ID '" + id + "' was not recognised");
			}
		}
		//throws exception if not account found with handle provided
		throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");			
	}

	boolean foundFlag = false;
	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		//checks through list of all the posts and removes posts where postID is equal to id fed into the function
		Posts postRemove = new Posts();
		for (Posts post : postList){
			if(post.postID == id){
				
				postRemove =post;		
				foundFlag = true;	//Sets foundFlag to true, meaning an account matching the input ID was found
			} 
		}		
			if(foundFlag == false){ // Checks if an account was found or not 
				throw new PostIDNotRecognisedException("The post ID '" + id + "' was not recognised");
			}			
			postList.remove(postRemove);// removes the targeted post
			
			//removes all endorsements related to the removed post
			ArrayList<Endorsements> endorseRemove = new ArrayList<Endorsements>(); //Creates an arrayList storing the endorsements that have to be removed  
			for(Endorsements endorsement : endorsementList){ 
				if(endorsement.endorsedPostId == id){
					endorseRemove.add(endorsement);	//checks to see if the endorsed post is related to the removed post and adds it to arrayList	
				}
			}
			for(Endorsements eR : endorseRemove){
				endorsementList.remove(eR); // removes every endorsement related to removed post
			}
			

			//Removes the comments that are related to the targeted post
			ArrayList<Comments> commentRemove = new ArrayList<Comments>(); //Creates an arrayList storing the comments to be removed 
			for(Comments comment : commentList){ 
				if(comment.commentPostId == id){ // checks to see if the comment is related to the removed post
					commentRemove.add(comment);	//sets the comment to be removed later		
				}
			}
			for(Comments cR : commentRemove){ //removes all references to the account but leaves the comment message
					cR.commentPostId = 0;
					cR.AccountHandleLink = "";
			}
	
		
	}
	
	int postEndorseNo;
	int postCommentsNo;
	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		foundFlag = false;
		for(Endorsements endorse : endorsementList){ //checks how many endorsements the post has and stores in variable
			if(endorse.endorsedPostId == id)
			postEndorseNo ++;
		}
		for(Comments comment : commentList){ //checks how many comments the post has and stores in variable
			if(comment.commentPostId == id){
				postCommentsNo ++;
			}
		}
		for(Posts post : postList){ //finds the postID and then displays the full formatted message 
			if(post.postID == id){
				foundFlag = true;
				System.out.print("ID:" + post.postID + "\nAccount: " + post.AccountHandleLink + "\nNo. Endorsements: " + postEndorseNo + " | No. Comments: " + postCommentsNo + "\n" + post.postContent);
			} 
			if(foundFlag == false){
					throw new PostIDNotRecognisedException("The post ID '" + id + "' was not recognised");
			}			
		}
		return null;
	}
				
	@Override
	public StringBuilder showPostChildrenDetails(int id) throws PostIDNotRecognisedException, NotActionablePostException {	
		StringBuilder sb = new StringBuilder();
		int errorSave = 0;
		if(errorSave < 1){
			throw new PostIDNotRecognisedException();
		}
		
		if(errorSave > 1){
			throw new NotActionablePostException("N/A");
		}
		
		return sb;
				
	}

	@Override
	public int getNumberOfAccounts() {
		return accountList.size(); //Returns number of accounts
	}

	@Override
	public int getTotalOriginalPosts() {
		
		return postList.size(); //Returns number of posts
	}

	@Override
	public int getTotalEndorsmentPosts() {
		return endorsementList.size(); //returns number endorsements
	}

	@Override
	public int getTotalCommentPosts() {
		return commentList.size(); //returns number of comments 
	}

	int currentHighest;
	int tempHighest;
	int postIdHigh;
	@Override
	public int getMostEndorsedPost() {
		for(Posts post : postList){
			for(Endorsements endorsement : endorsementList){ //For every post checks through ever endorsement 
				if(endorsement.endorsedPostId == post.postID){ //checks to see if the endorsed post is relevent 
					tempHighest = tempHighest + 1; //increments the counter for the curent post only
				}
				if(tempHighest > currentHighest){ //checks if the endorsement counter for the current post is higher than the total highest
					currentHighest = tempHighest; 
					postIdHigh = post.postID; //changes the id of the most endorsed post to the new highest one
				}
			}
			tempHighest = 0;			
		}
		return  postIdHigh;
	}

	int mostEndorsedAccountId;
	int mostEndorsedCount;
	int highEndorsed;
	@Override
	public int getMostEndorsedAccount() {
		//for every account get a list of every post made by that account
		//for every post get a list of every endorsement made relevant to the post and store it in a counter
		//compare after
		for(Accounts account : accountList){ //loops through every account
			for(Posts post : postList){//Loops through every post for every account
				if(post.AccountHandleLink == account.Handle){ //Checks that the post is relevant to the account of the current loop
					for(Endorsements endorsement : endorsementList){ //loops through every endorsement 
						if(endorsement.endorsedPostId == post.postID){ //checks the endorsements to make sure they are for the specific post 
							mostEndorsedCount = mostEndorsedCount + 1; //increments the counter for the specific post
						}
						if(mostEndorsedCount > highEndorsed){
							highEndorsed = mostEndorsedCount;
							mostEndorsedAccountId = account.ID;
						}
					}
				}		
			}
			mostEndorsedCount = 0;
		}

		return mostEndorsedAccountId;
	}

	@Override
	public void erasePlatform() { //clears all the data on the platform
		accountList.clear();
		postList.clear();
		commentList.clear();
		endorsementList.clear();
	}

	@Override
	public void savePlatform(String filename)
		{
		ListofLists largeList = new ListofLists(postList, accountList, commentList, endorsementList); //Creates a list object that will store all the arrayLists 
		try{
		FileOutputStream fileOut = new FileOutputStream(filename + ".ser"); //creates the output streams
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(largeList); //writes the largeList object to the serialized file
         
		// Close the output streams
		out.close();
		fileOut.close();
		}
		catch(FileNotFoundException e){
			System.out.print("Invalid filename provided");
		}
		catch(IOException e){
			System.out.print("IO error");
		}
			
	}

	String hold;
	@Override
	 public void loadPlatform(String filename)
	{
	try {
		FileInputStream fileIn = new FileInputStream(filename + ".ser"); //Creates the input Streams 
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	
		ListofLists listOfLists = (ListofLists) objectIn.readObject(); // fills the listofLists object with the serialized data
	
		objectIn.close(); //closes the input streams
		fileIn.close();
	
		accountList = listOfLists.getAccountList(); //fills all the data arrayLists with the deserialised data
		endorsementList = listOfLists.getEndorsementList();
		commentList = listOfLists.getCommentList();
		postList = listOfLists.getPostList();
	
	} catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
	}
  	}	
}
