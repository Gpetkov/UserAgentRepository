/**
 * This exceptions is thrown in {@link}FileUserAgentParser.java and {@link}UserAgentParser.java classes
 * 
 *@author BitMix
 *
 */

public class UserAgentParseException extends Exception {

	
	private static final long serialVersionUID = 1L;

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
