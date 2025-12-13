package org.example;

public class Util {
    /**
     * Converts the string into a titlecase
     * @param str given input
     * @return the titlecased string
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        str = str.trim();
        int spaceIdx = str.indexOf(" ");
        if (spaceIdx == -1) {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }

        String firstWord = str.substring(0, spaceIdx);
        String firstWordTitle = firstWord.substring(0, 1).toUpperCase()
                + firstWord.substring(1).toLowerCase();

        String secondWord = str.substring(spaceIdx + 1);
        String secondWordTitle = secondWord.substring(0, 1).toUpperCase()
                + secondWord.substring(1).toLowerCase();

            return firstWordTitle + " " + secondWordTitle;
    }
}
