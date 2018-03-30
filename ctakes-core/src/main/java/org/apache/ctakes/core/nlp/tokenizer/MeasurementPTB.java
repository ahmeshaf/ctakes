package org.apache.ctakes.core.nlp.tokenizer;

public class MeasurementPTB {
    private static final char X_LETTER = 'x';

    public static int tokenLengthCheckingForMeasurementTerms(String lowerCasedString) {

        if (lowerCasedString==null) throw new UnsupportedOperationException("no x found in (null)");
        int firstBreak = lowerCasedString.indexOf(X_LETTER);
        if (firstBreak<0) throw new UnsupportedOperationException("no x found in '" + lowerCasedString + "'");
        if (firstBreak+1==lowerCasedString.length()) return firstBreak; // if ends with x, don't include the x in the token.   mega-  by itself should be mega and -

        if (firstBreak == 0) {
            if (isValidMeasurement(lowerCasedString.substring(1)))
                return 1;
            else
                return lowerCasedString.length();
        }
        return firstBreak;
    }

    private static boolean isValidMeasurement(String substring) {
        String [] numbers = substring.split("x");
        for (String num: numbers
             ) {
            try {
                Double.parseDouble(num);
            }
            catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
//    public static getLenOfNumToken
}
