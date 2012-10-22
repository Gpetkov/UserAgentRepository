package uk.co.newsint.cip.utilities.ua;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUserAgentParser
{

    protected int toParse;
    protected int errors;
    protected int parsed;

    public FileUserAgentParser()
    {
        this.toParse = 0;
        this.errors = 0;
        this.parsed = 0;
    }

    /**
     * Searching trough text File and parse all lines that aren't Null or empty Strings
     * 
     * @param file
     */
    public void parseAll(File file)
    {
        Scanner input = null;
        UserAgent userAgent = null;
        // RegexpUserAgentParser userAgentParserRegex = new RegexpUserAgentParser();
        // UserAgentUtilsParser userAgentParserUtils = new UserAgentUtilsParser();
        CompositeUserAgentParser compositeUserAgent = new CompositeUserAgentParser();
        try
        {
            input = new Scanner(file);
            while (input.hasNextLine())
            {
                String currentLine = input.nextLine();
                try
                {
                    String userAgentString = extractUserAgentString(currentLine);
                    if (userAgentString == null)
                    {
                        continue;
                    }
                    // userAgent = userAgentParserUtils.parse(userAgentString);
                    // userAgent = userAgentParserRegex.parse(userAgentString);
                    userAgent = compositeUserAgent.parse(userAgentString);
                    onUserAgentParsed(currentLine, userAgent);
                }
                catch (Exception e)
                {
                    onUserAgentParsed(currentLine, null);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There is not such file!!!");
        }
        catch (NullPointerException e)
        {
            System.out.println("File is NULL!!!");
        }
        finally
        {
            if (input != null)
                input.close();
        }

    }

    /**
     * Search if the line is NULL or empty
     * 
     * @param line
     * @return user agent string to parse
     */
    protected String extractUserAgentString(String line)
    {
        if ((line == null) || line.trim().length() == 0)
        {
            return null;
        }

        return line;
    }

    /**
     * Counting errors and parsed Agents
     * 
     * @param line
     * @param User Agent
     */
    protected void onUserAgentParsed(String line, UserAgent userAgent)
    {
        this.toParse++;
        if (isReliable(userAgent))
        {
            this.parsed++;
        }
        else
        {
            this.errors++;
        }
    }
    
    /**
     * Method which verifies whether the Composite's parse method is reliable 
     * 
     * @param UserAgent
     * @return true/false
     * @see CompositeUserAgentParser#parse(String)
     * {@link CompositeUserAgentParser}
     */
    protected boolean isReliable(UserAgent currentUserAgent){
        if( ( UserAgent.UNKNOWN.equals( currentUserAgent.getDeviceType() ) ||  
                UserAgent.UNKNOWN.equals( currentUserAgent.getBrowser() ) ) && 
                ( ( UserAgent.UNKNOWN.equals( currentUserAgent.getOS() ) ) ) ){
           return false;
        }
        
        return true;
    }
}
