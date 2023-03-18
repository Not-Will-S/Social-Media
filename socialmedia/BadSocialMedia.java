package socialmedia;
import java.util.ArrayList;
import java.util.Iterator;

import socialmedia.Endorsements.Comments;
import socialmedia.Endorsements.comments;

import java.io.IOException;

/**
 * BadSocialMedia is a minimally compiling, but non-functioning implementor of
 * the SocialMediaPlatform interface.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class BadSocialMedia implements SocialMediaPlatform {
	public ArrayList<Accounts> accountList = new ArrayList<Accounts>();
	public ArrayList<Posts> postList = new ArrayList<Posts>();
	public ArrayList<Endorsements> endorsementList = new ArrayList<Endorsements>();
	public ArrayList<socialmedia.Comments>  commentList = new ArrayList<comments>();

	
	
	


	
	//Getter method so array can be accessed in other classes
	public ArrayList<Accounts> getMyArray(){
		return accountList;
	}

	@Override
	// public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
	// 	// TODO Auto-generated method stub
		
	// 	Accounts account = new Accounts("hand", "Desc");
	// 	account.ID = accountList.size() + 1;	
	// 	//System.out.print("ID = " + account.ID + " Handle = " + account.Handle + " Description = " + account.Description);
	// 	accountList.add(account);
	// 	Accounts account1 = new Accounts("Handle", "Description");
	// 	account1.ID = accountList.size() + 1;
	// 	accountList.add(account1);		
	// 	return 0;
	//}
	public int createAccount(String handle){
		//adds account for testing
		Accounts TestAcc = new Accounts("HandleTest", "DescTest", 1);
		accountList.add(TestAcc);
		//instantiates Accounts to create a new object
		Accounts account = new Accounts(handle);
		//Finds what the next account ID should be by finding the total number of accounts and incrementing it
		account.ID = accountList.size() + 1;
		//adds account object
		accountList.add(account);
		return 0;
	}

	// ********* Need to create a way to make sure all account handles are unique - e.g search ArrayList first and display error
	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		Accounts account = new Accounts(handle, description);
		account.ID = accountList.size() + 1;
		accountList.add(account);
		return 0;
	}

	@Override
	public void removeAccount(int id){// throws AccountIDNotRecognisedException {		
		//removes all accounts where the account id matches the value passed into the function
		accountList.removeIf(Account -> Account.ID == id);
	}

	@Override
	public void removeAccount(String handle) { // throws HandleNotRecognisedException {
	
		//removes all accounts where the account handle matches the value passed into the function
		accountList.removeIf(Account -> Account.Handle == handle);

	}
	

	//************ I've just assumed this works but I dont see why it wouldnt' - needs testing
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle){
			//throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException
		for(Accounts account : accountList){
			if(account.Handle == oldHandle){
				account.Handle = newHandle;
			}
		}
	}


	//**********same as above  */
	@Override
	public void updateAccountDescription(String handle, String description) // throws HandleNotRecognisedException 
	{
		for(Accounts account : accountList){
			if(account.Handle == handle){
				account.Description = description;
			}
		}

	}

	//****** needs testing but should be easy to test */
	@Override
	public String showAccount(String handle) //throws HandleNotRecognisedException 
		{
		for(Accounts account : accountList){
			if(account.Handle == handle){
				System.out.print(" Account ID: " + account.ID +  "/n Account Handle: " + account.Handle + "/n Account Description:" +  account.Description);
			}
		}


	
		return null;
	}

	@Override
	public int createPost(String handle, String message) //throws HandleNotRecognisedException, InvalidPostException 
	{
		Posts post = new Posts(message);
		post.AccountHandleLink = handle;
		for (Accounts account : accountList){
			if(account.Handle == handle){
				post.postID = account.ID;
			}
		}
		post.postID = postList.size() + 1;
		postList.add(post);
		System.out.print("Post ID " + post.postID + "/n post messsage: " + post.postContent + "/n Account Handle: " + post.AccountHandleLink);
		return 0;
	}

	
	String endorseBody;
	@Override
	public int endorsePost(String handle, int id){
			//throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
			
		    Endorsements endorsePost = new Endorsements(id, handle);
			endorsementList.add(endorsePost);
			for (Posts post : postList){
				if(post.postID == id){
					endorseBody = "EP@" + handle + ": " + post.postContent;
				}
			}
		return 0;
	}

	@Override
	public int commentPost(String handle, int id, String message){ //throws HandleNotRecognisedException,
			//PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
			Comments comment = new Comments(handle, id, message);
			comment.commentId = commentList.size() + 1;
			
		return 0;
	}
 
	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalOriginalPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCommentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedPost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void erasePlatform() {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

}
