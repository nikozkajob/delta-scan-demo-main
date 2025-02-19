package com.christmas;

public class Christmas {

    private final static int NUMBER_OF_VERSES = 12;

    private static String[] days = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eight", "ninth", "tenth", "eleventh", "twelfth"};

    private static String[] uniqueLines = {
            "A partridge in a pear tree.",
            "Two turtle doves and",
            "Three french hens",
            "Four calling birds",
            "Five golden rings",
            "Six geese a-laying",
            "Seven swans a-swimming",
            "Eight maids a-milking",
            "Nine ladies dancing",
            "Ten lords a-leaping",
            "Eleven pipers piping",
            "Twelve drummers drumming"};

    public static String getSong() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_VERSES; i++) {
            result.append(getVerse(i + 1)).append("\n");
        }
        return result.toString().trim();
    }

    public static String getVerseHeader(int number) {
        String coma = number >= 6 ? "," : "";
        return String.format("""
                        On the %s day of Christmas%s
                        My true love gave to me:
                        """,
                days[number - 1], coma);
    }

    public static String getVerse(int number) {
        String result = getVerseHeader(number);
        for (int lineNumber = number; lineNumber > 0; lineNumber--) {
            result = addLine(result, lineNumber);
        }
        return result;
    }

    public static String addLine(String result, int lineNumber) {
        return result + getUniqueLine(lineNumber) + "\n";
    }

    public static String getUniqueLine(int lineNumber) {
        return uniqueLines[lineNumber - 1];
    }
}
