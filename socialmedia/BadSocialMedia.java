package socialmedia;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.IOException;
import java.io.*;
import java.io.FileNotFoundException;
/**
 * BadSocialMedia is a minimally compiling, but non-functioning implementor of
 * the SocialMediaPlatform interface.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
//public class BadSocialMedia implements SocialMediaPlatform {
  public class BadSocialMedia implements SocialMediaPlatform, Serializable {
	public ArrayList<Accounts> accountList = new ArrayList<Accounts>();
	public ArrayList<Posts> postList = new ArrayList<Posts>();
	public ArrayList<Endorsements> endorsementList = new ArrayList<Endorsements>();
	public ArrayList<Comments>  commentList = new ArrayList<Comments>();


	//getter method so array can be accessed in other classes
	public ArrayList<Accounts> getMyArray(){
		return accountList;
	}

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException{
		//adds account for testing
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
		//finds what the next account ID should be by finding the total number of accounts and incrementing it
		account.ID = accountList.size() + 1;
		//adds account object
		accountList.add(account);
		return 0;
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
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
		//removes all accounts where the account id matches the value passed into the function
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
		//removes all accounts where the account handle matches the value passed into the function
		for (Accounts account : accountList) {
			if (account.getHandle().equals(handle)) {
				accountList.remove(account);
				return;
			}
		}
		throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
	}
	
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle) throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		Accounts matchingAccount = null;
		for (Accounts account : accountList){
			if (account.getHandle().equals(oldHandle)) {
				//indicates that the handle entered has been recognised
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
		for(Accounts account : accountList){ //searches the accountList until an account matching the handle is found
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
				//prints post ID, account handle, and post content
				System.out.println("ID: " + post.postID + "\nAccount: " + post.AccountHandleLink + "\n" + post.postContent + "\n");
			}
		}
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
		}
		return 0;
	}

	//**notactionableexception does not work as endorse post does not add to post list 
	@Override
	public int endorsePost(String handle, int id) throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
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
						//checks if the post is an endorsement post
						if (post instanceof Endorsements) {
							throw new NotActionablePostException("Cannot endorse an endorsement post");
						}
						//assigns the handle of the account being endorsed
						endorsedHandle = post.AccountHandleLink; 
						endorsePost.endorsementBody = "\nEP@" + endorsedHandle + ": " + post.postContent;
						System.out.println("\nAccount: " + handle + endorsePost.endorsementBody);
					} else {
						throw new PostIDNotRecognisedException("The post ID '" + id + "' was not recognised");
					}
				}
			}		
		}	
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + handle + "' was not recognised");
		}	
		return 0; 
	}

	//still working on
	@Override
	public int commentPost(String handle, int id, String message){ //throws HandleNotRecognisedException,
			//PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
			Accounts matchingAccount = null;
			Comments comment = new Comments(handle, id, message);		
			comment.commentId = commentList.size() + 1;
			commentList.add(comment);	
			comment.commentBody = "\nComment of PostID " + id + ": " + message;
			System.out.println("\nAccount: " + handle + comment.commentBody); 
		return 0;
	}
 
	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		for (Posts post : postList){ //Checks through a list of all the posts and removes posts where the postID is equal to the id fed into the function
			if(post.postID == id){
				postList.remove(post);			
			}
		}
		for(Endorsements endorsement : endorsementList){ // removes all endorsements related to the removed post
			if(endorsement.postID == id){
				endorsementList.remove(endorsement);
			}
		}
		//Need to create logic for changing comments to default message but ionwanna cos it sounds hard - do later		
	}
	
	
	int postEndorseNo;
	int postCommentsNo;
	@Override
	public String showIndividualPost(int id) //throws PostIDNotRecognisedException 
	{
		for(Endorsements endorse : endorsementList){ //checks how many endorsements the post has and stores in variable
			if(endorse.endorsedPostId == id)
			postEndorseNo ++;
		}

		for(Comments comment : commentList){ // checks how many comments the post has and stores in variable
			if(comment.commentPostId == id){
				postCommentsNo ++;
			}
		}

		for(Posts post : postList){ // Finds the postID and then displays the full formatted message 
			if(post.postID == id){
				System.out.print("ID:" + post.postID + "\nAccount: " + post.AccountHandleLink + "\nNo. Endorsements: " + postEndorseNo + "\nNo. Comments: " + postCommentsNo + "\n" + post.postContent);
			}
		}




		return null;
	}
		private static void appendCommentsRecursive(int postID, ArrayList<Comments> CommentsList, StringBuilder sb, int indentLevel) {
			if (CommentsList.isEmpty()) {
				return;
			}
		
		
			// Find all comments made on the post
		ArrayList<Comments> comments = new ArrayList<>();
		for (Comments c : CommentsList) {
			if (c.commentPostId == postID) {
				comments.add(c);
			}
		}
	
		// Sort comments by timestamp (or some other criteria)
		// Collections.sort(comments, new Comparator<Comment>() {
		// 	@Override
		// 	public int compare(Comment c1, Comment c2) {
		// 		return c1.getTimestamp().compareTo(c2.getTimestamp());
		// 	}
		// });
	
		// Append each comment to the StringBuilder with proper indentation
		for (Comments c : comments) {
			for (int i = 0; i < indentLevel; i++) {
				sb.append("\t");
			}
			sb.append(c.toString());
			sb.append("\n");
	
			// Recursively append all comments made on this comment
			appendCommentsRecursive(c.commentPostId, CommentsList, sb, indentLevel + 1);
		}
		}
	@Override
	public StringBuilder showPostChildrenDetails(int id)//throws PostIDNotRecognisedException, NotActionablePostException {
	{
		   // Find the post with the specified postID
		   Posts post = null;
		   for (Posts p : postList) {
			   if (p.postID == id) {
				   post = p;
				   break;
			   }
		   }
		   if (post == null) {
			   System.out.print("post not found");
		   }
	   
		   // Create a StringBuilder to store the formatted post and comments
		   StringBuilder sb = new StringBuilder();
	   
		   // Append the post to the StringBuilder
		   sb.append(post.toString());
		   sb.append("\n");
	   
		   // Recursively append all comments made on the post
		   appendCommentsRecursive(id, commentList, sb, 1);
	   
		   return sb;		
	}

	@Override
	public int getNumberOfAccounts() {
		return accountList.size();
	}

	@Override
	public int getTotalOriginalPosts() {
		
		return postList.size();
	}

	@Override
	public int getTotalEndorsmentPosts() {
		return endorsementList.size();
	}

	@Override
	public int getTotalCommentPosts() {
		return commentList.size();
	}

	int currentHighest;
	int tempHighest;
	int postIdHigh;
	@Override
	public int getMostEndorsedPost() {
		for(Posts post : postList){
			for(Endorsements endorsement : endorsementList){
				if(endorsement.postID == post.postID){
					tempHighest = tempHighest + 1;
				}
				if(tempHighest > currentHighest){
					currentHighest = tempHighest;
					postIdHigh = post.postID;
				}
			}
			tempHighest = 0;
		}
		return postIdHigh;
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
						if(endorsement.postID == post.postID){ //checks the endorsements to make sure they are for the specific post 
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
	public void erasePlatform() {
		accountList.clear();
		postList.clear();
		commentList.clear();
		endorsementList.clear();
	}

	@Override
	public void savePlatform(String filename) //throws IOException {
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
	 public void loadPlatform(String filename) //throws IOException, ClassNotFoundException {
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
