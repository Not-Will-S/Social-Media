package socialmedia;

import java.io.Serializable;

/**
 * Thrown when attempting to use an account handle that does not exit in the
 * system.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 *
 */
public class HandleNotRecognisedException extends Exception implements Serializable {

	/**
	 * Constructs an instance of the exception with no message
	 */
	public HandleNotRecognisedException() {
		// do nothing
	}

	/**
	 * Constructs an instance of the exception containing the message argument
	 * 
	 * @param message message containing details regarding the exception cause
	 */
	public HandleNotRecognisedException(String message) {
		super(message);
	}

}
