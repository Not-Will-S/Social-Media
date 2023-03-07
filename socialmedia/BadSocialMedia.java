package socialmedia;
import java.util.ArrayList;
import java.util.Iterator;
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
		// TODO Auto-generated method stub
		Accounts account = new Accounts("hand", "Desc");
		account.ID = accountList.size() + 1;
		accountList.add(account);

		Accounts account1 = new Accounts("Handle", "Description");
		account1.ID = accountList.size() + 1;
		accountList.add(account1);
		return 0;
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeAccount(int id){// throws AccountIDNotRecognisedException {
		// TODO Auto-generated method stub
		accountList.removeIf(Account -> Account.ID == id);
	}

	@Override
	public void removeAccount(String handle) { // throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		accountList.removeIf(Account -> Account.Handle == handle);

	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Auto-generated method stub
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
