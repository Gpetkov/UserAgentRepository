import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;




public class UserAgentParserTest {
	public final String agentString1 = "BlackBerry8520/4.6.1.314 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/301,platform,unknown";
	public final String agentString2 = "BlackBerry9300/6.6.0.124 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/310 The Times/1.0,platform,unknown";
	public final String agentString3 = null;
	public final String agentString4 ="adsasdsas";
	public final String agentString5 ="BlackBerry9105/6.6.0.200 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/332 The Times/1.0,platform,unknown";
	public final String agentString6 = "BlackBerry9105/5.0.0.748 Profile/MIDP-2.1 Configuration/CLDC-1.1 VendorID/125,platform,unknown";
	//public final String agentString7 = "BlackBerry9320/9.49.0.31 Profile/MIDP-2.0 Configuration/CLDC-1.1 VendorID/118 The Times/1.0,platform,unknown";
	public final String agentString8 = "BlackBerry8520/4.6.1.314 Configuration/CLDC-1.1 VendorID/603Profile/MIDP-2.0 ,platform,unknown";
	private static UserAgentParser testUserAgentParser = new UserAgentParser() {};
	
	
	@Test
	public void testParse() throws Exception {
		// assertEquals("Result ", (Object)result,(Object)
		// testUserAgentParser.parse(input));
	//	assertEquals("Test with null string", result, testUserAgentParser.parse(null));
		assertEquals("The regular expression didn't find the same user agent!", new UserAgent("BlackBerry", 
				"8520", "8520", "OS4", "4.6.1.314", UserAgent.DeviceType.SMARTPHONE),
				testUserAgentParser.parse(agentString1));
		assertEquals("The method doesn't return null!",new UserAgent("BlackBerry", 
				"9300", "9300", "OS6", "6.6.0.124", UserAgent.DeviceType.SMARTPHONE),
				testUserAgentParser.parse(agentString2));
		//assertEquals("The method doesn't return null!",new ParseException(),
		//		testUserAgentParser.parse(agentString3));
		 //assertTh("Didn't return our exception",new ParseException("UA not found!"), testUserAgentParser.parse(agentString3));
		
		assertEquals("The method doesn't return null!",new UserAgent("BlackBerry", 
				"9105", "9105", "OS6", "6.6.0.200", UserAgent.DeviceType.SMARTPHONE),
				testUserAgentParser.parse(agentString5));
		
		
		assertEquals("The method doesn't return null!",new UserAgent("BlackBerry", 
				"9105", "9105", "OS5", "5.0.0.748", UserAgent.DeviceType.SMARTPHONE),
				testUserAgentParser.parse(agentString6));
		
		
		
		try{
			testUserAgentParser.parse(agentString4);
			fail("My method didn't throw my custom exception when I expected it to");
		}catch(ParseException e){
			
		}
		
		try{
			testUserAgentParser.parse(agentString3);
			fail("My method didn't throw null pointer exception when I expected it to");
		}catch(NullPointerException e){}
		
	//	assertEquals("The method doesn't return null!",new UserAgent("BlackBerry", 
	//			"9320", "9320", "OS9", "9.49.0.31", UserAgent.DeviceType.TABLET),
	//			testUserAgentParser.parse(agentString7));
		
		try{
			assertEquals("The method doesn't return null!",new UserAgent("BlackBerry", 
					"8520", "8520", "OS4", "4.6.1.314", UserAgent.DeviceType.SMARTPHONE),
					testUserAgentParser.parse(agentString8));
			fail("My method didn't throw my custom exception when I pass incorect string");
		}catch(ParseException e){
			
		}
		
		
	}
}
