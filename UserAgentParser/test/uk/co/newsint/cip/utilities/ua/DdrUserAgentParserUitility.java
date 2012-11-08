package uk.co.newsint.cip.utilities.ua;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DdrUserAgentParserUitility extends FileUserAgentParser
{
    @Override
    public void parseAll(File file) throws IOException
    {
        UserAgent userAgent = null;
        DdrUserAgentParser ddrUserAgentParser = new DdrUserAgentParser();
        BufferedReader reader = null;
        String currentLine = null;

        try
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((currentLine = reader.readLine()) != null)
            {
                try
                {
                    String userAgentString = extractUserAgentString(currentLine);
                    if (userAgentString == null)
                    {
                        continue;
                    }
                    userAgent = ddrUserAgentParser.parse(userAgentString);
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
            System.out.printf("------------------------- %s\n", currentLine);
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

    // page hits for the current user-agent string in "top_1000_user_agents.txt"
    private int pageViewHit;
    // user-agent string from "top_1000_user_agents.txt" without it's page hits
    private String currentUserAgentString;

    @Override
    protected String extractUserAgentString(String line)
    {
        String userAgentString = super.extractUserAgentString(line);
        if (userAgentString != null)
        {
            int firstSpace = userAgentString.indexOf(" ");
            String subUserAgentString = userAgentString.substring(firstSpace + 1, line.length());
            String pageHitString = userAgentString.substring(0, firstSpace);
            if (pageHitString != null)
            {
                this.pageViewHit = Integer.valueOf(userAgentString.substring(0, firstSpace));
            }
            else
            {
                this.pageViewHit = 0;
            }

            if (subUserAgentString != null)
            {
                this.currentUserAgentString = "\"" + subUserAgentString + "\"";
            }
            else
            {
                this.currentUserAgentString = null;
            }
        }
        return userAgentString;
    };

    @Override
    protected void onUserAgentParsed(String line, UserAgent userAgent)
    {
        super.onUserAgentParsed(line, userAgent);
        generateCsvFileContent(this.toParse, line, userAgent);
    }

    /**
     * Main method which read the "top_1000_user-agents.txt" file and parse every user-agent string in it
     * 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        // Instance of this class
        DdrUserAgentParserUitility userAgentUtility = new DdrUserAgentParserUitility();
        // Create a file
        userAgentUtility.createFile();
        // Parsing the user-agent strings from "top_1000_user-agents.txt"
        userAgentUtility.parseAll(new File(FileUserAgentParserUtility.class.getClassLoader()
                .getResource("top_1000_user-agents.txt").toURI()));
    }

    protected void createFile()
    {
        try
        {
            FileWriter writer = new FileWriter("top_1000_DdrUserAgentsParsed.csv");
            // Adding header fields
            writer.append("PAGE HITS");
            writer.append(",");
            writer.append("USER-AGENT-STRING");
            writer.append(",");
            writer.append("DEVICE TYPE");
            writer.append(",");
            writer.append("DEVICE MAKER");
            writer.append(",");
            writer.append("DEVICE MODEL");
            writer.append(",");
            writer.append("DEVICE MODEL VERSION");
            writer.append(",");
            writer.append("DEVICE DISPLAY WIDTH");
            writer.append(",");
            writer.append("DEVICE DISPLAY HEIGHT");
            writer.append(",");
            writer.append("DEVICE DISPLAY RESOLUTION");
            writer.append(",");
            writer.append("OS");
            writer.append(",");
            writer.append("OS VERSION");
            writer.append(",");
            writer.append("OS MAKER");
            writer.append(",");
            writer.append("BROWSER");
            writer.append(",");
            writer.append("BROWSER VERSION");
            writer.append(",");
            writer.append("APPLICATION");
            writer.append(",");
            writer.append("APPLICATION VERSION");
            writer.append(",");
            writer.append("LANGUAGE CODE");
            writer.append(",");
            writer.append("COUNTRY CODE");
            writer.append(",");
            writer.append("UNKNOWN PROPERTIES");
            writer.append("\n");
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected void generateCsvFileContent(int lineNumber, String userAgentString, UserAgent currentUserAgent)
    {
        // Counter for properties with Unknown value
        int counterUnknown = 0;
        try
        {
            FileWriter writer = new FileWriter("top_1000_DdrUserAgentsParsed.csv", true);
            // Adding page hits for the current string
            writer.append(String.valueOf(this.pageViewHit));
            writer.append(',');
            // Adding current string for parse
            writer.append(this.currentUserAgentString);
            writer.append(',');
            // Adding result after parse (result agent's properties)
            writer.append(currentUserAgent.getDeviceType());
            writer.append(',');
            writer.append(currentUserAgent.getDeviceMaker());
            writer.append(',');
            writer.append(currentUserAgent.getDeviceModel());
            writer.append(',');
            writer.append(currentUserAgent.getDeviceModelVersion());
            writer.append(',');
            writer.append(currentUserAgent.getDisplayWidth());
            writer.append(',');
            writer.append(currentUserAgent.getDisplayHeight());
            writer.append(',');
            writer.append(currentUserAgent.getDisplayResolution());
            writer.append(',');
            writer.append(currentUserAgent.getOS());
            writer.append(',');
            writer.append(currentUserAgent.getOSVersion());
            writer.append(',');
            writer.append(currentUserAgent.getOSMaker());
            writer.append(',');
            writer.append(currentUserAgent.getBrowser());
            writer.append(',');
            writer.append(currentUserAgent.getBrowserVersion());
            writer.append(',');
            writer.append(currentUserAgent.getApplication());
            writer.append(',');
            writer.append(currentUserAgent.getApplicationVersion());
            writer.append(',');
            writer.append(currentUserAgent.getLanguageCode());
            writer.append(',');
            writer.append(currentUserAgent.getCountryCode());
            // Check the properties for Unknown values
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getDeviceType()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getDeviceMaker()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getDeviceModel()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getDeviceModelVersion()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getDisplayWidth()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getDisplayHeight()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getDisplayResolution()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getOS()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getOSVersion()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getBrowser()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getBrowserVersion()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getApplication()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getApplicationVersion()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getLanguageCode()))
            {
                counterUnknown++;
            }
            if (UserAgent.UNKNOWN.equals(currentUserAgent.getCountryCode()))
            {
                counterUnknown++;
            }
            // Adding in file the count of properties which are Unknown
            writer.append(',');
            writer.append(String.valueOf(counterUnknown));
            writer.append("\n");
            // flush and close the writer
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
