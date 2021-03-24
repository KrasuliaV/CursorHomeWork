package com.cursor.krasulia.hw2.task4;

public class MathWithFractions {
    public static Fractions sum(Fractions firstFractions, Fractions secondFractions) {
        return convertToFractions(convertToDouble(firstFractions) + convertToDouble(secondFractions));
    }

    public static Fractions subtraction(Fractions firstFractions, Fractions secondFractions) {
        return convertToFractions(convertToDouble(firstFractions) - convertToDouble(secondFractions));
    }

    public static Fractions multiply(Fractions firstFractions, Fractions secondFractions) {
        return convertToFractions(convertToDouble(firstFractions) * convertToDouble(secondFractions));
    }

    public static int comparisonFractions(Fractions firstFractions, Fractions secondFractions) {
        return Double.compare(convertToDouble(firstFractions), convertToDouble(secondFractions));
    }

    private static double convertToDouble(Fractions fractions) {
        return Double.parseDouble(fractions.getFullPart() + "." + fractions.getFractionalPart());
    }

    private static Fractions convertToFractions(double result) {
        long fullPart = (long) result;
        String resultInString = String.valueOf(result);
        short fractionalPart = Short.parseShort(makeRightShortString(resultInString.substring(resultInString.indexOf(".") + 1)));
        return new Fractions(fullPart, fractionalPart);
    }

    private static String makeRightShortString(String shortNumber) {
        if (Long.parseLong(shortNumber) <= Short.MAX_VALUE) return shortNumber;
        else shortNumber = makeRightShortString(shortNumber.substring(0, shortNumber.length() - 1));
        return shortNumber;
    }
}
