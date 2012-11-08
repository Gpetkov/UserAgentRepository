package uk.co.newsint.cip.utilities.ua;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The {@link RegexpUserAgentParserTest} class represents a test for {@link RegexpUserAgentParser} parse method
 * 
 * @author Georgi Petkov
 * @since 1.0
 * @see RegexpUserAgentParser#parse(String)
 */
public class RegexpUserAgentParserTest
{
    /**
     * Instance of UserAgentParser.class We're testing the instance's method "parse" {@link RegexpUserAgentParser#parse(String)}
     * 
     */
    protected UserAgentParser testUserAgentParser = new RegexpUserAgentParser();

    /**
     * Test method for WindowsPhone
     * 
     */
    @Test
    public void testWindowsPhoneParse() throws Exception
    {
        // Assert for Windows Phone OS.
        assertUserAgentEquals("Mozilla/4.0 (compatible; MSIE 7.0; Windows Phone OS 7.0; Trident/3.1; IEMobile/7.0; Acer; Allegro)",
                new UserAgent(UserAgent.MOBILE, "Acer", "Allegro", "Allegro", "Windows Phone", "7.0", "Microsoft Corporation",
                        "Internet Explorer", "7", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assert for Windows Phone OS.
        assertUserAgentEquals(
                "Mozilla/4.0 (compatible; MSIE 7.0; Windows Phone OS 7.5; Trident/3.1; IEMobile/7.0; HTC; 7 Mozart T8698)",
                new UserAgent(UserAgent.MOBILE, "HTC", "7 Mozart T8698", "7 Mozart T8698", "Windows Phone", "7.5",
                        "Microsoft Corporation", "Internet Explorer", "7", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
    }

    /**
     * Test method for BlackBerry
     * 
     */
    @Test
    public void testBlackBerryParse() throws Exception
    {
        // Assert for version 4.
        assertUserAgentEquals("BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301 The Times/1.0",
                new UserAgent(UserAgent.MOBILE, "BlackBerry", "8520", "8520", "OS4", "4.6.1.314", "Research In Motion Limited",
                        "BlackBerry", UserAgent.UNKNOWN, "The Times", "1.0", UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assert for version 5.
        assertUserAgentEquals("BlackBerry9105/5.0.0.748 Profile/MIDP-2.1 Configuration/CLDC-1.1 VendorID/125", new UserAgent(
                UserAgent.MOBILE, "BlackBerry", "9105", "9105", "OS5", "5.0.0.748", "Research In Motion Limited", "BlackBerry",
                UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assert for version 6.
        assertUserAgentEquals("BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/310 The Times/1.0",
                new UserAgent(UserAgent.MOBILE, "BlackBerry", "9300", "9300", "OS6", "6.6.0.124", "Research In Motion Limited",
                        "BlackBerry", UserAgent.UNKNOWN, "The Times", "1.0", UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assert for version 9.
        assertUserAgentEquals("BlackBerry9320/9.49.0.31 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/118 The Times/1.0",
                new UserAgent(UserAgent.MOBILE, "BlackBerry", "9320", "9320", "OS9", "9.49.0.31", "Research In Motion Limited",
                        "BlackBerry", UserAgent.UNKNOWN, "The Times", "1.0", UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assert for Playbook.
        assertUserAgentEquals(
                "Mozilla/5.0 (PlayBook; U; Android 2.3.3; en-gb; PlayBook Build/2.0.1.30) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
                new UserAgent(UserAgent.TABLET, "BlackBerry", "PlayBook", "PlayBook", "Android", "2.3.3",
                        "Research In Motion Limited", "BlackBerry", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en",
                        "gb"));
        // Assert for Playbook.
        assertUserAgentEquals(
                "Mozilla/5.0 (PlayBook; U; RIM Tablet OS 1.0.0; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.7 Safari/534.11+",
                new UserAgent(UserAgent.TABLET, "BlackBerry", "PlayBook", "PlayBook", "RIM Tablet OS", "1.0.0",
                        "Research In Motion Limited", "BlackBerry", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en",
                        "US"));
    }

    /**
     * Test method for Apple
     * 
     */
    @Test
    public void testAppleParse() throws Exception
    {
        // Assertion for IPhone
        assertUserAgentEquals("Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_3 like Mac OS X; ja-JP)" + " Times/1.0.2", new UserAgent(
                UserAgent.MOBILE, "Apple", "iPhone", "iPhone", "iOS", "4.3.3", "Apple Inc.", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Times", "1.0.2", "ja", "JP"));
        // Assertion for IPhone
        assertUserAgentEquals("Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_5 like Mac OS X; ca-es) "
                + "AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8L1 " + "Safari/6533.18.5", new UserAgent(
                UserAgent.MOBILE, "Apple", "iPhone", "iPhone", "iOS", "4.3.5", "Apple Inc.", "Safari", "5",
                UserAgent.UNKNOWN, UserAgent.UNKNOWN, "ca", "ES"));
        // Assertion for iPad
        assertUserAgentEquals("Mozilla/5.0 (iPad; CPU OS 5_1_1 like Mac OS X; de-de) AppleWebKit/534.46.0 (KHTML, like Gecko) "
                + "CriOS/21.0.1180.77 Mobile/9B206 Safari/7534.48.3", new UserAgent(UserAgent.TABLET, "Apple", "iPad", "iPad",
                "iOS", "5.1.1", "Apple Inc.", "Chrome", "21", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "de",
                "DE"));
        // Assertion for iPad
        assertUserAgentEquals("Mozilla/5.0 (iPad; U; CPU OS 4_2_1 like Mac OS X; it-it) AppleWebKit/533.17.9 "
                + "(KHTML, like Gecko) Version/5.0.2 Mobile/8C148 Safari/6533.18.5", new UserAgent(UserAgent.TABLET, "Apple",
                "iPad", "iPad", "iOS", "4.2.1", "Apple Inc.", "Safari", "5", UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "it", "IT"));
        // Assertion for iPod
        assertUserAgentEquals("Mozilla/5.0 (iPod touch; U; CPU iPhone OS 5_1_1 like Mac OS X; zh-CN) " + "Times/1.2.1",
                new UserAgent(UserAgent.MOBILE, "Apple", "iPod touch", "iPod touch", "iOS", "5.1.1", "Apple Inc.",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Times", "1.2.1", "zh", "CN"));
        // Assertion for iPod
        assertUserAgentEquals("Mozilla/5.0 (iPod; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) "
                + "Version/5.1 Mobile/9A334 Safari/7534.48.3", new UserAgent(UserAgent.MOBILE, "Apple", "iPod", "iPod", "iOS",
                "5.0", "Apple Inc.", "Safari", "5", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN));
    }

    /**
     * Test method for Android
     * 
     */
    @Test
    public void testAndroidParse() throws Exception
    {
        // Assertion for Android Safari browser on Archos
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 3.2.1; en-gb; ARCHOS 101G9 Build/HTK75D) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13",
                new UserAgent(UserAgent.UNKNOWN, "ARCHOS", "101G9", UserAgent.UNKNOWN, "Android", "3.2.1", "Google Inc.", "Safari",
                        "4", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "GB"));
        // Assertion for Android Safari browser on HTC
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; de-de; HTC_One_S/1.53.161.3 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "HTC", "One S", UserAgent.UNKNOWN, "Android", "4.0.3", "Google Inc.", "Safari",
                        "4", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "de", "DE"));
        // Assertion for Android Safari browser on ASUS
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; en-au; ASUS Transformer Pad TF700T Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "ASUS", "Transformer Pad TF700T", UserAgent.UNKNOWN, "Android", "4.0.3",
                        "Google Inc.", "Safari", "4", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "AU"));
        // Assertion for Android Safari browser on HTC
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; en-gb; HTC/Sensation/1.45.161.1 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "HTC", "Sensation", UserAgent.UNKNOWN, "Android", "4.0.3", "Google Inc.",
                        "Safari", "4", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "GB"));
        // Assertion for Android Safari browser on Samsung
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; en-gb; SAMSUNG-GT-I9100/I9100BULPC Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "SAMSUNG", "GT-I9100", UserAgent.UNKNOWN, "Android", "4.0.3", "Google Inc.",
                        "Safari", "4", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "GB"));
        // Assertion for Android Safari browser on Samsung(just model)
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.1.1; zh-cn; GT-I9300 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 qingshui",
                new UserAgent(UserAgent.UNKNOWN, UserAgent.UNKNOWN, "GT-I9300", UserAgent.UNKNOWN, "Android", "4.1.1",
                        "Google Inc.", "Safari", "4", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "zh", "CN"));
        // Assertion for Android Chrome browser on Samsung(just model)
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; Android 4.1.1; GT-I9100 Build/JRO03L) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19",
                new UserAgent(UserAgent.UNKNOWN, UserAgent.UNKNOWN, "GT-I9100", UserAgent.UNKNOWN, "Android", "4.1.1",
                        "Google Inc.", "Chrome", "18", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN));
        // Assertion for Android Chrome browser on Samsung
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; Android 4.0.4; SAMSUNG-SGH-I727 Build/IMM76I) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19",
                new UserAgent(UserAgent.UNKNOWN, "SAMSUNG", "SGH-I727", UserAgent.UNKNOWN, "Android", "4.0.4", "Google Inc.",
                        "Chrome", "18", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
    }

    /**
     * Test method for PC
     * 
     */
    @Test
    public void testPCParse() throws Exception
    {
        // Assertion for Internet Explorer browser
        assertUserAgentEquals("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)", new UserAgent(UserAgent.COMPUTER,
                UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Windows", "7", "Microsoft Corporation",
                "Internet Explorer", "9", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Internet Explorer
        assertUserAgentEquals("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)", new UserAgent(UserAgent.COMPUTER,
                UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Windows", "7", "Microsoft Corporation",
                "Internet Explorer", "9", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Chrome browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 4.0) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.5 "
                + "Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN,
                "Windows", "95", "Microsoft Corporation", "Chrome", "12", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Chrome browser
        assertUserAgentEquals(
                "Mozilla/5.0 (Windows NT 5.0) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.77 Safari/537.1",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Windows", "2000",
                        "Microsoft Corporation", "Chrome", "21", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN));
        // Assertion for Firefox browser
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.4) Gecko/2008102920 Firefox/3.0.4",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Windows", "XP",
                        "Microsoft Corporation", "Firefox", "3", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "US"));
        // Assertion for Firefox browser
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.19) Gecko/2010031422 YFF3 "
                + "Firefox/3.0.19", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN,
                "Windows", "XP", "Microsoft Corporation", "Firefox", "3", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "US"));
        // Assertion for Firefox browser
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.13) Gecko/20100914 "
                + "update/105618 Firefox/3.5.13", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER,
                UserAgent.UNKNOWN, "Windows", "XP", "Microsoft Corporation", "Firefox", "3", UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "en", "US"));
        // Assertion for Firefox browser Bot
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-GB; rv:1.9.2.24) Gecko/20111103 AskTbFTB/3.14.1.20007 "
                + "Firefox/3.6.24 (.NET CLR 3.5.30729)", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER,
                UserAgent.UNKNOWN, "Windows", "XP", "Microsoft Corporation", "Firefox", "3", UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "en", "GB"));
        // Assertion for Firefox Bot
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2) Gecko/20100115 AskTbARS/3.15.1.22229 "
                + "Firefox/3.6", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN,
                "Windows", "XP", "Microsoft Corporation", "Firefox", "3", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "US"));
        // Assertion for Iron browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Iron/12.0.750.0 "
                + "Chrome/12.0.750.0 Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER,
                UserAgent.UNKNOWN, "Windows", "XP", "Microsoft Corporation", "Iron", "12", UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Comodo_Dragon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Comodo_Dragon/12.1.0.0 "
                + "Chrome/12.0.742.91 Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER,
                UserAgent.UNKNOWN, "Windows", "XP", "Microsoft Corporation", "Comodo_Dragon", "12", UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Comodo_Dragon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Comodo_Dragon/12.2.0.0 "
                + "Chrome/12.0.742.112 Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER,
                UserAgent.UNKNOWN, "Windows", "XP", "Microsoft Corporation", "Comodo_Dragon", "12", UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Maxthon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.2) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.0 Chrome/18.0.966.0 "
                + "Safari/535.122", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN,
                "Windows", "XP 64-bit", "Microsoft Corporation", "Maxthon", "3", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Maxthon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.3.6.2000 "
                + "Chrome/18.0.966.0 Safari/535.12 AppEngine-Google; (+http://code.google.com/appengine; " + "appid: s~popi0391)",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Windows", "XP",
                        "Microsoft Corporation", "Maxthon", "3", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN));
        // Assertion for RockMelt browser
        assertUserAgentEquals(
                "Mozilla/5.0 (Windows NT 5.2; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) RockMelt/0.16.91.483 Chrome/16.0.912.77 Safari/535.7",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Windows", "XP 64-bit",
                        "Microsoft Corporation", "RockMelt", "0", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Safari browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.51.22 (KHTML, like Gecko) Version/5.0.2 "
                + "Safari/533.18.5", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN,
                "Windows", "7", "Microsoft Corporation", "Safari", "5", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Safari browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 "
                + "Safari/534.57.2", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN,
                "Windows", "7", "Microsoft Corporation", "Safari", "5", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Opera browser
        assertUserAgentEquals("Opera/9.80 (Windows NT 6.2; U; Edition IBIS; zh-cn) Presto/2.10.289 Version/12.00", new UserAgent(
                UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Windows", "8",
                "Microsoft Corporation", "Opera", "12", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "zh", "CN"));
        // Assertion for Opera browser for Macintosh
        assertUserAgentEquals("Opera/9.80 (Macintosh; Intel Mac OS X 10.8.1; U; nl) Presto/2.10.289 Version/12.02", new UserAgent(
                UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Mac OS X", "10.8.1", "Apple Inc.", "Opera",
                "12", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Safari browser for Macintosh
        assertUserAgentEquals("101653 Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_4) AppleWebKit/534.57.2 (KHTML, like Gecko) "
                + "Version/5.1.7 Safari/534.57.2", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER,
                UserAgent.UNKNOWN, "Mac OS X", "10.7.4", "Apple Inc.", "Safari", "5", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Safari browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; Linux i686) AppleWebKit/534.7 (KHTML, like Gecko) Version/5.0 Safari/534.7",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Safari", "5", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Chrome browser for Linux
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Chrome", "11", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Iron browser for Linux
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.19 (KHTML, like Gecko) Iron/18.0.1050.0 Chrome/18.0.1050.0 Safari/535.19",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Iron", "18", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for FireFox browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; Linux x86_64; rv:10.0.3) Gecko/20120314 Firefox/10.0.3", new UserAgent(
                UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Linux", UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "Firefox", "10", UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Iceweasel browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; U; Linux i686; de; rv:1.9.0.7) Gecko/2009032803 Iceweasel/3.0.6 (Debian-3.0.6-1)",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Iceweasel", "3", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for SeaMonkey browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1.22) Gecko/20090610 SeaMonkey/1.1.17",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "SeaMonkey", "1", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en",
                        "US"));
        // Assertion for QupZilla browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; Linux i686) AppleWebKit/534.34 (KHTML, like Gecko) QupZilla/1.3.1 Safari/534.34",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "QupZilla", "1", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Firefox browser for SunOS
        assertUserAgentEquals("Mozilla/5.0 (X11; U; SunOS i86pc; en-US; rv:1.9.0.11) Gecko/2009060311 Firefox/3.0.6",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "SunOS",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Firefox", "3", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "en", "US"));
        // Assertion for Chrome browser for FreeBSD
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; FreeBSD amd64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "FreeBSD",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Chrome", "21", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for Chrome browser for ChromeOS
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; CrOS i686 2465.142.0) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.COMPUTER, UserAgent.UNKNOWN, "ChromeOS",
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Chrome", "21", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN, UserAgent.UNKNOWN));
    }

    /**
     * Method which makes asserts for for every of the UserAgent's properties (equal for every of the properties)
     * 
     * @see RegexpUserAgentParser#parse(String)
     * 
     */
    protected void assertUserAgentEquals(String userAgentString, UserAgent expectedUserAgent) throws Exception
    {
        UserAgent actualUserAgent = testUserAgentParser.parse(userAgentString);
        assertNotNull("Expected UserAgent, but the method returns null", actualUserAgent);
        String templateFail = userAgentString + " >>> ";
        assertEquals(templateFail + "deviceType property", expectedUserAgent.getDeviceType(), actualUserAgent.getDeviceType());
        assertEquals(templateFail + "deviceMaker property", expectedUserAgent.getDeviceMaker(), actualUserAgent.getDeviceMaker());
        assertEquals(templateFail + "deviceModel property", expectedUserAgent.getDeviceModel(), actualUserAgent.getDeviceModel());
        assertEquals(templateFail + "deviceModelVersion property", expectedUserAgent.getDeviceModelVersion(),
                actualUserAgent.getDeviceModelVersion());
        assertEquals(templateFail + "os property", expectedUserAgent.getOS(), actualUserAgent.getOS());
        assertEquals(templateFail + "osVersion property", expectedUserAgent.getOSVersion(), actualUserAgent.getOSVersion());
        assertEquals(templateFail + "osMaker property", expectedUserAgent.getOSMaker(), actualUserAgent.getOSMaker());
        assertEquals(templateFail + "browser property", expectedUserAgent.getBrowser(), actualUserAgent.getBrowser());
        assertEquals(templateFail + "browserVersion property", expectedUserAgent.getBrowserVersion(),
                actualUserAgent.getBrowserVersion());
        assertEquals(templateFail + "application property", expectedUserAgent.getApplication(), actualUserAgent.getApplication());
        assertEquals(templateFail + "applicationVersion  property", expectedUserAgent.getApplicationVersion(),
                actualUserAgent.getApplicationVersion());
        assertEquals(templateFail + "language  property", expectedUserAgent.getLanguageCode(), actualUserAgent.getLanguageCode());
    }
}
