package uk.co.newsint.cip.utilities.ua;

/**
 * A User Agent parser that will first ask {@link UserAgentUtilsParser} to fill {@link UserAgent} properties. For all unknown values
 * will use {@link RegexpUserAgentParser} to try fill the gaps.
 * 
 * @author Zhivko Kalev
 * @since 1.0
 */

public class CompositeUserAgentParser extends UserAgentParser
{

    protected UserAgentUtilsParser utilsParser = new UserAgentUtilsParser();
    protected RegexpUserAgentParser regexpParser = new RegexpUserAgentParser();

    @Override
    public UserAgent parse(String userAgentString)
    {
        UserAgent userAgent = null;

        // 1. Use UserAgentUtilsParser to try parse the UA string

        userAgent = utilsParser.parse(userAgentString);

        // 2. Use RegexpUserAgentParser to try parse the UA string
        UserAgent regexpAgent = regexpParser.parse(userAgentString);

        // 3. Fill Unknowns with regexp UA properties

        if (UserAgent.UNKNOWN.equals(userAgent.getDeviceType()))
            userAgent.setDeviceType(regexpAgent.getDeviceType());
        if (UserAgent.UNKNOWN.equals(userAgent.getDeviceMaker()))
            userAgent.setDeviceMaker(regexpAgent.getDeviceMaker());
        if (UserAgent.UNKNOWN.equals(userAgent.getDeviceModel()))
            userAgent.setDeviceModel(regexpAgent.getDeviceModel());
        if (UserAgent.UNKNOWN.equals(userAgent.getDeviceModelVersion()))
            userAgent.setDeviceModelVersion(regexpAgent.getDeviceModelVersion());
        if (UserAgent.UNKNOWN.equals(userAgent.getOS()))
            userAgent.setOS(regexpAgent.getOS());
        if (UserAgent.UNKNOWN.equals(userAgent.getOSVersion()))
            userAgent.setOSVersion(regexpAgent.getOSVersion());
        if (UserAgent.UNKNOWN.equals(userAgent.getBrowser()))
            userAgent.setBrowser(regexpAgent.getBrowser());
        if (UserAgent.UNKNOWN.equals(userAgent.getBrowserVersion()))
            userAgent.setBrowserVersion(regexpAgent.getBrowserVersion());

        return userAgent;
    }

}
