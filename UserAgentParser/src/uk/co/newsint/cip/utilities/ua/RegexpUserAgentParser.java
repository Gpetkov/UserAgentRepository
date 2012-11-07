package uk.co.newsint.cip.utilities.ua;

import java.util.HashMap;
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
    private static final String REGEX_WIN_PHONE = "((?i:msie))\\s?(\\d+.\\d+)?.\\s?((?i:windows phone os)+?)\\s?(\\d.\\d)+;\\s?(?i:trident/\\d.\\d;)\\s?(?i:iemobile/\\d.\\d;)\\s?(\\w+);\\s?((\\w+\\s?\\w*[-]?\\s?\\w*)+?).";
    private static Pattern PATTERN_WIN_PHONE = Pattern.compile(REGEX_WIN_PHONE);

    /**
     * regex for finding iOS User Agents example: Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_2_1 like Mac OS X; sv-se)
     * AppleWebKit/533.17.9 (KHTML, like Gecko) Mobile/8C148a
     */
    private static final String REGEX_iOS = "((?i:iphone|ipod|ipad|ipod touch))+?;[\\S*\\s?]*?(?i:os)+?\\s?((\\d+.\\d+.?\\d*)?)";
    private static Pattern PATTERN_iOS = Pattern.compile(REGEX_iOS);

    /**
     * regex for finding PC MAC User Agents example: "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; hu_hu) AppleWebKit/534.46
     * (KHTML, like Gecko) Version/5.0.5 Safari/534.46,platform,unknown
     */
    private static final String REGEX_PC_MAC = "((?i:mac os)\\s?(?i:x)?)+?\\s?((\\d+.?\\d*[\\._]?\\d*)?)";
    private static Pattern PATTERN_PC_MAC = Pattern.compile(REGEX_PC_MAC);

    /**
     * regex for finding PC Linux User Agents example: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.11 (KHTML, like Gecko)
     * Sabayon Chrome/20.0.1132.57 Safari/536.11,platform,unknown
     */
    private static final String REGEX_PC_LINUX = "((?i:linux|freebsd|SunOS|cros)+?)";
    private static Pattern PATTERN_PC_LINUX = Pattern.compile(REGEX_PC_LINUX);

    /**
     * regex for finding PC Microsoft IE User Agents example: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Win64; x64;
     * Trident/4.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; HPDTDF; Tablet PC 2.0;
     * .NET4.0C)
     */
    private static final String REGEX_PC_WIN_IE = "((?i:msie)+?)\\s?(\\d.\\d)+?;?\\s?((?i:windows nt)+?)\\s?((\\d.\\d)+?);?";
    private static Pattern PATTERN_PC_WIN_IE = Pattern.compile(REGEX_PC_WIN_IE);

    /**
     * regex for finding PC Windows User Agents example: Mozilla/5.0 (Windows NT 6.0; WOW64; rv:11.0) Gecko/20100101
     * Firefox/11.0,platform,unknown
     */
    private static final String REGEX_PC_WIN = "((?i:windows)\\s?\\w*)+?\\s?((\\d.\\d)+?)";
    private static Pattern PATTERN_PC_WIN = Pattern.compile(REGEX_PC_WIN);

    /**
     * regex for finding PC Opera browser User Agents example: Opera/9.80 (Windows NT 6.1; WOW64; U; fi) Presto/2.10.289
     * Version/12.02
     */
    private static final String REGEX_PC_OPERA = "((?i:opera)+)/[\\s?\\S*]+?((?i:windows\\s?nt)|(?i:mac\\s?os\\s?x)|(?i:freebsd|sunos))+?\\s?(\\d+.?\\d*[_\\.]?\\d*)?";
    private static Pattern PATTERN_PC_OPERA = Pattern.compile(REGEX_PC_OPERA);

    /**
     * regex for finding Android User Agents example: Mozilla/5.0 (Linux; U; Android 1.6; en-ie; SonyEricssonE15i Build/1.3.A.0.50)
     * AppleWebKit/528.5+ (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1,platform,unknown
     */
    private static final String REGEX_ANDROID = "([(]+[\\s?\\S*]+(?i:android)+[\\s?\\w+-;/]+[)]+)(([\\s?\\S+]+)+)";
    private static Pattern PATTERN_ANDROID = Pattern.compile(REGEX_ANDROID);

    /**
     * regex for finding Android OS and OS version in Android User Agents
     */
    private static final String REGEX_ANDROID_OS = "((?i:android)+)\\s?((\\d+\\.\\d+\\.?\\d*)+)";
    private static Pattern PATTERN_ANDROID_OS = Pattern.compile(REGEX_ANDROID_OS);

    /**
     * regex for finding Android device maker and device model in Android User Agents
     */
    private static final String REGEX_ANDROID_MODEL = ";\\s?((?i:htc|lg|samsung|sonyericsson|sony|asus|onda|woxter|huawei|dell|archos|motorola))?[\\s_/-]?(\\w+-?(\\s*\\w+)*)+?";
    private static Pattern PATTERN_ANDROID_MODEL = Pattern.compile(REGEX_ANDROID_MODEL);

    /**
     * regex for finding browser and browser version in User Agents
     */
    private static final String REGEX_BROWSER = "((?i:chrome|version|firefox|iron|Comodo_Dragon|Maxthon|RockMelt|OmniWeb|NetNewsWire|camino|QupZilla|Iceweasel|SeaMonkey|thunderbird)+?)\\s?/\\s?((\\d+.\\d+[\\.]?\\d*[\\.]?\\d*)+?)";
    private static Pattern PATTERN_BROWSER = Pattern.compile(REGEX_BROWSER);
    private static Matcher browserMatch;

    /**
     * regex for finding bot User Agents example: Mozilla/5.0 (compatible; archive.is bot; +http://archive.is/01EP)
     * AppleWebKit/535.19 Safari/535.19
     */
    private static final String BOT = "((?i:bot)+?)";
    private static Pattern PATTERN_BOT = Pattern.compile(BOT);

    /**
     * regex for finding language in User Agents
     */
    private static final String REGEX_LANGUAGE = "\\s+(\\w{2})-(\\w{2})[;\\)\\s+]+";
    private static Pattern PATTERN_LANGUAGE = Pattern.compile(REGEX_LANGUAGE);

    /**
     * regex for finding application and application version in User Agents
     */
    private static final String REGEX_APPLICATION = "\\s+(([\\w+\\s+]+)?((?i:times)+)([\\w+\\s+]+)?)+\\s?/\\s?((\\d+.\\d+[\\.]?\\d*[\\.]?\\d*)+?)";
    private static Pattern PATTERN_APP = Pattern.compile(REGEX_APPLICATION);

    /**
     * Windows version converter HashMap
     */
    private HashMap<String, String> winVer;

    /**
     * Constructor for the class
     */
    public RegexpUserAgentParser()
    {
        winVer = new HashMap<String, String>();
        winVer.put("4.0", "95");
        winVer.put("5.0", "2000");
        winVer.put("5.1", "XP");
        winVer.put("5.2", "XP 64-bit");
        winVer.put("6.0", "Vista");
        winVer.put("6.1", "7");
        winVer.put("6.2", "8");
    }

    /**
     * Method for finding the Windows version according to it's NT signature.
     */
    private String getWindowsVersion(String uaWindows)
    {
        String result = winVer.get(uaWindows);
        if (result == null)
        {
            result = uaWindows;
        }
        return result;
    }

    @Override
    public UserAgent parse(String userAgentString)
    {
        UserAgent ua;
        // @formatter:off
        if ((ua = parseBlackBerry45(userAgentString)) != null 
                || (ua = parseBlackBerry67(userAgentString)) != null
                || (ua = parseBlackBerryPlayBook(userAgentString)) != null 
                || (ua = parseWinPhone(userAgentString)) != null
                || (ua = parseiOS(userAgentString)) != null 
                || (ua = parsePCOpera(userAgentString)) != null
                || (ua = parsePCWinIE(userAgentString)) != null 
                || (ua = parseAndroid(userAgentString)) != null
                || (ua = parsePCWin(userAgentString)) != null 
                || (ua = parsePCLinux(userAgentString)) != null
                || (ua = parseBot(userAgentString)) != null 
                || (ua = parsePCMac(userAgentString)) != null)
        {
            return ua;
        }
        // @formatter:on
        return new UserAgent();
    }

    /**
     * Method for parsing bot UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parseBot(String userAgentString)
    {
        Matcher match = PATTERN_BOT.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setBrowser("BOT");
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setOS("BOT");
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing PC Linux UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parsePCLinux(String userAgentString)
    {
        Matcher match = PATTERN_PC_LINUX.matcher(userAgentString);
        if (match.find() && !userAgentString.contains("Android") && !userAgentString.contains("Opera"))
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceModel(UserAgent.COMPUTER);
            ua.setOS(match.group(1).toUpperCase());
            if (match.group(1).equalsIgnoreCase("cros"))
            {
                ua.setOS("ChromeOS");
            }
            applyBrowser(userAgentString, ua);
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing PC Mac UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parsePCMac(String userAgentString)
    {
        Matcher match = PATTERN_PC_MAC.matcher(userAgentString);
        if (match.find() && !userAgentString.contains("Opera") && !userAgentString.contains("iPhone")
                && !userAgentString.contains("iPod") && !userAgentString.contains("iPad")
                && !userAgentString.contains("iPod touch"))
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceModel(UserAgent.COMPUTER);
            ua.setDeviceMaker("Apple");
            ua.setOSMaker("Apple Inc.");
            ua.setOS(match.group(1).toUpperCase());
            if (match.group(2) != null)
            {
                ua.setOSVersion(match.group(2).replaceAll("_", "."));
            }
            applyBrowser(userAgentString, ua);
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing PC Windows UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parsePCWin(String userAgentString)
    {
        Matcher match = PATTERN_PC_WIN.matcher(userAgentString);
        if (match.find() && !userAgentString.contains("Opera"))
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceModel(UserAgent.COMPUTER);
            ua.setOSMaker("Microsoft Corporation");
            ua.setOS(match.group(1).replaceAll("\\s?NT", "").toUpperCase());
            ua.setOSVersion(getWindowsVersion(match.group(2)));
            applyBrowser(userAgentString, ua);
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing Android UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parseAndroid(String userAgentString)
    {
        Matcher match = PATTERN_ANDROID.matcher(userAgentString);
        if (match.find() && !userAgentString.contains("PlayBook"))
        {
            UserAgent ua = new UserAgent();
            Matcher inMatch = PATTERN_ANDROID_OS.matcher(match.group(1));
            if (inMatch.find())
            {
                ua.setOS(inMatch.group(1).toUpperCase());
                ua.setOSVersion(inMatch.group(2));
                ua.setOSMaker("Google Inc.");
            }
            inMatch = PATTERN_ANDROID_MODEL.matcher(match.group(1).substring(match.group(1).lastIndexOf(";")));
            if (inMatch.find())
            {
                if (inMatch.group(1) != null)
                {
                    ua.setDeviceMaker(inMatch.group(1));
                }
                ua.setDeviceModel(inMatch.group(2).replaceAll("\\s?Build", "").replaceAll("_", " "));
            }
            inMatch = PATTERN_BROWSER.matcher(match.group(2));
            if (inMatch.find())
            {
                ua.setBrowser(inMatch.group(1));
                if (inMatch.group(1).equalsIgnoreCase("version"))
                {
                    ua.setBrowser("Safari");
                }
                ua.setBrowserVersion(inMatch.group(2));
            }
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing PC Windows IE UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parsePCWinIE(String userAgentString)
    {
        Matcher match = PATTERN_PC_WIN_IE.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceModel(UserAgent.COMPUTER);
            ua.setOSMaker("Microsoft Corporation");
            ua.setBrowser("Internet Explorer");
            ua.setBrowserVersion(match.group(2));
            ua.setOS(match.group(3).replaceAll("\\s?NT", "").toUpperCase());
            ua.setOSVersion(getWindowsVersion(match.group(4)));
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing PC Opera UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parsePCOpera(String userAgentString)
    {
        Matcher match = PATTERN_PC_OPERA.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.COMPUTER);
            ua.setDeviceModel(UserAgent.COMPUTER);

            if (match.group(3) != null)
            {
                ua.setOSVersion(getWindowsVersion(match.group(3)));
            }

            ua.setOS(match.group(2).replaceAll("\\s?NT", "").toUpperCase());
            ua.setOSMaker("Microsoft Corporation");
            ua.setBrowser(match.group(1));

            if (match.group(2).equalsIgnoreCase("mac os x"))
            {
                ua.setDeviceMaker("Apple");
                ua.setOS(match.group(2).toUpperCase());
                ua.setOSMaker("Apple Inc.");
            }

            browserMatch = PATTERN_BROWSER.matcher(userAgentString);
            if (browserMatch.find())
            {
                ua.setBrowserVersion(browserMatch.group(2));
            }
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing iOS UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parseiOS(String userAgentString)
    {
        Matcher match = PATTERN_iOS.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.MOBILE);
            if (match.group(1).equalsIgnoreCase("ipad"))
            {
                ua.setDeviceType(UserAgent.TABLET);
            }
            ua.setDeviceMaker("Apple");
            ua.setDeviceModel(match.group(1));
            ua.setDeviceModelVersion(match.group(1));
            ua.setOS("iOS");
            ua.setOSMaker("Apple Inc.");
            if (match.group(2) != null)
            {
                ua.setOSVersion(match.group(2).replaceAll("_", ".").trim());
            }
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing BlackBerry PlayBook UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parseBlackBerryPlayBook(String userAgentString)
    {
        Matcher match = PATTERN_BB_PLAYBOOK.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.TABLET);
            ua.setDeviceMaker("BlackBerry");
            ua.setDeviceModel(match.group(1));
            ua.setDeviceModelVersion(match.group(1));
            ua.setOS(match.group(2).trim().toUpperCase());
            ua.setOSMaker("Research In Motion Limited");
            ua.setOSVersion(match.group(3));
            ua.setBrowser("BlackBerry");
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing BlackBerry versions 6 and 7 UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parseBlackBerry67(String userAgentString)
    {
        Matcher match = PATTERN_BB_6_7.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.MOBILE);
            ua.setDeviceMaker(match.group(1));
            ua.setDeviceModel(match.group(2));
            ua.setDeviceModelVersion(match.group(2));
            ua.setOSMaker("Research In Motion Limited");
            ua.setOS("OS" + match.group(3).charAt(0));
            ua.setOSVersion(match.group(3));
            ua.setBrowser("BlackBerry");
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing BlackBerry versions 4 and 5 UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parseBlackBerry45(String userAgentString)
    {
        Matcher match = PATTERN_BB_4_5.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.MOBILE);
            ua.setDeviceMaker(match.group(1));
            ua.setDeviceModel(match.group(2));
            ua.setDeviceModelVersion(match.group(2));
            ua.setOSMaker("Research In Motion Limited");
            ua.setOS("OS" + match.group(3).charAt(0));
            ua.setOSVersion(match.group(3));
            ua.setBrowser("BlackBerry");
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for parsing Windows Phone UserAgents
     * 
     * @return {@link UserAgent}
     */
    private UserAgent parseWinPhone(String userAgentString)
    {
        Matcher match = PATTERN_WIN_PHONE.matcher(userAgentString);
        if (match.find())
        {
            UserAgent ua = new UserAgent();
            ua.setDeviceType(UserAgent.MOBILE);
            ua.setDeviceMaker(match.group(5));
            ua.setDeviceModel(match.group(6));
            ua.setDeviceModelVersion(match.group(6));
            ua.setOSMaker("Microsoft Corporation");
            ua.setOS("WINDOWS PHONE");
            ua.setOSVersion(match.group(4));
            ua.setBrowser("Internet Explorer");
            ua.setBrowserVersion(match.group(2));
            applyLanguage(userAgentString, ua);
            applyAPP(userAgentString, ua);
            return ua;
        }
        return null;
    }

    /**
     * Method for filling UserAgent browser attributes based on PATTERN_BROWSER
     */
    private void applyBrowser(String userAgentString, UserAgent ua)
    {
        Matcher match = PATTERN_BROWSER.matcher(userAgentString);
        if (match.find())
        {
            ua.setBrowser(match.group(1));
            if (match.group(1).equalsIgnoreCase("version"))
            {
                ua.setBrowser("Safari");
            }
            ua.setBrowserVersion(match.group(2));
        }
    }

    /**
     * Method for finding UserAgent language attributes. Catches only pair language-country e.g. en-US and sets {@link UserAgent}
     * language attribute to "English"
     */
    private void applyLanguage(String userAgentString, UserAgent ua)
    {
        Matcher match = PATTERN_LANGUAGE.matcher(userAgentString);
        if (match.find())
        {
            if (Character.isLowerCase(match.group(1).charAt(0)))
            {
                ua.setLanguageCode(match.group(1));
                ua.setCountryCode(match.group(2));
            }
        }
    }

    /**
     * Method for filling UserAgent application attributes
     */
    private void applyAPP(String userAgentString, UserAgent ua)
    {
        Matcher match = PATTERN_APP.matcher(userAgentString);
        if (match.find())
        {
            ua.setApplication(match.group(1));
            ua.setApplicationVersion(match.group(5));
        }
    }

}
