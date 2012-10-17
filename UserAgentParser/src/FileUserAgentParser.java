import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileUserAgentParser extends UserAgentParser{
	
	public String regex = "(blackberry)+?(\\d{2,4}?.*)*?/(\\d+.\\d+.\\d*?.\\d*?)+?((profile/midp-)+?" +
			"(\\d.\\d)+?)*?((configuration/)+?(\\w+?-\\d.\\d)+?)*?((vendorid/)+?\\d+?)*?.*?";

	

	public UserAgent findUserAgent(File file) throws ParseException{
		Scanner input = null;
		UserAgent userAgent = null;
		try {
			input = new Scanner(file);
			Pattern p = Pattern.compile(regex);
			
			while(input.hasNextLine()){
				String line = input.nextLine();
				Matcher m = p.matcher(line);
				if (m.find()){
					String userAgentString = m.toString();
					userAgent = super.parse(userAgentString);
				}
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
