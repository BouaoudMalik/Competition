package exceptions;
/**
 * customized exception
 */
public class NotPowerOfTwoException extends RuntimeException{

	/**
	 * return a message if exception is thrown
	 */
	public NotPowerOfTwoException(String msg) {
		super(msg);
	}
}
