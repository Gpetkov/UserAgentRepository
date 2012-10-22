package uk.co.newsint.cip.utilities.ua;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class UserAgentUtilsParser extends UserAgentParser
{
    /**
     * regex for finding versions of windows,google and mac_os for example(7-->windows7)
     */
    private static final String REGEX_WIN_GOOGLE_MAC = "((?i:windows|google|mac_os))\\_?\\s?((.)+)?";
    /**
     * regex for finding versions of
     * android,bada,blackberry,ios,kindle,linux,maemo,palm,psp,roku,symbian,webos,wii,sun_os,sony_ericsson,series40 for example
     * (5-->ios5)
     */
    private static final String REGEX_ALL_OTHERS = "((?i:android|bada|blackberry|ios|kindle|linux|maemo|palm|psp|roku|symbian|"
            + "webos|wii|sun_os|sony_ericsson|series40))((\\d\\w*))?";

    @Override
    public UserAgent parse(String userAgentString)
    {
        // ask the library to parse the UA
        nl.bitwalker.useragentutils.UserAgent ua = nl.bitwalker.useragentutils.UserAgent.parseUserAgentString(userAgentString);

        // construct UserAgent result
        UserAgent result = new UserAgent();
        OperatingSystem os = ua.getOperatingSystem();
        if (os != null)
        {
            DeviceType deviceType = os.getDeviceType();
            if (deviceType != null)
            {
                result.setDeviceType(deviceType.getName());

            }

            // result.setOS(os.getName());
            String[] splitedOs = splitOperationSystem(os.getName());
            if (splitedOs != null)
            {
                if (splitedOs[0] != null)
                {
                    result.setOS(splitedOs[0]);
                }
                if (splitedOs[1] != null)
                {
                    result.setOSVersion(splitedOs[1]);
                }
            }

        }

        Browser browser = ua.getBrowser();
        if (browser != null)
        {

            result.setBrowser(browser.getGroup().getName());
        }

        Version version = ua.getBrowserVersion();
        if (version != null)
        {
            result.setBrowserVersion(version.getVersion());
        }

        return result;
    }

    /**
     * Method which splits current OS(extract name and version from current operation system)
     * 
     * @return splitedOs[2](splitedOs[0] --> osName, splitedOs[1] --> osVersion)
     * 
     */
    private String[] splitOperationSystem(String operationSystem)
    {
        String[] splitedOS = new String[2];
        Pattern pattern = Pattern.compile(REGEX_WIN_GOOGLE_MAC);
        Matcher match = pattern.matcher(operationSystem);
        if (match.find())
        {
            String osName = match.group(1);
            String osVersion = match.group(2);
            if (osVersion == null)
            {
                osVersion = null;
            }
            splitedOS[0] = osName;
            splitedOS[1] = osVersion;
        }
        else
        {
            pattern = Pattern.compile(REGEX_ALL_OTHERS);
            match = pattern.matcher(operationSystem);
            if (match.find())
            {
                String osName = match.group(1);
                String osVersion = match.group(2);
                if (osVersion == null)
                {
                    osVersion = "Unknown";
                }
                if (osName.toString().equalsIgnoreCase("SERIES40"))
                {
                    osName = "NOKIA_OS";
                    osVersion = "SERIES40";
                }
                splitedOS[0] = osName;
                splitedOS[1] = osVersion;
            }
            else
            {
                splitedOS[0] = null;
                splitedOS[1] = null;
            }
        }

        return splitedOS;
    }

}
