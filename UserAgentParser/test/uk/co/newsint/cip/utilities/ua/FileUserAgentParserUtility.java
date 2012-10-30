package uk.co.newsint.cip.utilities.ua;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUserAgentParserUtility extends FileUserAgentParser
{
    @Override
    protected String extractUserAgentString(String line)
    {
        String userAgentString = super.extractUserAgentString(line);
        if (userAgentString != null)
        {
            int firstSpace = userAgentString.indexOf(" ");
            userAgentString = userAgentString.substring(firstSpace + 1, line.length());
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
     */
    public static void main(String[] args) throws Exception
    {
        // Instance of this class
        FileUserAgentParserUtility userAgentUtility = new FileUserAgentParserUtility();
        userAgentUtility.createFile();
        userAgentUtility.parseAll(new File("resources\\top_1000_user-agents.txt"));
    }

    /**
     * This method create a CSV file and adding in it header fields
     * 
     */
    private void createFile()
    {
        try
        {
            FileWriter writer = new FileWriter("ParserResults.txt");

            // Adding header fields
            writer.append("LINE NUMBER");
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
            writer.append("OS");
            writer.append(",");
            writer.append("OS VERSION");
            writer.append(",");
            writer.append("BROWSER");
            writer.append(",");
            writer.append("BROWSER VERSION");
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

    /**
     * Method which add the result of parsing for every User-Agent-String After parsing the current user-agent string we write the
     * result in CSV file
     * 
     * @param lineNumber,userAgentString,currentUserAgent
     */
    private void generateCsvFileContent(int lineNumber, String userAgentString, UserAgent currentUserAgent)
    {
        // Counter for properties with Unknown value
        int counterUnknown = 0;
        try
        {
            FileWriter writer = new FileWriter("ParserResults.txt", true);

            // Adding number of current line
            writer.append(String.valueOf(lineNumber));
            writer.append(',');

            // Adding current string for parse
            writer.append(userAgentString);
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
            writer.append(currentUserAgent.getOS());
            writer.append(',');
            writer.append(currentUserAgent.getOSVersion());
            writer.append(',');
            writer.append(currentUserAgent.getBrowser());
            writer.append(',');
            writer.append(currentUserAgent.getBrowserVersion());

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
