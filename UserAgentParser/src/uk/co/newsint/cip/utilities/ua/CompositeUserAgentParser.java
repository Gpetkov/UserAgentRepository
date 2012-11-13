package uk.co.newsint.cip.utilities.ua;

/**
 * A User Agent parser that will first ask {@link UserAgentUtilsParser} to fill {@link UserAgent} properties. For all unknown values
 * will use {@link RegexpUserAgentParser} to try fill the gaps using {@link UserAgent#merge(UserAgent)} method.
 * 
 * @author Georgi Petkov
 * @since 1.0
 */
public class CompositeUserAgentParser extends UserAgentParser
{
    // OpenDDRUserAgentParser instance
    protected OpenDDRUserAgentParser openDDRParser;
    // RegexpUserAgentParser instance
    protected RegexpUserAgentParser regexpParser;

    public CompositeUserAgentParser()
    {
        this.openDDRParser = new OpenDDRUserAgentParser();
        this.regexpParser = new RegexpUserAgentParser();
    }

    @Override
    public UserAgent parse(String userAgentString)
    {
        // 1. Use RegexpUserAgentParser to try parse the UA string
        UserAgent regexpUserAgent = regexpParser.parse(userAgentString);
        // 2. Use OpenDDRParser to try parse the UA string
        UserAgent openDDRUserAgent = openDDRParser.parse(userAgentString);
        // 3. Merge the user-agents (merge --> regexpUserAgent with openDDRUserAgent)
        regexpUserAgent.merge(openDDRUserAgent);
        return regexpUserAgent;
    }
}
