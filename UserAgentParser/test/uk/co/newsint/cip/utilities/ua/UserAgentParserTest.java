package uk.co.newsint.cip.utilities.ua;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * The UserAgentParserTest class represents a test for UserAgentParser class's
 * methods
 * 
 * @author Georgi Petkov
 * @version 1.0
 * @since 2012-10-12
 * @see UserAgentParser#parse(String)
 */
public class UserAgentParserTest {

	/**
	 * Instance of type UserAgentParser which method "parse" we're using
	 * 
	 */
	protected static UserAgentParser testUserAgentParser = new UserAgentParser() {
	};

	/**
	 * Methods which test the different cases for user agent string
	 * 
	 * @see UserAgentParser#parse(String)
	 * 
	 */
	/**
	 * Test method for BlackBerry
	 * 
	 */
	@Test
	public void testBlackBerryParse() throws Exception {

		// Assert for version 4.
		assertUserAgentEquals(
				"BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301",
				new UserAgent(UserAgent.SMARTPHONE,"BlackBerry","8520","8520","OS4","4.6.1.314",UserAgent.UNKNOWN,UserAgent.UNKNOWN));
	
		// Assert for version 5.
		assertUserAgentEquals(
				"BlackBerry9105/5.0.0.748 Profile/MIDP-2.1 Configuration/CLDC-1.1 VendorID/125",
				new UserAgent(UserAgent.SMARTPHONE,"BlackBerry","9105","9105","OS5","5.0.0.748",UserAgent.UNKNOWN,UserAgent.UNKNOWN));
		// Assert for version 6.
		assertUserAgentEquals(
				"BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/310 The Times/1.0",
				new UserAgent(UserAgent.SMARTPHONE,"BlackBerry","9300","9300","OS6","6.6.0.124",UserAgent.UNKNOWN,UserAgent.UNKNOWN));

		// Assert for version 9.
		assertUserAgentEquals(
				"BlackBerry9320/9.49.0.31 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/118 The Times/1.0",
				new UserAgent(UserAgent.SMARTPHONE,"BlackBerry","9320","9320","OS9","9.49.0.31",UserAgent.UNKNOWN,UserAgent.UNKNOWN));

		// Expected Our custom ParseException
		assertUserAgentException("BlackBerri9320/9.49.0.31 Profile");
	}

	/**
	 * Test method for Apple
	 * 
	 */
	@Test
	public void testAppleParse() throws Exception {
		// Assertion for IPhone
		assertUserAgentEquals(
				"Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_3 like Mac OS X; ja-JP)"
						+ " Times/1.0.2,platform,unknown", 
						new UserAgent(UserAgent.SMARTPHONE,"Apple","iPhone","iPhone","iOS","4.3.3",UserAgent.UNKNOWN,UserAgent.UNKNOWN));
		// Assertion for IPhone
		assertUserAgentEquals(
				"Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_5 like Mac OS X; ca-es) "
						+ "AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8L1 "
						+ "Safari/6533.18.5,platform,unknown", 
						new UserAgent(UserAgent.SMARTPHONE,"Apple","iPhone","iPhone","iOS","4.3.5",UserAgent.UNKNOWN,UserAgent.UNKNOWN));

		// Assertion for iPad
		assertUserAgentEquals(
				"Mozilla/5.0 (iPad; CPU OS 5_1_1 like Mac OS X; de-de) AppleWebKit/534.46.0 (KHTML, like Gecko) "
						+ "CriOS/21.0.1180.77 Mobile/9B206 Safari/7534.48.3,platform,unknown",
						new UserAgent(UserAgent.TABLET,"Apple","iPad","iPad","iOS","5.1.1",UserAgent.UNKNOWN,UserAgent.UNKNOWN));
		// Assertion for iPad
		assertUserAgentEquals(
				"Mozilla/5.0 (iPad; U; CPU OS 4_2_1 like Mac OS X; it-it) AppleWebKit/533.17.9 "
						+ "(KHTML, like Gecko) Version/5.0.2 Mobile/8C148 Safari/6533.18.5,platform,unknown",
						new UserAgent(UserAgent.TABLET,"Apple","iPad","iPad","iOS","4.2.1",UserAgent.UNKNOWN,UserAgent.UNKNOWN));
		// Assertion for iPod
		assertUserAgentEquals(
				"Mozilla/5.0 (iPod touch; U; CPU iPhone OS 5_1_1 like Mac OS X; zh-CN) "
						+ "Times/1.2.1,platform,unknown",
						new UserAgent(UserAgent.SMARTPHONE,"Apple","iPod touch","iPod touch","iOS","5.1.1",UserAgent.UNKNOWN,UserAgent.UNKNOWN));
		// Assertion for iPod
		assertUserAgentEquals(
				"Mozilla/5.0 (iPod; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) "
						+ "Version/5.1 Mobile/9A334 Safari/7534.48.3,platform,unknown",
						new UserAgent(UserAgent.SMARTPHONE,"Apple","iPod","iPod","iOS","5.0",UserAgent.UNKNOWN,UserAgent.UNKNOWN));
		// Expected Our custom ParseException
		assertUserAgentException("Mozilla/5.0 (iPhone; U; CPU like Mac OS X; ja-JP)"
				+ " Times/1.0.2,platform,unknown");
		// Expected Our custom ParseException
		// assertUserAgentException(null);

	}

