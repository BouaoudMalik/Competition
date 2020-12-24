package exceptions;

public class NotEnoughtCompetitorException extends RuntimeException{
	/**
	 * return a message if exception is thrown
	 */
	public NotEnoughtCompetitorException(String msg) {
		super(msg);
	}
}
