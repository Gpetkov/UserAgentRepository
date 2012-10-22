package uk.co.newsint.cip.utilities.ua;

import java.io.File;

import org.junit.Test;

public class FileUserAgentParserTest
{

    @Test
    public void testParseAll() throws Exception
    {

        FileUserAgentParser parser = new FileUserAgentParser()
        {
            private final int MAX_ERRORS = 60;
            private int currentError = 0;
            private final int SUM_OCCURRED = 506181634;
            private int currentStringOccurred = 0;

            protected String extractUserAgentString(String line)
            {
                String userAgentString = super.extractUserAgentString(line);
                if (userAgentString == null)
                {
                    return null;
                }
                else
                {
                    //int firstSpace = userAgentString.indexOf(" ");
                    //currentStringOccurred = Integer.valueOf(userAgentString.substring(0, firstSpace));
                   // userAgentString = userAgentString.substring(firstSpace + 1, line.length());
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
                    //System.out.printf("%d  %s userAgentString can't be parsed \n--->This is %.3f%% of all strings.\n", currentError, line,(double)currentStringOccurred/SUM_OCCURRED * 100);
                    System.out.printf("%d  %s userAgentString can't be parsed \n", currentError, line);
                } 
                else 
                {
                    System.out.printf("%s\n", line);
                }
                // lineNumber++;
                // System.out.printf("%d  %s\n",lineNumber,line );
                if (errors == MAX_ERRORS)
                {
                    System.out.println("\nStatistics:\n");
                    System.out.printf(
                            "Count of userAgent strings: %d\nCount of parsed userAgentString : %d\nCount of errors: %d\n", toParse,
                            parsed, errors);
                    throw new RuntimeException("50 errors occured");
                }
                if (parsed >= 100000)
                {
                    System.out.println("\nStatistics:\n");
                    System.out.printf(
                            "Count of userAgent strings: %d\nCount of parsed userAgentString : %d\nCount of errors: %d\n", toParse,
                            parsed, errors);
                }

            }
        };

        parser.parseAll(new File(getClass().getClassLoader().getResource("user_agents.txt").toURI()));
    }

}
