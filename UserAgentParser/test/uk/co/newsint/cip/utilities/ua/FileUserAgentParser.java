package uk.co.newsint.cip.utilities.ua;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
     * @throws IOException
     */
    public void parseAll(File file) throws IOException
    {
        UserAgent userAgent = null;
        CompositeUserAgentParser compositeUserAgent = new CompositeUserAgentParser();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String currentLine;
            while ((currentLine = reader.readLine()) != null)
            {
                try
                {
                    String userAgentString = extractUserAgentString(currentLine);
                    if (userAgentString == null)
                    {
                        continue;
                    }
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
            if (reader != null)
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    // do nothing
                }
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
     * @see CompositeUserAgentParser#parse(String) {@link CompositeUserAgentParser}
     */
    protected boolean isReliable(UserAgent currentUserAgent)
    {
        return !((UserAgent.UNKNOWN.equals(currentUserAgent.getDeviceType()))
                || (UserAgent.UNKNOWN.equals(currentUserAgent.getBrowser())) || ((UserAgent.UNKNOWN
                    .equals(currentUserAgent.getOS()))));
    }
}
