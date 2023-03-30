package socialmedia;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp implements Serializable {
	public static void main(String[] args) throws IllegalHandleException, InvalidHandleException, 
	HandleNotRecognisedException, AccountIDNotRecognisedException, InvalidPostException, NotActionablePostException,
	PostIDNotRecognisedException{
		BadSocialMedia platform = new BadSocialMedia();
		//Sorry need to borrow the testspace :P
		// platform.createAccount("Handle","iwtkms");
		// platform.createAccount("Greg");
		// platform.createAccount("ertgh", "drgh");
		// platform.createAccount("sgfg");
		// //platform.createAccount("one");
		// //platform.createAccount("Handle", "iwtkms");
		// //System.out.print(platform.accountList.size());
		// platform.createPost("Handle", "Birds aren't real");
		// platform.showAccount("Greg");
		// platform.showAccount("Handle");
		// platform.changeAccountHandle("Handle", "one");
		// platform.showAccount("one");
		// platform.updateAccountDescription("Greg", "newdesc");
		// // platform.showAccount("one");
		// platform.removeAccount(1);
		// //platform.showAccount("one");
		// platform.showAccount("Greg");
		// //platform.showAccount("sgfg");
		// platform.endorsePost("sgfg", 1);
		// platform.commentPost("Greg",1,"Yes they are?");
		// //platform.showAccount("ertgh");

		//Please dont delete below me **************************************************************************************************
		// platform.createAccount("TestAccount1");
		// platform.createAccount("TestAccount2");
		// platform.createPost("TestAccount1", "TestPost1");
		// platform.createPost("TestAccount2", "TestPost2");
		// platform.endorsePost("TestAccount1", 2);
		// platform.endorsePost("TestAccount2", 1);
		// platform.endorsePost("TestAccount1", 1);
		// platform.commentPost("TestAccount1", 2 , "TestCommentPost2");
		// platform.commentPost("TestAccount2", 1, "TestCommentPost1");
		platform.loadPlatform("Tst");
		// platform.loadPlatform("Test");
		// for(Posts post : platform.postList){
		// 	System.out.print(post.postID);
		// }
		//platform.savePlatform("Test");
		// platform.loadPlatform("Test.ser");
		// for(Posts post : platform.postList){
		// 	System.out.print(post.postID);
		// }
		System.out.print(platform.accountList.size());
		System.out.print(platform.endorsementList.size());
		System.out.print(platform.commentList.size());
		System.out.print(platform.postList.size());
		// // for(Accounts account : platform.accountList){
		// // 	System.out.print(account.Handle);
		// // }
		// platform.showIndividualPost(1);

	}
	
 
 

	/**
	 * Test method.
	 * 
	 * @param args not used
	 */
	// public static void main(String[] args) {
	// 	System.out.println("The system compiled and started the execution...");

	// 	SocialMediaPlatform platform = new BadSocialMedia();

	// 	assert (platform.getNumberOfAccounts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
	// 	assert (platform.getTotalOriginalPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
	// 	assert (platform.getTotalCommentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
	// 	assert (platform.getTotalEndorsmentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";

	// 	Integer id;
	// 	try {
	// 		id = platform.createAccount("my_handle");
	// 		assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

	// 		platform.removeAccount(id);
	// 		assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

	// 	} catch (IllegalHandleException e) {
	// 		assert (false) : "IllegalHandleException thrown incorrectly";
	// 	} catch (InvalidHandleException e) {
	// 		assert (false) : "InvalidHandleException thrown incorrectly";
	// 	} catch (AccountIDNotRecognisedException e) {
	// 		assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
	// 	}

	// }

}
