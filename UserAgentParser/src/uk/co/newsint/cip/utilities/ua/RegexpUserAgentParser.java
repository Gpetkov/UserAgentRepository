package uk.co.newsint.cip.utilities.ua;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author BitMix
 * 
 */

public class RegexpUserAgentParser extends UserAgentParser
{

    /**
     * regex for finding BlackBerry OS version 4 and 5 User Agents example: BlackBerry8520/4.6.1.314 Profile/MIDP-2.0
     * Configuration/CLDC-1.1 VendorID/301
     */
    private static final String REGEX_BB_4_AND_5 = "((?i:blackberry)+?)\\s?(\\d{2,4}?.?)/((\\d+.\\d+.\\d+.\\d+)+)";
    private static Pattern PATTERN_BB_4_5 = Pattern.compile(REGEX_BB_4_AND_5);

    /**
     * regex for finding BlackBerry OS version 6 and 7 User Agents example: Mozilla/5.0 (BlackBerry; U; BlackBerry 9360; ar)
     * AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.0.0.353 Mobile Safari/534.11+
     */
    private static final String REGEX_BB_6_AND_7 = "((?i:blackberry)+?)\\s?(\\d{2,4}?);\\s?\\w+?.\\s?[\\S*\\s?]+?(?i:version/)+((\\S+)+)\\s?";
    private static Pattern PATTERN_BB_6_7 = Pattern.compile(REGEX_BB_6_AND_7);

    /**
     * regex for finding BlackBerry PlayBook User Agents example: Mozilla/5.0 (PlayBook; U; Android 2.3.3; en-gb; PlayBook
     * Build/2.0.1.30) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1
     */
    private static final String REGEX_BB_PLAYBOOK = "((?i:playbook)+?);\\s?.;\\s?(\\w+\\s+\\w*\\s?\\w*\\s?)+((\\d+.\\d+.\\d+)+)";
    private static Pattern PATTERN_BB_PLAYBOOK = Pattern.compile(REGEX_BB_PLAYBOOK);

    /**
     * regex for finding Windows Phone OS User Agents example: Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0;
     * IEMobile/9.0; HTC; HD7 T9292)
     */
    private static final String REGEX_WIN_PHONE = "((?i:msie)\\s?)?(\\d+.\\d+)?.\\s?((?i:windows phone os)+?)\\s?(\\d.\\d)+.\\s?\\w*.?\\w*.?\\w*[;]?\\s?\\w*.?\\w*.?\\w*[;]?\\s?(\\w+).\\s?((\\w+\\s?\\w*[-]?\\s?\\w*)+?).";
    private static Pattern PATTERN_WIN_PHONE = Pattern.compile(REGEX_WIN_PHONE);

    /**
     * regex for finding iOS User Agents(doesn't catch iOS 1.X) example: Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_2_1 like Mac OS X;
     * sv-se) AppleWebKit/533.17.9 (KHTML, like Gecko) Mobile/8C148a
     */
    private static final String REGEX_iOS = "((?i:iphone|ipod|ipad)\\s?\\w*)+?;\\s?(?i)u?.?\\s?[\\w*?\\s?]*?((\\d_\\d_?\\d*)+?)\\s?[\\S*\\s?]*?\\w*[-]?\\w*";
    private static Pattern PATTERN_iOS = Pattern.compile(REGEX_iOS);

    /**
     * regex for finding PC Microsoft IE User Agents example: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Win64; x64;
     * Trident/4.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; HPDTDF; Tablet PC 2.0;
     * .NET4.0C)
     */
    private static final String REGEX_PC_WIN_IE = "((?i:msie)+?)\\s?(\\d.\\d)+?;?\\s?(\\w+\\s?\\w+)+?\\s?((\\d.\\d)+?);?";
    private static Pattern PATTERN_PC_WIN_IE = Pattern.compile(REGEX_PC_WIN_IE);

