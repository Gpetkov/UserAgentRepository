package uk.co.newsint.cip.utilities.ua;

/**
 * User Agent parser utility class
 * 
 * @author abj
 * @see {@link RegexpUserAgentParser} {@link UserAgentUtilsParser} {@link CompositeUserAgentParser}
 */
public abstract class UserAgentParser
{

    /**
     * Creates new UserAgentParser
     * 
     * @return user agent parser
     */
    public static UserAgentParser getInstance()
    {
        return new CompositeUserAgentParser();
    }

    /**
     * Parses a String into an {@link UserAgent} object.
     * 
     * @param userAgentString User Agent String to be parsed
     * @return UserAgent object
     */
    public abstract UserAgent parse(String userAgentString);

}
