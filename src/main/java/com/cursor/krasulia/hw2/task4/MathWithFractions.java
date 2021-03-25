package com.cursor.krasulia.hw2.task4;

public class MathWithFractions {

    public static Fractions sum(Fractions firstFractions, Fractions secondFractions) {
        if (firstFractions.getFractionalPart() == secondFractions.getFractionalPart()) {
            return new Fractions(firstFractions.getFullPart() + secondFractions.getFractionalPart(), firstFractions.getFractionalPart());
        } else {
            long resultFullPart = firstFractions.getFullPart() * secondFractions.getFractionalPart() + secondFractions.getFullPart() * firstFractions.getFractionalPart();
            short resultFractionalPart = (short) (firstFractions.getFractionalPart() * secondFractions.getFractionalPart());
            return new Fractions(resultFullPart, resultFractionalPart);
        }
    }

    public static Fractions subtraction(Fractions firstFractions, Fractions secondFractions) {
        if (firstFractions.getFractionalPart() == secondFractions.getFractionalPart()) {
            return new Fractions(firstFractions.getFullPart() - secondFractions.getFractionalPart(), firstFractions.getFractionalPart());
        } else {
            long resultFullPart = firstFractions.getFullPart() * secondFractions.getFractionalPart() - secondFractions.getFullPart() * firstFractions.getFractionalPart();
            short resultFractionalPart = (short) (firstFractions.getFractionalPart() * secondFractions.getFractionalPart());
            return new Fractions(resultFullPart, resultFractionalPart);
        }
    }

    public static Fractions multiply(Fractions firstFractions, Fractions secondFractions) {
        return new Fractions(firstFractions.getFullPart() * secondFractions.getFullPart(), (short) (secondFractions.getFractionalPart() * secondFractions.getFractionalPart()));
    }

    public static int comparisonFractions(Fractions firstFractions, Fractions secondFractions) {
        return Double.compare((double) firstFractions.getFullPart() / firstFractions.getFractionalPart(), (double) secondFractions.getFullPart() / secondFractions.getFractionalPart());
    }

}