    /**
     * regex for finding PC Windows User Agents example: Mozilla/5.0 (Windows NT 6.0; WOW64; rv:11.0) Gecko/20100101
     * Firefox/11.0,platform,unknown
     */
    private static final String REGEX_PC_WIN = "((?i:windows)\\s?\\w*)+?\\s?(\\d.\\d)+?.[\\s?\\S*]+?((?i:chrome|firefox|iron|Comodo_Dragon|Maxthon|RockMelt))\\s?/\\s?((\\d+.\\d+[\\.]?\\d*[\\.]?\\d*)+)";
    private static Pattern PATTERN_PC_WIN = Pattern.compile(REGEX_PC_WIN);

    /**
     * regex for finding PC MAC User Agents example: "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; hu_hu) AppleWebKit/534.46
     * (KHTML, like Gecko) Version/5.0.5 Safari/534.46,platform,unknown
     */
    private static final String REGEX_PC_MAC = "((?i:mac os)\\s?(?i:x)?)+?\\s?(\\d+.?\\d*[\\._]?\\d*)+?.?\\s?\\w*[-]?\\w*[\\s?\\S*]*?((?i:firefox|chrome|NetNewsWire|iron|RockMelt|camino))\\s?/\\s?((\\d+[\\.]?\\d*[\\.]?\\d*)+?)";
    private static Pattern PATTERN_PC_MAC = Pattern.compile(REGEX_PC_MAC);

    /**
     * regex for finding PC MAC OmniWeb browser User Agents example: Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_4_11; en-US)
     * AppleWebKit/533.21.1+(KHTML, like Gecko, Safari/533.19.4) Version/5.11.1 OmniWeb/622.18.0,platform,unknown
     */
    private static final String REGEX_PC_MAC_OMNIWEB = "((?i:mac os)\\s?(?i:x)?)+?\\s?(\\d+.?\\d*[\\._]?\\d*)+?.?\\s?\\w*[-]?\\w*[\\s?\\S*]*?((?i:OmniWeb))\\s?/\\s?((\\d+[\\.]?\\d*[\\.]?\\d*)+?)";
    private static Pattern PATTERN_PC_MAC_OMNIWEB = Pattern.compile(REGEX_PC_MAC_OMNIWEB);

    /**
     * regex for finding PC Opera browser User Agents example: Opera/9.80 (Windows NT 6.1; WOW64; U; fi) Presto/2.10.289
     * Version/12.02
     */
    private static final String REGEX_PC_OPERA = "((?i:opera)+)/[\\s?\\S*]+?((?i:windows\\s?nt)|(?i:mac\\s?os\\s?x))+?\\s?(\\d+.?\\d*[_\\.]?\\d*)+?[\\s?\\S*]+?(?i:version)+?\\s?/\\s?((\\d+.\\d+)+?)";
    private static Pattern PATTERN_PC_OPERA = Pattern.compile(REGEX_PC_OPERA);

    /**
     * regex for finding PC Windows Safari User Agents example: Mozilla/5.0 (Windows; U; Windows NT 6.0; nb-NO) AppleWebKit/533.19.4
     * (KHTML, like Gecko) Version/4.0.4 Safari/531.21.10,platform,unknown
     */
    private static final String REGEX_PC_WIN_SAFARI = "((?i:windows)\\s?\\w*)+?\\s?(\\d.\\d)+?.[\\s?\\S*]+?(?i:version)+\\s?/\\s?(\\d+.\\d+[\\.]?\\d*[\\.]?\\d*)+[\\s?\\S*]+?((?i:safari)+).*";
    private static Pattern PATTERN_PC_WIN_SAFARI = Pattern.compile(REGEX_PC_WIN_SAFARI);

    /**
     * regex for finding PC MAC Safari User Agents example: Mozilla/5.0 (Macintosh; PPC Mac OS X 10_5_8) AppleWebKit/534.50.2
     * (KHTML, like Gecko) Version/4.0.1 Safari/530.18,platform,unknown
     */
    private static final String REGEX_PC_MAC_SAFARI = "((?i:mac os)\\s?(?i:x)?)+?\\s?(\\d+.?\\d*[\\._]?\\d*)+?.?\\s?\\w*[-]?\\w*[\\s?\\S*]*?(?i:version)+?\\s?/\\s?(\\d+[\\.]?\\d*[\\.]?\\d*)+?[\\s?\\S*]*?((?i:safari)+)";
    private static Pattern PATTERN_PC_MAC_SAFARI = Pattern.compile(REGEX_PC_MAC_SAFARI);