	/**
	 * Test method for Android
	 * 
	 */
	
	@Test
	public void testAndroidParse() throws Exception {

	}

	/**
	 * Test method for PC
	 * 
	 */
	@Test
	public void testPCParse() throws Exception {
		// Assertion for Internet Explorer browser
		assertUserAgentEquals(
				"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)",
				new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","6.1","MSIE","9.0"));
		// Assertion for Internet Explorer
		assertUserAgentEquals(
				"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)",
				new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","6.1","MSIE","9.0"));
		// Assertion for Chrome browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 4.0) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.5 "
						+ "Safari/534.30,platform,unknown", 
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","4.0","Chrome","12.0.742.5"));
		// Assertion for Chrome browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 5.0) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.77 Safari/537.1,platform,unknown",
				new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.0","Chrome","21.0.1180.77"));
		// Assertion for Firefox browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.4) Gecko/2008102920 Firefox/3.0.4,platform,unknown", 
				new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Firefox","3.0.4"));
		// Assertion for Firefox browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.19) Gecko/2010031422 YFF3 "
						+ "Firefox/3.0.19,platform,unknown", 
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Firefox","3.0.19"));
		// Assertion for Firefox browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.13) Gecko/20100914 "
						+ "update/105618 Firefox/3.5.13,platform,unknown",
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Firefox","3.5.13"));
		// Assertion for Firefox browser Bot
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-GB; rv:1.9.2.24) Gecko/20111103 AskTbFTB/3.14.1.20007 "
						+ "Firefox/3.6.24 (.NET CLR 3.5.30729),platform,unknown",
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Firefox","3.6.24"));
		// Assertion for Firefox Bot
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2) Gecko/20100115 AskTbARS/3.15.1.22229 "
						+ "Firefox/3.6,platform,unknown", 
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Firefox","3.6"));
		// Assertion for Iron browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Iron/12.0.750.0 "
						+ "Chrome/12.0.750.0 Safari/534.30,platform,unknown",
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Iron","12.0.750.0"));
		// Assertion for Comodo_Dragon browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Comodo_Dragon/12.1.0.0 "
						+ "Chrome/12.0.742.91 Safari/534.30,platform,unknown",
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Comodo_Dragon","12.1.0.0"));
	/*	// Assertion for Comodo_Dragon browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/534.30 (KHTML, like Gecko) Comodo_Dragon/12.2.0.0 "
						+ "Chrome/12.0.742.112 Safari/534.30,platform,unknown",
						new UserAgent(UserAgent.PC,UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows NT","5.1","Comodo_Dragon","12.1.0.0"));
		// Assertion for Maxthon browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.0 Chrome/18.0.966.0 "
						+ "Safari/535.122,platform,unknown", new UserAgent(
						UserAgent.UNKNOWN, "Maxthon", "3.0", "Windows NT",
						"5.1", UserAgent.PC));
		// Assertion for Maxthon browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.3.6.2000 "
						+ "Chrome/18.0.966.0 Safari/535.12 AppEngine-Google; (+http://code.google.com/appengine; "
						+ "appid: s~popi0391),platform,unknown", new UserAgent(
						UserAgent.UNKNOWN, "Maxthon", "3.3.6.2000",
						"Windows NT", "5.1", UserAgent.PC));
		// Assertion for RockMelt browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 5.2; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) RockMelt/0.16.91.483 Chrome/16.0.912.77 Safari/535.7,platform,unknown",
				new UserAgent(UserAgent.UNKNOWN, "RockMelt", "0.16.91.483",
						"Windows NT", "5.2", UserAgent.PC));
		// Assertion for Safari browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.51.22 (KHTML, like Gecko) Version/5.0.2 "
						+ "Safari/533.18.5,platform,unknown", new UserAgent(
						UserAgent.UNKNOWN, "Safari", "533.18.5", "Windows NT",
						"6.1", UserAgent.PC));
		// Assertion for Safari browser
		assertUserAgentEquals(
				"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 "
						+ "Safari/534.57.2,platform,unknown", new UserAgent(
						UserAgent.UNKNOWN, "Safari", "534.57.2", "Windows NT",
						"6.1", UserAgent.PC));
		// Assertion for Safari browser for Macintosh
		assertUserAgentEquals(
				"101653 Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_4) AppleWebKit/534.57.2 (KHTML, like Gecko) "
						+ "Version/5.1.7 Safari/534.57.2", new UserAgent(
						"Apple", "Safari", "534.57.2", "Mac OS X", "10_7_4",
						UserAgent.PC));
		// Assertion for Firefox browser for Macintosh
		assertUserAgentEquals(
				"Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-US; rv:1.8.1.12) Gecko/20080219 Firefox/2.0.0.12 " +
				"Navigator/9.0.0.6,platform,unknown",
				new UserAgent("Apple", "Firefox", "2.0.0.12", "OS X",
						"", UserAgent.PC));
*/
	}

