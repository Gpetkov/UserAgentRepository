package uk.co.newsint.cip.utilities.ua;

import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.DeviceType;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.Version;

/**
 * This is User Agent parser implementation that utilizes User Agent Java library hosted at http://user-agent-utils.java.net/.
 * 
 * @author Zhivko Kalev
 * @since 1.0
 */
<<<<<<< HEAD
public class UserAgentUtilsParser extends UserAgentParser {

	@Override
	public UserAgent parse(String userAgentString) {
		// ask the library to parse the UA
		nl.bitwalker.useragentutils.UserAgent ua = nl.bitwalker.useragentutils.UserAgent
				.parseUserAgentString(userAgentString);

		// construct UserAgent result
		UserAgent result = new UserAgent();
		OperatingSystem os = ua.getOperatingSystem();
		if (os != null) {
			DeviceType deviceType = os.getDeviceType();
			if (deviceType != null) {
				result.setDeviceType(deviceType.getName());

			}

			result.setOS(os.getName());

		}

		Browser browser = ua.getBrowser();
		if (browser != null) {

			result.setBrowser(browser.getGroup().getName());
		}

		Version version = ua.getBrowserVersion();
		if (version != null) {
			result.setBrowserVersion(version.getVersion());
		}

		return result;
	}
=======
public class UserAgentUtilsParser extends UserAgentParser
{

    @Override
    public UserAgent parse(String userAgentString)
    {
        // ask the library to parse the UA
        nl.bitwalker.useragentutils.UserAgent ua = nl.bitwalker.useragentutils.UserAgent.parseUserAgentString(userAgentString);

        // TODO (Zhivko): check when ua is unparsed, throw exception

        // construct UserAgent result
        UserAgent result = new UserAgent();
        OperatingSystem os = ua.getOperatingSystem();
        if (os != null)
        {
            DeviceType deviceType = os.getDeviceType();
            if (deviceType != null)
            {
                result.setDeviceType(deviceType.getName());

                // TODO (Zhivko): Add device model, model version and maker
            }

            result.setOS(os.getGroup().getName());
            // this include operating system and operating system's Version for
            // example Windows_XP
            // if (os.getGroup() == os)
            // result.setOSVersion(os.getName());
        }

        Browser browser = ua.getBrowser();
        if (browser != null)
        {
            result.setBrowser(browser.getName());
        }

        Version version = ua.getBrowserVersion();
        if (version != null)
        {
            result.setBrowserVersion(version.getVersion());
        }

        return result;
    }
>>>>>>> 318661e5dc5e7978aee576c35fa637954698c296

}
