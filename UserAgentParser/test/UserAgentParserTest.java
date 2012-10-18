import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import uk.co.newsint.cip.utilities.ua.UserAgent;
import uk.co.newsint.cip.utilities.ua.UserAgentParseException;
import uk.co.newsint.cip.utilities.ua.UserAgentParser;

@RunWith(Parameterized.class)
public class UserAgentParserTest {
	//private static final String input = "BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301,platform,unknown";
	//private static final String input1 = "BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/310 The Times/1.0,platform,unknown";
	//private static final String input2 = "BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/609 The Times/1.0 UP.Link/6.5.1.3.0,platform,unknown";
	
	private static String userAgentString;
	private static UserAgentParseException userAgentParseException;
	private static UserAgent expectedUserAgent;
	//private static UserAgent actualUserAgent;
	private static UserAgentParser testUserAgentParser;
	@BeforeClass
	public static void setUpBeforeClass()throws Exception{
		//userAgentParseException = new UserAgentParseException();
		//expectedUserAgent = new UserAgent("BlackBerry", "BlackBerry8520", "8520", "OS4", "4.6.1.314", UserAgent.DeviceType.SMARTPHONE);
		testUserAgentParser = new UserAgentParser() {};
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		userAgentParseException = null;
		expectedUserAgent = null;
		testUserAgentParser = null;
		userAgentString = null;
		//actualUserAgent = null;
	}
	
	public UserAgentParserTest(String currentUserAgentString, UserAgent currentExpectedUserAgent, UserAgentParseException currentException){
		userAgentString = currentUserAgentString;
		expectedUserAgent = currentExpectedUserAgent;
		userAgentParseException = currentException;
	}
	
	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection parserTestExValues(){
		Object[][] exeValues = {{"BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301,platform,unknown",
			new UserAgent("BlackBerry", "8520", "8520", "OS4", "4.6.1.314", UserAgent.DeviceType.SMARTPHONE),
			new UserAgentParseException()},
			{"BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/310 The Times/1.0,platform,unknown",
				new UserAgent("BlackBerry", "9300", "9300", "OS6", "6.6.0.124", UserAgent.DeviceType.SMARTPHONE),
				new UserAgentParseException()},
				{"BlackBerry8520/Profile/MIDP-2.1 Configuration/CLDC-1.1 VendorID/115,platform,unknown",
					new UserAgent("BlackBerry", "9300", "9300", "OS6", "6.6.0.124", UserAgent.DeviceType.SMARTPHONE),
					new UserAgentParseException()},
				{null,
					new UserAgent("BlackBerry", "9300", "9300", "OS6", "6.6.0.124", UserAgent.DeviceType.SMARTPHONE),
					new UserAgentParseException()}};
					
		return Arrays.asList(exeValues);
	}
	 
	//UserAgentParseException testParseException = new UserAgentParseException();
	
	//UserAgent result = new UserAgent("BlackBerry", "BlackBerry8520", "8520", "OS4", "4.6.1.314", UserAgent.DeviceType.SMARTPHONE);

	@Test
	public void testParse() throws Exception {
		// assertEquals("Result ", (Object)result,(Object)
		// testUserAgentParser.parse(input));
	//	assertEquals("Test with null string", result, testUserAgentParser.parse(null));
		assertEquals("The regular expression didn't find the same user agent!", expectedUserAgent, testUserAgentParser.parse(userAgentString));
		testUserAgentParser.parse(userAgentString);
		//assertEquals("The regular expression didn't find the same user agent!", userAgentParseException, testUserAgentParser.parse(userAgentString));
	//	assertEquals("Test2", null, testUserAgentParser.parse(input1));
	//	assertEquals("", testParseException, testUserAgentParser.parse(input2));
		
	}
	
	@Test(expected=UserAgentParseException.class)
	public void testUserAgentParserException() throws Exception{
		testUserAgentParser.parse(userAgentString);
	}
	
	
	//private static final 
}
