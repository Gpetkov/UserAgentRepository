package uk.co.newsint.cip.utilities.ua;

/**
 * Default User Agent parser will first ask {@link UserAgentUtilsParser} to fill {@link UserAgent} properties. For all
 * unknown values will use {@link RegexpUserAgentParser} to try make a guess.
 * 
 * @author Zhivko Kalev
 * @since 1.0
 */
public class CompositeUserAgentParser extends UserAgentParser {
	
	protected UserAgentUtilsParser utilsParser = new UserAgentUtilsParser();
	protected RegexpUserAgentParser regexpParser = new RegexpUserAgentParser();

	@Override
	public UserAgent parse(String userAgentString) throws UserAgentParseException {
		UserAgent userAgent = null;
		
		// 1. Use UserAgentUtilsParser to try parse the UA string
		try {
			userAgent = utilsParser.parse(userAgentString);
		} catch (UserAgentParseException e) {
			// create new user agent with all unknown props.
			userAgent = new UserAgent();
		}

		// 2. Use UserAgentParser to try parse the UA string
		UserAgent regexpAgent = regexpParser.parse(userAgentString);
		
		// 3. Fill Unkowns with regexp UA properties
		// TODO (Zhivko): Consider using equals, not ==
		if (userAgent.getDeviceType() == UserAgent.UNKNOWN)
			userAgent.setDeviceType(regexpAgent.getDeviceType());
		if (userAgent.getDeviceMaker() == UserAgent.UNKNOWN)
			userAgent.setDeviceMaker(regexpAgent.getDeviceMaker());
		if (userAgent.getDeviceModel() == UserAgent.UNKNOWN)
			userAgent.setDeviceModel(regexpAgent.getDeviceModel());
		if (userAgent.getDeviceModelVersion() == UserAgent.UNKNOWN)
			userAgent.setDeviceModelVersion(regexpAgent.getDeviceModelVersion());
		if (userAgent.getOS() == UserAgent.UNKNOWN)
			userAgent.setOS(regexpAgent.getOS());
		if (userAgent.getOSVersion() == UserAgent.UNKNOWN)
			userAgent.setOSVersion(regexpAgent.getOSVersion());
		if (userAgent.getBrowser() == UserAgent.UNKNOWN)
			userAgent.setBrowser(regexpAgent.getBrowser());
		if (userAgent.getBrowserVersion() == UserAgent.UNKNOWN)
			userAgent.setBrowserVersion(regexpAgent.getBrowserVersion());

		return userAgent;
	}

}
	
