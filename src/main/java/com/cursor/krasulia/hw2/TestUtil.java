package com.cursor.krasulia.hw2;

import com.cursor.krasulia.hw2.task4.Fractions;
import com.cursor.krasulia.hw2.task4.MathWithFractions;
import com.cursor.krasulia.hw2.task5.MathWithMoney;
import com.cursor.krasulia.hw2.task5.Money;

public class TestUtil {

    public static String getStringResultAfterComparingFractions(Fractions firstFractions, Fractions secondFractions) {
        switch (MathWithFractions.comparisonFractions(firstFractions, secondFractions)) {
            case 1:
                return "First fraction is bigger than second";
            case -1:
                return "Second fraction is bigger than first";
            default:
                return "Fractions are equals";
        }
    }

    public static String getStringResultAfterComparingMoney(Money firstCurrency, Money secondCurrency) {
        switch (MathWithMoney.comparisonFractions(firstCurrency, secondCurrency)) {
            case 1:
                return String.format("%s UAH is bigger than %s UAH", firstCurrency.toString(), secondCurrency.toString());
            case -1:
                return String.format("%s UAH is less than %s UAH", firstCurrency.toString(), secondCurrency.toString());
            default:
                return "Money are equals";
        }
    }
}