	/**
	 * Method which makes asserts for for every of the UserAgent's properties
	 * (equal for every of the properties)
	 * 
	 * @see UserAgentParser#parse(String)
	 * 
	 */
	
	protected void assertUserAgentEquals(String userAgentString,
			UserAgent expectedUserAgent) throws Exception {
		UserAgent actualUserAgent = testUserAgentParser.parse(userAgentString);
		assertNotNull("Expected UserAgent, but the method returns null",
				actualUserAgent);
		String templateFail = userAgentString + " >>> ";
		assertEquals(templateFail + "deviceType property",
				expectedUserAgent.getDeviceType(), actualUserAgent.getDeviceType());
		assertEquals(templateFail + "deviceMaker property",
				expectedUserAgent.getDeviceMaker(), actualUserAgent.getDeviceMaker());
		assertEquals(templateFail + "deviceModel property",
				expectedUserAgent.getDeviceModel(), actualUserAgent.getDeviceModel());
		assertEquals(templateFail + "deviceModelVersion property",
				expectedUserAgent.getDeviceModelVersion(),
				actualUserAgent.getDeviceModelVersion());
		assertEquals(templateFail + "OS property",
				expectedUserAgent.getOS(), actualUserAgent.getOS());
		assertEquals(templateFail + "OSVersion property",
				expectedUserAgent.getOSVersion(),
				actualUserAgent.getOSVersion());
		assertEquals(templateFail + "Browser property",
				expectedUserAgent.getBrowser(),
				actualUserAgent.getBrowser());
		assertEquals(templateFail + "BrowserVersion property",
				expectedUserAgent.getBrowserVersion(),
				actualUserAgent.getBrowserVersion());
	}

	/**
	 * Method which pass to the "parse" method null string or not userAgent
	 * string and expects instance of UserAgentParseException
	 * 
	 * @see UserAgentParseException
	 * 
	 */
	
	protected void assertUserAgentException(String userAgentString) {
		try {
			testUserAgentParser.parse(userAgentString);
			fail("The method didn't throw ParseException when we use not userAgent string");
		} catch (UserAgentParseException e) {
			// I expect this exception --> do nothing
		}

	}

}
