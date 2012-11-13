package uk.co.newsint.cip.utilities.ua;

import java.io.File;

import org.junit.Test;

/**
 * The {@link FileUserAgentParserTest} class represents a test for {@link FileUserAgentParser} parse method It creates statistics
 * i.e. which strings can be parsed and which one can't be.
 * 
 * @author Georgi Petkov
 * @since 1.0
 * @see CompositeUserAgentParser#parse(String)
 */
public class FileUserAgentParserTest
{
    /**
     * Test for the "user_agents.txt" file
     * 
     * @see FileUserAgentParser#parseAll(File)
     * @throws Exception
     */
    @Test
    public void testParseAll() throws Exception
    {
        FileUserAgentParser parser = new FileUserAgentParser()
        {
            private final int MAX_ERRORS = 1742;
            private int currentError = 0;

            @Override
            protected void onUserAgentParsed(String line, UserAgent userAgent)
            {
                super.onUserAgentParsed(line, userAgent);
                if (!isReliable(userAgent))
                {
                    currentError++;
                    if (currentError == 1)
                    {
                        System.out.println("Starting list of strings which we can't parse:");
                        System.out.println("-----------------------------------");
                    }
                    System.out.printf("Error/%d:  %s userAgentString can't be parsed \n", currentError, line);
                }
                if (errors == MAX_ERRORS)
                {
                    System.out.println("-----------------------------------");
                    System.out.println("\nStatistics for all userAgent strings:\n");
                    System.out.printf(
                            "Count of userAgent strings: %d\nCount of parsed userAgentString : %d\nCount of errors: %d\n\n",
                            toParse, parsed, errors);
                    System.out.println("-----------------------------------");
                }
            }
        };
        parser.parseAll(new File(getClass().getClassLoader().getResource("user_agents.txt").toURI()));
    }

    /**
     * Test for the "top_1000_user-agents.txt" file
     * 
     * @see FileUserAgentParser#parseAll(File)
     * @throws Exception
     */

    @Test
    public void testParseTopUserAgents() throws Exception
    {
        FileUserAgentParser parser = new FileUserAgentParser()
        {
            private int currentError = 0;
            private final int SUM_OCCURRED = 506181634;
            private int currentStringOccurred = 0;

            @Override
            protected String extractUserAgentString(String line)
            {
                String userAgentString = super.extractUserAgentString(line);
                if (userAgentString != null)
                {
                    int firstSpace = userAgentString.indexOf(" ");
                    currentStringOccurred = Integer.valueOf(userAgentString.substring(0, firstSpace));
                    userAgentString = userAgentString.substring(firstSpace + 1, line.length());
                }
                return userAgentString;
            };

            @Override
            protected void onUserAgentParsed(String line, UserAgent userAgent)
            {
                super.onUserAgentParsed(line, userAgent);
                if (!isReliable(userAgent))
                {
                    currentError++;
                    if (currentError == 1)
                    {
                        System.out.printf("\n\nTEST FOR TOP 1000 USER AGENTS\nStarting list of strings which we can't parse:\n");
                        System.out.println("-----------------------------------");
                    }
                    System.out.printf("line/%d  %s userAgentString can't be parsed \n--->This is %.3f%% of all strings.\n",
                            currentError, line, (double) currentStringOccurred / SUM_OCCURRED * 100);
                }
                if (parsed >= 999)
                {
                    System.out.println("-----------------------------------");
                    System.out.println("\nStatistics for top 1000 userAgent strings:\n");
                    System.out.printf(
                            "Count of userAgent strings: %d\nCount of parsed userAgentString : %d\nCount of errors: %d\n\n",
                            toParse, parsed, errors);
                    System.out.println("-----------------------------------");
                }
            }
        };
        parser.parseAll(new File(getClass().getClassLoader().getResource("top_1000_user-agents.txt").toURI()));
    }
}
