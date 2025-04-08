package org.nathanlib.libraries.importexport.utils;

/**
 * @author duyenthai
 */
public class StringUtils {

    public static final String EMPTY = "";

    public static String snakeToCamel(String str) {
        str = str.substring(0, 1).toUpperCase()
                + str.substring(1);

        StringBuilder builder
                = new StringBuilder(str);

        for (int i = 0; i < builder.length(); i++) {

            if (builder.charAt(i) == '_') {

                builder.deleteCharAt(i);
                builder.replace(
                        i, i + 1,
                        String.valueOf(
                                Character.toUpperCase(
                                        builder.charAt(i))));
            }
        }

        return builder.toString();
    }

    public static String snakeToCamel(String str, boolean firstCharUpperCase) {
        if (firstCharUpperCase) {
            return snakeToCamel(str);
        }

        String snakeToCamel = snakeToCamel(str);
        return snakeToCamel.substring(0, 1).toLowerCase() + snakeToCamel.substring(1);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
