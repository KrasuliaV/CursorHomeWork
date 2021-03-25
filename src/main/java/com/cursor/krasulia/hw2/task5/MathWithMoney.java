package com.cursor.krasulia.hw2.task5;

public class MathWithMoney {
    public static Money sum(Money firstCurrency, Money secondCurrency) {
        return convertToMoney(convertToDouble(firstCurrency) + convertToDouble(secondCurrency));
    }

    public static Money subtraction(Money firstCurrency, Money secondCurrency) {
        double result = convertToDouble(firstCurrency) - convertToDouble(secondCurrency);
        if (result < 0) {
            System.out.println("You don't have enough money!!!");
        }
        return convertToMoney(result);
    }

    public static Money multiplyByFractionsNumber(Money firstCurrency, double fractionsNumber) {
        return convertToMoney(convertToDouble(firstCurrency) * fractionsNumber);
    }

    public static Money multiplyMoneyByMoney(Money firstCurrency, Money secondCurrency) {
        return multiplyByFractionsNumber(firstCurrency, convertToDouble(secondCurrency));
    }

    public static Money divideByFractionsNumber(Money firstCurrency, double fractionsNumber) {
        return convertToMoney(convertToDouble(firstCurrency) / fractionsNumber);
    }

    public static Money divideByMoney(Money firstCurrency, Money secondCurrency) {
        return divideByFractionsNumber(firstCurrency, convertToDouble(secondCurrency));
    }

    public static int comparisonFractions(Money firstCurrency, Money secondCurrency) {
        return Double.compare(convertToDouble(firstCurrency), convertToDouble(secondCurrency));
    }

    private static double convertToDouble(Money currency) {
        return Double.parseDouble(currency.getHryvnia() + "." + currency.getCoin());
    }

    private static Money convertToMoney(double result) {
        String resultInString = String.format("%.2f", result);
        long hryvnia = (long) result;
        byte coin = Byte.parseByte(resultInString.substring(resultInString.indexOf(",") + 1));
        return new Money(hryvnia, coin);
    }

}