    /**
     * regex for finding PC Linux User Agents example: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.11 (KHTML, like Gecko)
     * Sabayon Chrome/20.0.1132.57 Safari/536.11,platform,unknown
     */
    private static final String REGEX_PC_LINUX = "((?i:linux|freebsd|SunOS)+?)\\s+[\\S*\\s?]+?((?i:chrome|firefox|QupZilla|Iron|Iceweasel|SeaMonkey)+)\\s?/\\s?((\\d+.?\\d*[\\._]?\\d*[\\._]?\\d*)+?)";
    private static Pattern PATTERN_PC_LINUX = Pattern.compile(REGEX_PC_LINUX);

    /**
     * regex for finding PC Linux Safari User Agents example: Mozilla/5.0 (X11; Linux i686) AppleWebKit/534.7 (KHTML, like Gecko)
     * Version/5.0 Safari/534.7,platform,unknown
     */
    private static final String REGEX_PC_LINUX_SAFARI = "((?i:linux|freebsd|SunOS)+?)\\s+[\\S*\\s?]+?(?i:version)+\\s?/\\s?(\\d+.?\\d*[\\._]?\\d*[\\._]?\\d*)+?[\\S*\\s?]+?((?i:safari)+)";
    private static Pattern PATTERN_PC_LINUX_SAFARI = Pattern.compile(REGEX_PC_LINUX_SAFARI);

    /**
     * regex for finding PC ChromeOS User Agents example: Mozilla/5.0 (X11; CrOS i686 2465.142.0) AppleWebKit/537.1 (KHTML, like
     * Gecko) Chrome/21.0.1180.89 Safari/537.1,platform,unknown
     */
    private static final String REGEX_PC_CHROME_OS = "((?i:cros)+?)\\s?\\S*\\s?(\\d+.?\\d*.?\\d*)+?[\\s?\\S*]+?((?i:chrome)+?)\\s?/\\s?((\\d+.?\\d*[\\._]?\\d*[\\._]?\\d*)+?)";
    private static Pattern PATTERN_PC_CHROME_OS = Pattern.compile(REGEX_PC_CHROME_OS);

    /**
     * regex for finding Android User Agents example: Mozilla/5.0 (Linux; U; Android 1.6; en-ie; SonyEricssonE15i Build/1.3.A.0.50)
     * AppleWebKit/528.5+ (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1,platform,unknown
     */
    private static final String REGEX_ANDROID = "([(]+[\\s?\\S*]+(?i:android)+[\\s?\\w+-;/]+[)]+)(([\\s?\\S+]+)+)";
    private static Pattern PATTERN_ANDROID = Pattern.compile(REGEX_ANDROID);

    /**
     * regex add-on for finding Android OS and OS version in Android User Agents
     */
    private static final String ADDON_REGEX_ANDROID_OS = "((?i:android)+)\\s?((\\d+\\.\\d+\\.?\\d*)+)";
    private static Pattern PATTERN_ANDROID_OS = Pattern.compile(ADDON_REGEX_ANDROID_OS);

    /**
     * regex add-on for finding Android device maker and device model in Android User Agents
     */
    private static final String ADDON_REGEX_ANDROID_MODEL = ";\\s?((?i:htc|lg|samsung|sonyericsson|sony|asus|onda|woxter|huawei|dell|archos|motorola))?[\\s_/-]?(\\w+-?(\\s*\\w+)*)+?";
    private static Pattern PATTERN_ANDROID_MODEL = Pattern.compile(ADDON_REGEX_ANDROID_MODEL);

    /**
     * regex add-on for finding browser and browser version in Android User Agents
     */
    private static final String ADDON_REGEX_ANDROID_BROWSER = "((?i:chrome|version)+?)\\s?/\\s?((\\d+.\\d+[\\.]?\\d*[\\.]?\\d*)+)";
    private static Pattern PATTERN_ANDROID_BROWSER = Pattern.compile(ADDON_REGEX_ANDROID_BROWSER);

