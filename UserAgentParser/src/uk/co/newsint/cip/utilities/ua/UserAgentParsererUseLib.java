package uk.co.newsint.cip.utilities.ua;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class UserAgentParsererUseLib {

	
	
	public UserAgent findUserAgent(File file) throws UserAgentParseException{
		Scanner input = null;
		UserAgent userAgent=new UserAgent();
		try {
			input = new Scanner(file);
			
			
			while(input.hasNextLine()){
				String line = input.nextLine();
				nl.bitwalker.useragentutils.UserAgent ua=nl.bitwalker.useragentutils.UserAgent.parseUserAgentString(line);
				
				}
			
		} catch (FileNotFoundException e) {
			System.out.println("There is not such file!!!");
		} catch (NullPointerException e) {
			System.out.println("File is NULL!!!");			
		}
		finally {
			if(input != null){
				input.close();
			}
		}
		
		return userAgent;
	}
}
	
