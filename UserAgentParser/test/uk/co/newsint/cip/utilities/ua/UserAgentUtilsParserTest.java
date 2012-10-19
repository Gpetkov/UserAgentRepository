package uk.co.newsint.cip.utilities.ua;

import org.junit.Test;


/**
 * Test for UserAgentUtilsParser parsing capabilities
 * 
 * @author Zhivko Kalev
 * @version 1.0
 * @see UserAgentUtilsParser#parse(String)
 */
public class UserAgentUtilsParserTest extends UserAgentParserTest {

	public UserAgentUtilsParserTest() {
		testUserAgentParser = new UserAgentUtilsParser();
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
				new UserAgent("Computer",UserAgent.UNKNOWN,UserAgent.UNKNOWN,UserAgent.UNKNOWN,"Windows","7","MSIE","9.0"));
		
	}

}
