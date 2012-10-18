package uk.co.newsint.cip.utilities.ua;

/**
 * This exceptions is thrown in {@link FileUserAgentParser} and {@link
 * UserAgentParser} classes
 * 
 * @author BitMix
 * 
 */
public class UserAgentParseException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * create UserAgentParseExeption
	 */
	public UserAgentParseException() {
	}

	public UserAgentParseException(String mesage) {
		super(mesage);

	}

	public UserAgentParseException(Throwable couse) {
		super(couse);
	}

	public UserAgentParseException(String mesege, Throwable couse) {
		super(mesege, couse);

	}
}
