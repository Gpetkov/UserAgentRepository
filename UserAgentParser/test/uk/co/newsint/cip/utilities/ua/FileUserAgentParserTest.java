package uk.co.newsint.cip.utilities.ua;

import java.io.File;

import org.junit.Test;

public class FileUserAgentParserTest {

	@Test
	public void testParseAll() {
		
		FileUserAgentParser parser = new FileUserAgentParser() {
			private final int MAX_ERRORS = 158;
			private int currentError = 0;
			protected String extractUserAgentString(String line) {
				String userAgentString = super.extractUserAgentString(line);
				if (userAgentString == null){
					return null;
				}else{
					int firstSpace = userAgentString.indexOf(" ");
					userAgentString = userAgentString.substring(firstSpace+1, line.length());
				}
				
				return userAgentString;
				
			};
			
			@Override
			protected void onUserAgentParsed(String line, UserAgent userAgent,
					UserAgentParseException exception) {
				super.onUserAgentParsed(line, userAgent, exception);
				if(exception != null){
					currentError++;
					System.out.printf("%d  %s\n",currentError,line);
				}
				if (errors == MAX_ERRORS){
					System.out.println("\nStatistics:\n");
					System.out.printf("Count of userAgent strings: %d\nCount of parsed userAgentString : %d\nCount of errors: %d\n", toParse, parsed,errors);
					throw new RuntimeException("50 errors occured");
				}
					
			}
		};
		
		try{
			parser.parseAll(new File("resources\\top_1000_user-agents.txt"));
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
		
		
	}

}