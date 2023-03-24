package socialmedia;
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
public class SocialMediaPlatformTestApp {
	public static void main(String[] args) throws IllegalHandleException, InvalidHandleException, 
	HandleNotRecognisedException, AccountIDNotRecognisedException, InvalidPostException{
		BadSocialMedia platform = new BadSocialMedia();
		platform.createAccount("Handle","iwtkms");
		platform.createAccount("Greg");
		platform.createAccount("ertgh", "drgh");
		platform.createAccount("sgfg");
		//platform.createAccount("one");
		//platform.createAccount("Handle", "iwtkms");
		//System.out.print(platform.accountList.size());
		platform.createPost("Handle", "Birds aren't real");
		platform.showAccount("Greg");
		platform.showAccount("Handle");
		platform.changeAccountHandle("Handle", "one");
		platform.showAccount("one");
		platform.updateAccountDescription("Greg", "newdesc");
		// platform.showAccount("one");
		platform.removeAccount(1);
		//platform.showAccount("one");
		platform.showAccount("Greg");
		platform.endorsePost("Greg", 1);
		//platform.showAccount("ertgh");
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
