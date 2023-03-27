package socialmedia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
  public class BadSocialMedia implements SocialMediaPlatform {
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
		Accounts TestAcc = new Accounts("HandleTest", "DescTest", 1);
		accountList.add(TestAcc);
		
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
		throw new AccountIDNotRecognisedException("The Id'" + id + "'is not recognised");
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
		throw new HandleNotRecognisedException("The handle '" + handle + "' is not recognised");
	}
	
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle) throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		Accounts matchingAccount = null;
		for (Accounts account : accountList) {
			if (account.getHandle().equals(oldHandle)) {
				matchingAccount = account;
				break;
			}
		}
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + oldHandle + "' is not recognised");
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
		matchingAccount.Handle = newHandle;
	}
	
	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		for(Accounts account : accountList){
			if(account.Handle == handle){
				account.Description = description;
				return;
			}
		}
		throw new HandleNotRecognisedException("The handle '" + handle + "' is not recognised");
	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		Accounts matchingAccount = null;
		for(Accounts account : accountList){
			if (account.getHandle().equals(handle)) {
				matchingAccount = account;
				System.out.print("\nID: " + account.ID +  "\nHandle: " + account.Handle + "\nDescription: " +  account.Description + "\n");
			}
		}
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + handle + "' is not recognised");
		}
		return null;
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		Accounts matchingAccount = null;
		Posts post = new Posts(message);
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
				postList.add(post);
				System.out.println("ID: " + post.postID + "\nAccount: " + post.AccountHandleLink + "\n" + post.postContent + "\n");
			}
		}
		if (matchingAccount == null) {
			throw new HandleNotRecognisedException("The handle '" + handle + "' is not recognised");
		}
		return 0;
	}

	//***need to work out a way to display id and handle of endorsing account like its a post and the endorseBody is the message within
	String endorseBody;
	@Override
	public int endorsePost(String handle, int id){ //throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		Endorsements endorsePost = new Endorsements(id, handle);
		endorsementList.add(endorsePost);
		String endorsedHandle = null; //initialise to null
		for (Posts post : postList){
			if(post.postID == id){
				endorsedHandle = post.AccountHandleLink; //assign the handle of the account being endorsed
				endorseBody = "\nEP@" + endorsedHandle + ": " + post.postContent;
				System.out.println(endorseBody);
			}
		}
		
		return 0; 
	}

	@Override
	public int commentPost(String handle, int id, String message){ //throws HandleNotRecognisedException,
			//PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
			Comments comment = new Comments(handle, id, message);		
			comment.commentId = commentList.size() + 1;
			commentList.add(comment);
		 
		return 0;
	}
 
	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		for (Posts post : postList){
			if(post.postID == id){
				postList.remove(post);			
			}
		}
		for(Endorsements endorsement : endorsementList){
			if(endorsement.postID == id){
				endorsementList.remove(endorsement);
			}
		}
		//Need to create logic for changing comments to default message but ionwanna cos it sounds hard - do later
			
	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generat
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
		//Not sure why this is hard but it's done 
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
		// try{
		// PrintWriter writer = new PrintWriter(filename);
		// // *************Need to store each value in speech marks to avoid the issue of extra commas in the CSV file
		
		// // Write the posts to file
		// writer.println("[PostData]");
		// for (Posts post : postList) {
		// 	writer.println(post.postID + "," + post.postContent + "," + post.AccountHandleLink);
		// }
		// writer.println();
		
		// writer.println("[CommentData]");
		// for (Comments comment : commentList) {
		// writer.println(comment.commentId + "," + comment.commentHandle + "," + comment.commentPostId + "," + comment.commentBody);
		// }
		// writer.println();

		// writer.println("[AccountData]]");
		// for (Accounts account : accountList) {
		// writer.println(account.ID + "," + account.Handle + "," + account.Description);
		// }
		// writer.println();
		
		// writer.println("[EndorsementData]");
		// for (Endorsements endorsement : endorsementList) {
		// 	writer.println(endorsement.endorsedPostId + "," + endorsement.endorseAccHandle);
		// }
		// writer.close();
		// }catch(FileNotFoundException e){
		// 	System.out.print("File not found");
			
		// }

		ListofLists largeList = new ListofLists()







	}

	String hold;
	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		Scanner scanner = new Scanner(new File(filename));

		while (scanner.hasNextLine()) {
			Posts post = new Posts();
			hold = scanner.nextLine();
			if (hold.equals("[PostData]")) {
				while (scanner.hasNextLine()) {
					hold = scanner.nextLine();
					if (hold.isEmpty()) {
						break;
					}
					String holdArr[] = hold.split(",");
					post.postID = Integer.parseInt(holdArr[0]);
					post.postContent = holdArr[1];
					post.AccountHandleLink = holdArr[2];
					postList.add(post);
					Arrays.fill(holdArr, null);
				}
				
			} else if (hold.equals("[CommentData]")) {
				while (scanner.hasNextLine()) {
					hold = scanner.nextLine();
					if (hold.isEmpty()) {
						break;
					}
					data2.add(Integer.parseInt(line));
				}
			}

	}
	}
}
