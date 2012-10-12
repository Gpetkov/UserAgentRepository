import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserAgentParserTest {

	UserAgentParser testUserAgentParser = new UserAgentParser() {
	};
	ParseExeption testParseException = new ParseExeption();
	String input = "BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301,platform,unknown";
	String input1 = "BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/310 The Times/1.0,platform,unknown";
	String input2 = "BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/609 The Times/1.0 UP.Link/6.5.1.3.0,platform,unknown";
	UserAgent result = new UserAgent("BlackBerry", "", "", "", "");

	@Test
	public void testParse() {
		// assertEquals("Result ", (Object)result,(Object)
		// testUserAgentParser.parse(input));
		assertEquals("", result, testUserAgentParser.parse(null));
		assertEquals("", result, testUserAgentParser.parse(input));
		assertEquals("", result, testUserAgentParser.parse(input1));
		assertEquals("", testParseException, testUserAgentParser.parse(input2));

	}
	/*
	 * @Test public void testParse1() { assertEquals("", null,
	 * testUserAgentParser.parse(input2)); }
	 * 
	 * @Test public void testParse2() { assertEquals("", result,
	 * testUserAgentParser.parse(null)); }
	 * 
	 * @Test public void testParse3() { assertEquals("", result,
	 * testUserAgentParser.parse(input1)); }
	 * 
	 * @Test public void testParse4() { assertEquals("", result,
	 * testUserAgentParser.parse(input)); }
	 */
}
