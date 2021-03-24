package com.cursor.krasulia.hw2;

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

    private static double convertToDouble(Fractions fractions) {
        return Double.parseDouble(fractions.getFullPart() + "." + fractions.getFractionalPart());
    }

    private static Fractions convertToFractions(double result) {
        long fullPart = (long) result;
        String resultInString = String.valueOf(result);
        short fractionalPart = Short.parseShort(resultInString.substring(resultInString.indexOf(".") + 1));
        return new Fractions(fullPart, fractionalPart);
    }
}
