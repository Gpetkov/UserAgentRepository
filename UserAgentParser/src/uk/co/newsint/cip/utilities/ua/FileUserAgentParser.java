package uk.co.newsint.cip.utilities.ua;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUserAgentParser {

	private int toParse;
	private int errors;
	private int parsed;
	  	
	public FileUserAgentParser(){	
		this.toParse = 0;
		this.errors = 0;
		this.parsed = 0;	
	}
 	   	
	/**
	* Searching trough InputStream and parse  	
	* all lines that aren't Null or empty Strings	  	
	*   	
	* @param file	  	
	*/	  	
	public void parseAll(File file) {
		Scanner input = null;
		UserAgent userAgent = null;
		UserAgentParser userAgentParser = new UserAgentParser();

		try {
			input = new Scanner(file);	  	
      		while (input.hasNextLine()) {	  	
				String currentLine = input.nextLine();	  	
				try {	  	
					String userAgentString = extractUserAgentString(currentLine);	  	
					if (userAgentString == null){	  	
						continue;	  	
					}	  	
					userAgent = userAgentParser.parse(userAgentString);	  	
					onUserAgentParsed(currentLine, userAgent, null);	  	
				} catch (UserAgentParseException e) {	  	
          			onUserAgentParsed(currentLine, null, e);
				}
			}	
		} catch (FileNotFoundException e) {	
			System.out.println("There is not such file!!!");	
		} catch (NullPointerException e) {
			System.out.println("File is NULL!!!");  	
    	} finally {  	
      		if (input != null);		
		} 	 
	}

	/**	  	
	* Search if the line is NULL or empty	  	
	* 	  	
	* @param line	  	
	* @return user agent string to parse	  	
	*/	  	
	protected String extractUserAgentString(String line) {	  	
		if ((line == null) || line.trim().length() == 0) {	  	
			return null;	  	
		}	  	
		return line;	  	
	}
	  	
	/** 	
	* Counting errors and parsed Agents	  	
	* 	  	
	* @param line	  	
	* @param User Agent	  	
	* @param ParseExeption	  	
	*/	  	
	protected void onUserAgentParsed(String line, UserAgent userAgent, UserAgentParseException exception) {  	
		this.toParse++;	  	
		if (exception == null){	  	
			this.parsed++;	  	
		} else {	  	
			this.errors++;	  	
		}
	}
}	