package str_utils;

import java.util.StringTokenizer;

public class StringUtils
{
    private static final String TRUNCATE_FORMAT = "%s..."; //NON-NLS

    public static String truncate(final String s, final int n)
    {
        return (s.length() <= n) ? s : String.format(TRUNCATE_FORMAT, s.substring(0, n));
    }

    public static String[] tokenize(final String s, final char delim)
    {
        final String delimStr = Character.toString(delim);
        final StringTokenizer st = new StringTokenizer(s, delimStr);
        final String[] tokens = new String[st.countTokens()];

        int i = 0;
        while (st.hasMoreTokens())
        {
            tokens[i] = st.nextToken();
            i++;
        }

        return tokens;
    }

    @SuppressWarnings("IndexOfReplaceableByContains")
    public static boolean contains(final String s, final String subString)
    {
        return s.indexOf(subString) != -1;
    }
}