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
            private final int MAX_ERRORS = 1;
            private int currentError = 0;
            private int lineNumber = 0;

            protected String extractUserAgentString(String line)
            {
                lineNumber++;
                String userAgentString = super.extractUserAgentString(line);
                if (userAgentString == null)
                {
                    return null;
                }
                else
                {
                    int firstSpace = userAgentString.indexOf(" ");
                    userAgentString = userAgentString.substring(firstSpace + 1, line.length());
                }
                return userAgentString;

            };

            @Override
            protected void onUserAgentParsed(String line, UserAgent userAgent, Exception exception)
            {
                super.onUserAgentParsed(line, userAgent, exception);
                if (exception != null)
                {
                    currentError++;
                    System.out.printf("%d  %s\n", currentError, line);
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
                if (parsed >= 1000)
                {
                    System.out.println("\nStatistics:\n");
                    System.out.printf(
                            "Count of userAgent strings: %d\nCount of parsed userAgentString : %d\nCount of errors: %d\n", toParse,
                            parsed, errors);
                }

            }
        };

        parser.parseAll(new File(getClass().getClassLoader().getResource("top_1000_user-agents.txt").toURI()));
    }

}
