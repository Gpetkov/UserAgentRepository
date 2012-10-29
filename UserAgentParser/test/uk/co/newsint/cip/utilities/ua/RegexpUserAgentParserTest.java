package uk.co.newsint.cip.utilities.ua;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The UserAgentParserTest class represents a test for UserAgentParser class's methods
 * 
 * @author Georgi Petkov
 * @version 1.0
 * @since 2012-10-12
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
     * Methods which test the different cases for user agent string
     * 
     * @see UserAgentParser#parse(String)
     * 
     */
    /**
     * Test method for WindowsPhone
     * 
     */
    @Test
    public void testWindowsPhoneParse() throws Exception
    {

        // Assert for Windows Phone OS.
        assertUserAgentEquals("Mozilla/4.0 (compatible; MSIE 7.0; Windows Phone OS 7.0; Trident/3.1; IEMobile/7.0; Acer; Allegro)",
                new UserAgent(UserAgent.MOBILE, "Acer", "Allegro", "Allegro", "Windows Phone OS", "7.0", "MSIE", "7.0"));

        // Assert for Windows Phone OS.
        assertUserAgentEquals(
                "Mozilla/4.0 (compatible; MSIE 7.0; Windows Phone OS 7.5; Trident/3.1; IEMobile/7.0; HTC; 7 Mozart T8698)",
                new UserAgent(UserAgent.MOBILE, "HTC", "7 Mozart T8698", "7 Mozart T8698", "Windows Phone OS", "7.5", "MSIE", "7.0"));
    }

    /**
     * Test method for BlackBerry
     * 
     */
    @Test
    public void testBlackBerryParse() throws Exception
    {

        // Assert for version 4.
        assertUserAgentEquals("BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301", new UserAgent(
                UserAgent.MOBILE, "BlackBerry", "8520", "8520", "OS4", "4.6.1.314", "BlackBerry", UserAgent.UNKNOWN));

        // Assert for version 5.
        assertUserAgentEquals("BlackBerry9105/5.0.0.748 Profile/MIDP-2.1 Configuration/CLDC-1.1 VendorID/125", new UserAgent(
                UserAgent.MOBILE, "BlackBerry", "9105", "9105", "OS5", "5.0.0.748", "BlackBerry", UserAgent.UNKNOWN));
        // Assert for version 6.
        assertUserAgentEquals("BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/310 The Times/1.0",
                new UserAgent(UserAgent.MOBILE, "BlackBerry", "9300", "9300", "OS6", "6.6.0.124", "BlackBerry", UserAgent.UNKNOWN));

        // Assert for version 9.
        assertUserAgentEquals("BlackBerry9320/9.49.0.31 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/118 The Times/1.0",
                new UserAgent(UserAgent.MOBILE, "BlackBerry", "9320", "9320", "OS9", "9.49.0.31", "BlackBerry", UserAgent.UNKNOWN));
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
                UserAgent.MOBILE, "Apple", "iPhone", "iPhone", "iOS", "4.3.3", UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for IPhone
        assertUserAgentEquals("Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_5 like Mac OS X; ca-es) "
                + "AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8L1 " + "Safari/6533.18.5", new UserAgent(
                UserAgent.MOBILE, "Apple", "iPhone", "iPhone", "iOS", "4.3.5", UserAgent.UNKNOWN, UserAgent.UNKNOWN));

        // Assertion for iPad
        assertUserAgentEquals("Mozilla/5.0 (iPad; CPU OS 5_1_1 like Mac OS X; de-de) AppleWebKit/534.46.0 (KHTML, like Gecko) "
                + "CriOS/21.0.1180.77 Mobile/9B206 Safari/7534.48.3", new UserAgent(UserAgent.TABLET, "Apple", "iPad", "iPad",
                "iOS", "5.1.1", UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for iPad
        assertUserAgentEquals("Mozilla/5.0 (iPad; U; CPU OS 4_2_1 like Mac OS X; it-it) AppleWebKit/533.17.9 "
                + "(KHTML, like Gecko) Version/5.0.2 Mobile/8C148 Safari/6533.18.5", new UserAgent(UserAgent.TABLET, "Apple",
                "iPad", "iPad", "iOS", "4.2.1", UserAgent.UNKNOWN, UserAgent.UNKNOWN));
        // Assertion for iPod
        assertUserAgentEquals("Mozilla/5.0 (iPod touch; U; CPU iPhone OS 5_1_1 like Mac OS X; zh-CN) " + "Times/1.2.1",
                new UserAgent(UserAgent.MOBILE, "Apple", "iPod touch", "iPod touch", "iOS", "5.1.1", UserAgent.UNKNOWN,
                        UserAgent.UNKNOWN));
        // Assertion for iPod
        assertUserAgentEquals("Mozilla/5.0 (iPod; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) "
                + "Version/5.1 Mobile/9A334 Safari/7534.48.3", new UserAgent(UserAgent.MOBILE, "Apple", "iPod", "iPod", "iOS",
                "5.0", UserAgent.UNKNOWN, UserAgent.UNKNOWN));
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
                new UserAgent(UserAgent.UNKNOWN, "ARCHOS", "101G9", UserAgent.UNKNOWN, "Android", "3.2.1", "Safari", "4.0"));

        // Assertion for Android Safari browser on HTC
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; de-de; HTC_One_S/1.53.161.3 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "HTC", "One S", UserAgent.UNKNOWN, "Android", "4.0.3", "Safari", "4.0"));

        // Assertion for Android Safari browser on ASUS
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; en-au; ASUS Transformer Pad TF700T Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "ASUS", "Transformer Pad TF700T", UserAgent.UNKNOWN, "Android", "4.0.3", "Safari",
                        "4.0"));

        // Assertion for Android Safari browser on HTC
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; en-gb; HTC/Sensation/1.45.161.1 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "HTC", "Sensation", UserAgent.UNKNOWN, "Android", "4.0.3", "Safari", "4.0"));

        // Assertion for Android Safari browser on Samsung
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.0.3; en-gb; SAMSUNG-GT-I9100/I9100BULPC Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
                new UserAgent(UserAgent.UNKNOWN, "SAMSUNG", "GT-I9100", UserAgent.UNKNOWN, "Android", "4.0.3", "Safari", "4.0"));

        // Assertion for Android Safari browser on Samsung(just model)
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; U; Android 4.1.1; zh-cn; GT-I9300 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 qingshui",
                new UserAgent(UserAgent.UNKNOWN, UserAgent.UNKNOWN, "GT-I9300", UserAgent.UNKNOWN, "Android", "4.1.1", "Safari",
                        "4.0"));

        // Assertion for Android Chrome browser on Samsung(just model)
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; Android 4.1.1; GT-I9100 Build/JRO03L) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19",
                new UserAgent(UserAgent.UNKNOWN, UserAgent.UNKNOWN, "GT-I9100", UserAgent.UNKNOWN, "Android", "4.1.1", "Chrome",
                        "18.0.1025.166"));

        // Assertion for Android Chrome browser on Samsung
        assertUserAgentEquals(
                "Mozilla/5.0 (Linux; Android 4.0.4; SAMSUNG-SGH-I727 Build/IMM76I) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19",
                new UserAgent(UserAgent.UNKNOWN, "SAMSUNG", "SGH-I727", UserAgent.UNKNOWN, "Android", "4.0.4", "Chrome",
                        "18.0.1025.166"));

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
                UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows", "7", "MSIE", "9.0"));
        // Assertion for Internet Explorer
        assertUserAgentEquals("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)", new UserAgent(UserAgent.COMPUTER,
                UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows", "7", "MSIE", "9.0"));
        // Assertion for Chrome browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 4.0) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.5 "
                + "Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Windows", "95", "Chrome", "12.0.742.5"));
        // Assertion for Chrome browser
        assertUserAgentEquals(
                "Mozilla/5.0 (Windows NT 5.0) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.77 Safari/537.1",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows", "2000",
                        "Chrome", "21.0.1180.77"));
        // Assertion for Firefox browser
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.4) Gecko/2008102920 Firefox/3.0.4",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows", "XP",
                        "Firefox", "3.0.4"));
        // Assertion for Firefox browser
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.19) Gecko/2010031422 YFF3 "
                + "Firefox/3.0.19", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Windows", "XP", "Firefox", "3.0.19"));
        // Assertion for Firefox browser
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.13) Gecko/20100914 "
                + "update/105618 Firefox/3.5.13", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "Windows", "XP", "Firefox", "3.5.13"));
        // Assertion for Firefox browser Bot
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-GB; rv:1.9.2.24) Gecko/20111103 AskTbFTB/3.14.1.20007 "
                + "Firefox/3.6.24 (.NET CLR 3.5.30729)", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "Windows", "XP", "Firefox", "3.6.24"));
        // Assertion for Firefox Bot
        assertUserAgentEquals("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2) Gecko/20100115 AskTbARS/3.15.1.22229 "
                + "Firefox/3.6", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Windows", "XP", "Firefox", "3.6"));
        // Assertion for Iron browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Iron/12.0.750.0 "
                + "Chrome/12.0.750.0 Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "Windows", "XP", "Iron", "12.0.750.0"));
        // Assertion for Comodo_Dragon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Comodo_Dragon/12.1.0.0 "
                + "Chrome/12.0.742.91 Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "Windows", "XP", "Comodo_Dragon", "12.1.0.0"));
        // Assertion for Comodo_Dragon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Comodo_Dragon/12.2.0.0 "
                + "Chrome/12.0.742.112 Safari/534.30", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                UserAgent.UNKNOWN, "Windows", "XP", "Comodo_Dragon", "12.2.0.0"));
        // Assertion for Maxthon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.2) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.0 Chrome/18.0.966.0 "
                + "Safari/535.122", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Windows", "XP 64-bit", "Maxthon", "3.0"));
        // Assertion for Maxthon browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.3.6.2000 "
                + "Chrome/18.0.966.0 Safari/535.12 AppEngine-Google; (+http://code.google.com/appengine; " + "appid: s~popi0391)",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows", "XP",
                        "Maxthon", "3.3.6.2000"));
        // Assertion for RockMelt browser
        assertUserAgentEquals(
                "Mozilla/5.0 (Windows NT 5.2; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) RockMelt/0.16.91.483 Chrome/16.0.912.77 Safari/535.7",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows", "XP 64-bit",
                        "RockMelt", "0.16.91.483"));
        // Assertion for Safari browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.51.22 (KHTML, like Gecko) Version/5.0.2 "
                + "Safari/533.18.5", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Windows", "7", "Safari", "5.0.2"));
        // Assertion for Safari browser
        assertUserAgentEquals("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 "
                + "Safari/534.57.2", new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Windows", "7", "Safari", "5.1.7"));
        // Assertion for Opera browser
        assertUserAgentEquals("Opera/9.80 (Windows NT 6.2; U; Edition IBIS; zh-cn) Presto/2.10.289 Version/12.00", new UserAgent(
                UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows", "8", "Opera", "12.00"));
        // Assertion for Opera browser for Macintosh
        assertUserAgentEquals("Opera/9.80 (Macintosh; Intel Mac OS X 10.8.1; U; nl) Presto/2.10.289 Version/12.02", new UserAgent(
                UserAgent.COMPUTER, "Apple", UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Mac OS X", "10.8.1", "Opera", "12.02"));
        // Assertion for Safari browser for Macintosh
        assertUserAgentEquals("101653 Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_4) AppleWebKit/534.57.2 (KHTML, like Gecko) "
                + "Version/5.1.7 Safari/534.57.2", new UserAgent(UserAgent.COMPUTER, "Apple", UserAgent.UNKNOWN, UserAgent.UNKNOWN,
                "Mac OS X", "10.7.4", "Safari", "5.1.7"));

        // Assertion for Safari browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; Linux i686) AppleWebKit/534.7 (KHTML, like Gecko)" + " Version/5.0 Safari/534.7",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, "Safari", "5.0"));

        // Assertion for Chrome browser for Linux
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, "Chrome", "11.0.696.34"));

        // Assertion for Iron browser for Linux
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.19 (KHTML, like Gecko) Iron/18.0.1050.0 Chrome/18.0.1050.0 Safari/535.19",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, "Iron", "18.0.1050.0"));

        // Assertion for FireFox browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; Linux x86_64; rv:10.0.3) Gecko/20120314 Firefox/10.0.3", new UserAgent(
                UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Linux", UserAgent.UNKNOWN, "Firefox",
                "10.0.3"));

        // Assertion for Iceweasel browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; U; Linux i686; de; rv:1.9.0.7) Gecko/2009032803 Iceweasel/3.0.6 (Debian-3.0.6-1)",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, "Iceweasel", "3.0.6"));

        // Assertion for SeaMonkey browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1.22) Gecko/20090610 SeaMonkey/1.1.17",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, "SeaMonkey", "1.1.17"));

        // Assertion for QupZilla browser for Linux
        assertUserAgentEquals("Mozilla/5.0 (X11; Linux i686) AppleWebKit/534.34 (KHTML, like Gecko) QupZilla/1.3.1 Safari/534.34",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Linux",
                        UserAgent.UNKNOWN, "QupZilla", "1.3.1"));

        // Assertion for Firefox browser for SunOS
        assertUserAgentEquals("Mozilla/5.0 (X11; U; SunOS i86pc; en-US; rv:1.9.0.11) Gecko/2009060311 Firefox/3.0.6",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "SunOS",
                        UserAgent.UNKNOWN, "Firefox", "3.0.6"));

        // Assertion for Chrome browser for FreeBSD
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; FreeBSD amd64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "FreeBSD",
                        UserAgent.UNKNOWN, "Chrome", "21.0.1180.89"));

        // Assertion for Chrome browser for ChromeOS
        assertUserAgentEquals(
                "Mozilla/5.0 (X11; CrOS i686 2465.142.0) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "ChromeOS",
                        UserAgent.UNKNOWN, "Chrome", "21.0.1180.89"));
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
        assertEquals(templateFail + "OS property", expectedUserAgent.getOS(), actualUserAgent.getOS());
        assertEquals(templateFail + "OSVersion property", expectedUserAgent.getOSVersion(), actualUserAgent.getOSVersion());
        assertEquals(templateFail + "Browser property", expectedUserAgent.getBrowser(), actualUserAgent.getBrowser());
        assertEquals(templateFail + "BrowserVersion property", expectedUserAgent.getBrowserVersion(),
                actualUserAgent.getBrowserVersion());
    }
}
