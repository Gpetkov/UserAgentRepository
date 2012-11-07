package uk.co.newsint.cip.utilities.ua;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.bitwalker.useragentutils.Application;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.DeviceType;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.Version;

/**
 * This is User Agent parser implementation that utilizes User Agent Java library hosted at http://user-agent-utils.java.net/.
 * 
 * @author Georgi Petkov
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
     * android,bada,blackberry,ios,kindle,linux,maemo,palm,psp,roku,symbian,webos,wii,sun_os,sony_ericsson,series40 Example iOS5 -->
     * operation system (iOS) operation system version (5)
     */
    private static final String REGEX_ALL_OTHERS = "((?i:android|bada|blackberry|iOS|kindle|linux|maemo|palm|psp|roku|symbian|"
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

            // array for the operation system(splitedOs[0] == osName and splitedOs[1] == osVersion)
            String[] splitedOs = splitOperationSystem(os);
            if (splitedOs != null)
            {
                if (splitedOs[0] != null)
                {
                    if ((splitedOs[1] != null) && (!splitedOs[1].toString().equals("Mobile 7")))
                    {
                        result.setOS(splitedOs[0]);
                    }

                }
                if (splitedOs[1] != null)
                {
                    result.setOSVersion(splitedOs[1]);
                }
            }
            String osMaker = os.getManufacturer().getName();
            if (osMaker != null)
            {
                result.setOSMaker(osMaker);
            }
            DeviceType deviceType = null;
            //The library can't match iPad like a Tablet
            if ((splitedOs[0] != null) && (!splitedOs[0].equals("iOS")))
            {
                deviceType = os.getDeviceType();
            }
            if (deviceType != null)
            {
                result.setDeviceType(deviceType.getName());
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
        Application application = Application.parseReferrerString(userAgentString);
        if (application.getName() != null)
        {
            result.setApplication(application.getName());
        }
        return result;
    }

    /**
     * Method which splits current OS(extract name and version from current operation system)
     * 
     * @param operationSystem
     * @return splitedOs[2](splitedOs[0] --> osName, splitedOs[1] --> osVersion)
     * 
     */
    private String[] splitOperationSystem(OperatingSystem operationSystem)
    {
        String[] splitedOS = new String[2];
        String osName = null;
        String osVersion = null;
        
        //Initialize current pattern
        Pattern pattern = Pattern.compile(REGEX_WIN_GOOGLE_MAC);
        Matcher match = pattern.matcher(operationSystem.toString());
        
        if (match.find())
        {
            osName = match.group(1);
            osVersion = match.group(2);
            
            //The library can't recognize iPad to be a tablet
            if ((osName.equals("MAC_OS"))
                    && ((osVersion.equals("X_IPAD")) || (osVersion.equals("X_IPOD")) || (osVersion.equals("X_IPHONE"))))
            {
                osName = "iOS";
                osVersion = null;
            }
            
            //The library can't recognize Windows 8 it sets 8 to Vista
            if ((osVersion != null) && (osVersion.trim().equals("Vista")))
            {
                osVersion = null;
            }
        }
        else
        {
            pattern = Pattern.compile(REGEX_ALL_OTHERS);
            match = pattern.matcher(operationSystem.toString());
            if (match.find())
            {
                osName = match.group(1);
                osVersion = match.group(2);
                if (osName.toString().equalsIgnoreCase("SERIES40"))
                {
                    osName = "NOKIA_OS";
                    osVersion = "SERIES40";
                }
            }
        }
        
        //initialize splitedOs
        splitedOS[0] = osName;
        splitedOS[1] = osVersion;
        return splitedOS;
    }

}