    /**
     * Method for finding the Windows version according to it's NT signature.
     */
    private String getWindowsVersion(String uaWindows)
    {
        String result = "";
        if (uaWindows.equals("4.0"))
        {
            result = "95";
            return result;
        }
        if (uaWindows.equals("5.0"))
        {
            result = "2000";
            return result;
        }
        if (uaWindows.equals("5.1"))
        {
            result = "XP";
            return result;
        }
        if (uaWindows.equals("5.2"))
        {
            result = "XP 64-bit";
            return result;
        }
        if (uaWindows.equals("6.0"))
        {
            result = "Vista";
            return result;
        }
        if (uaWindows.equals("6.1"))
        {
            result = "7";
            return result;
        }
        if (uaWindows.equals("6.2"))
        {
            result = "8";
            return result;
        }
        else
        {
            result = uaWindows;
            return result;
        }
    }

    @Override
    public UserAgent parse(String userAgentString)
    {
        // throws UserAgentParseException {

        UserAgent ua = new UserAgent();
        // if (userAgentString == null) {
        // throw new UserAgentParseException("UA not found!");
        // }

        Matcher match = PATTERN_BB_4_5.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.MOBILE);
            ua.setDeviceMaker(match.group(1));
            ua.setDeviceModel(match.group(2));
            ua.setDeviceModelVersion(match.group(2));
            ua.setOS("OS" + match.group(3).charAt(0));
            ua.setOSVersion(match.group(3));
            ua.setBrowser("BlackBerry");
            return ua;
        }
        match = PATTERN_BB_6_7.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.MOBILE);
            ua.setDeviceMaker(match.group(1));
            ua.setDeviceModel(match.group(2));
            ua.setDeviceModelVersion(match.group(2));
            ua.setOS("OS" + match.group(3).charAt(0));
            ua.setOSVersion(match.group(3));
            ua.setBrowser("BlackBerry");
            return ua;
        }
        match = PATTERN_BB_PLAYBOOK.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.TABLET);
            ua.setDeviceMaker("BlackBerry");
            ua.setDeviceModel(match.group(1));
            ua.setDeviceModelVersion(match.group(1));
            ua.setOS(match.group(2));
            ua.setOSVersion(match.group(3));
            ua.setBrowser("BlackBerry");
            return ua;
        }
        match = PATTERN_WIN_PHONE.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.MOBILE);
            ua.setDeviceMaker(match.group(5));
            ua.setDeviceModel(match.group(6));
            ua.setDeviceModelVersion(match.group(6));
            ua.setOS(match.group(3));
            ua.setOSVersion(match.group(4));
            ua.setBrowser(match.group(1));
            ua.setBrowserVersion(match.group(2));
            return ua;
        }
        match = PATTERN_iOS.matcher(userAgentString);
        if (match.find())
        {
            if (match.group(1).equalsIgnoreCase("ipad"))
            {
                ua.setDeviceType(UserAgent.TABLET);
            }
            else
            {
                ua.setDeviceType(UserAgent.MOBILE);
            }
            ua.setDeviceMaker("Apple");
            ua.setDeviceModel(match.group(1));
            ua.setDeviceModelVersion(match.group(1));
            ua.setOS("iOS");
            ua.setOSVersion(match.group(2).replaceAll("_", "."));
            return ua;
        }
        match = PATTERN_PC_WIN_IE.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker(UserAgent.UNKNOWN);
            ua.setBrowser(match.group(1));
            ua.setBrowserVersion(match.group(2));
            ua.setOS(match.group(3).replaceAll("\\s?NT", ""));
            ua.setOSVersion(getWindowsVersion(match.group(4)));
            return ua;
        }
        match = PATTERN_PC_WIN.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker(UserAgent.UNKNOWN);
            ua.setBrowser(match.group(3));
            ua.setBrowserVersion(match.group(4));
            ua.setOS(match.group(1).replaceAll("\\s?NT", ""));
            ua.setOSVersion(getWindowsVersion(match.group(2)));
            return ua;
        }
        match = PATTERN_PC_MAC.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker("Apple");
            ua.setBrowser(match.group(3));
            ua.setBrowserVersion(match.group(4));
            ua.setOS(match.group(1));
            ua.setOSVersion(match.group(2).replaceAll("_", "."));
            return ua;
        }
        match = PATTERN_PC_MAC_OMNIWEB.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker("Apple");
            ua.setBrowser(match.group(3));
            ua.setBrowserVersion(match.group(4));
            ua.setOS(match.group(1));
            ua.setOSVersion(match.group(2).replaceAll("_", "."));
            return ua;
        }
        match = PATTERN_PC_OPERA.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);

            if (match.group(2).equalsIgnoreCase("mac os x"))
            {
                ua.setDeviceMaker("Apple");
                ua.setOSVersion(match.group(3));
                ua.setOS(match.group(2));
            }
            else
            {
                ua.setDeviceMaker(UserAgent.UNKNOWN);
                ua.setOSVersion(getWindowsVersion(match.group(3)));
                ua.setOS(match.group(2).replaceAll("\\s?NT", ""));
            }
            ua.setBrowser(match.group(1));
            ua.setBrowserVersion(match.group(4));

            return ua;
        }
        match = PATTERN_PC_WIN_SAFARI.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker(UserAgent.UNKNOWN);
            ua.setBrowser("Safari");
            ua.setBrowserVersion(match.group(3));
            ua.setOS(match.group(1).replaceAll("\\s?NT", ""));
            ua.setOSVersion(getWindowsVersion(match.group(2)));
            return ua;
        }
        match = PATTERN_PC_MAC_SAFARI.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker("Apple");
            ua.setBrowser("Safari");
            ua.setBrowserVersion(match.group(3));
            ua.setOS(match.group(1));
            ua.setOSVersion(match.group(2).replaceAll("_", "."));
            return ua;
        }
        match = PATTERN_PC_LINUX.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker(UserAgent.UNKNOWN);
            ua.setBrowser(match.group(2));
            ua.setBrowserVersion(match.group(3));
            ua.setOS(match.group(1));
            return ua;
        }
        match = PATTERN_PC_LINUX_SAFARI.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker(UserAgent.UNKNOWN);
            ua.setBrowser("Safari");
            ua.setBrowserVersion(match.group(2));
            ua.setOS(match.group(1));
            return ua;
        }
        match = PATTERN_PC_CHROME_OS.matcher(userAgentString);
        if (match.find())
        {
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceMaker(UserAgent.UNKNOWN);
            ua.setBrowser(match.group(3));
            ua.setBrowserVersion(match.group(4));
            ua.setOS("ChromeOS");
            ua.setOSVersion(match.group(2));
            return ua;
        }
        match = PATTERN_ANDROID.matcher(userAgentString);
        if (match.find())
        {
            Matcher inMatch = PATTERN_ANDROID_OS.matcher(match.group(1));
            if (inMatch.find())
            {
                ua.setOS(inMatch.group(1));
                ua.setOSVersion(inMatch.group(2));
            }
            inMatch = PATTERN_ANDROID_MODEL.matcher(match.group(1).substring(match.group(1).lastIndexOf(";")));
            if (inMatch.find())
            {
                if (inMatch.group(1) == null)
                {
                    ua.setDeviceMaker(UserAgent.UNKNOWN);
                }
                else
                {
                    ua.setDeviceMaker(inMatch.group(1));
                }
                ua.setDeviceModel(inMatch.group(2).replaceAll("\\s?Build", "").replaceAll("_", " "));
            }
            inMatch = PATTERN_ANDROID_BROWSER.matcher(match.group(2));
            if (inMatch.find())
            {
                if (inMatch.group(1).equalsIgnoreCase("version"))
                {
                    ua.setBrowser("Safari");
                }
                else
                {
                    ua.setBrowser(inMatch.group(1));
                }
                ua.setBrowserVersion(inMatch.group(2));
            }
            return ua;
        }
        else
        {
            // throw new UserAgentParseException("UA not found!");
            return new UserAgent();
        }

    }

}
