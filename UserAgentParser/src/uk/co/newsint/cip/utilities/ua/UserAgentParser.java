package uk.co.newsint.cip.utilities.ua;

/**
 * ...
 * 
 * @author abj
 * @see {@link RegexpUserAgentParser} {@link UserAgentUtilsParser}
 * {@link CompositeUserAgentParser}
 */
public abstract class UserAgentParser {

	/**
	 * Creates new UserAgentParser
	 * 
	 * @return user agent parser
	 */
	public static UserAgentParser getInstance() {
		return new CompositeUserAgentParser();
	}
	
	/**
	 * Parses a String into an {@link UserAgent} object.
	 * 
	 * @param userAgentString
	 *            User Agent String to be parsed
	 * @throws UserAgentParseException
	 *             When the userAgentString is not found as a User Agent String
	 * @return UserAgent object
	 */
	public abstract UserAgent parse(String userAgentString)
			throws UserAgentParseException;
}
