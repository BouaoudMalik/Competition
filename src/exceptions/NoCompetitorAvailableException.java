package exceptions;
/**
 * 
 * Exception class that is thrown when the list of competitor is Empty
 *
 */
public class NoCompetitorAvailableException extends RuntimeException{
	
/**
 * Constructo of the custumised exception
 * @param msg message of the exception
 */
	public NoCompetitorAvailableException(String msg) {
		super(msg);
	}

}
