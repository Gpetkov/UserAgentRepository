package uk.co.newsint.cip.utilities.ua;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Test for UserAgentUtilsParser parsing capabilities
 * 
 * @author Zhivko Kalev
 * @version 1.0
 * @see UserAgentUtilsParser#parse(String)
 */
public class UserAgentUtilsParserTest extends UserAgentParserTest
{

    public UserAgentUtilsParserTest()
    {
        testUserAgentParser = new UserAgentUtilsParser();
    }

    /**
     * Test method for PC
     * 
     */
    @Test
    public void testPCParse() throws Exception
    {
        // Assertion for Internet Explorer browser
        assertUserAgentEquals2("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)",
                new UserAgent(UserAgent.COMPUTER, UserAgent.UNKNOWN, UserAgent.UNKNOWN, UserAgent.UNKNOWN, "Windows",
                        UserAgent.UNKNOWN, "Internet Explorer 9", "9.0"));

    }

    protected void assertUserAgentEquals2(String userAgentString, UserAgent expectedUserAgent) throws Exception
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
