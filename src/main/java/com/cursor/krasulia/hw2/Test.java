package com.cursor.krasulia.hw2;

import com.cursor.krasulia.hw2.task1.Circle;
import com.cursor.krasulia.hw2.task2.CountingSelfObjectsClass;
import com.cursor.krasulia.hw2.task3.Car;
import com.cursor.krasulia.hw2.task3.SpyCar;
import com.cursor.krasulia.hw2.task4.Fractions;
import com.cursor.krasulia.hw2.task4.MathWithFractions;
import com.cursor.krasulia.hw2.task5.MathWithMoney;
import com.cursor.krasulia.hw2.task5.Money;

import static com.cursor.krasulia.hw2.TestUtil.getStringResultAfterComparingFractions;
import static com.cursor.krasulia.hw2.TestUtil.getStringResultAfterComparingMoney;

public class Test {
    public static void main(String[] args) {

        /* 1. Написать класс Circle (круг) и метод, который будет возвращать его площадь.*/
        Circle circle = new Circle(10);
        System.out.println("First task");
        System.out.println("Circle square: " + circle.square());
        System.out.println("_________________");

        /*2. Написать класс, который умеет считать количество созданных объектов этого класса.*/
        System.out.println("Second task");
        System.out.println("Class objects number before object creation: " + CountingSelfObjectsClass.getClassObjectsNumber());
        CountingSelfObjectsClass exampleClassObject = new CountingSelfObjectsClass();
        System.out.println("Class objects number after object creation: " + CountingSelfObjectsClass.getClassObjectsNumber());
        System.out.println("_________________");

        /*3. Написать класс «автомобиль», который должен уметь заводится, глушить мотор, ехать и держать необходимую скорость.*/
        System.out.println("Third task");
        Car defaultCar = new Car();
        defaultCar.startEngine();
        defaultCar.startMove();
        defaultCar.shutsDownTheEngine();

        Car fasterCar = new Car(300);
        fasterCar.startEngine();
        fasterCar.startMove();
        fasterCar.shutsDownTheEngine();

        Car usualCar = new Car();
        usualCar.startEngine();
        usualCar.startMove(100);
        usualCar.shutsDownTheEngine();

        SpyCar bondCar = new SpyCar(770);
        bondCar.startEngine();
        bondCar.turnOnInvisible();
        bondCar.fire();
        bondCar.shutsDownTheEngine();

        System.out.println("_________________");

        /*4*. Класс Дробное число со знаком (Fractions).
        Число должно быть представлено двумя полями:
        целая часть - длинное целое, дробная часть - короткое целое.
        Реализовать арифметические операции сложения, вычитания, умножения и операции сравнения.
        В функции main проверить эти методы.*/

        System.out.println("Fourth task");

        Fractions firstFractions = new Fractions(15, (short) 20);
        Fractions secondFractions = new Fractions(20, (short) 45);

        System.out.printf("%s + %s = %s%n",
                firstFractions.toString(),
                secondFractions.toString(),
                MathWithFractions.sum(firstFractions, secondFractions).toString());
        System.out.printf("%s - %s = %s%n",
                firstFractions.toString(),
                secondFractions.toString(),
                MathWithFractions.subtraction(firstFractions, secondFractions).toString());
        System.out.printf("%s * %s = %s%n", firstFractions.toString(), secondFractions.toString(), MathWithFractions.multiply(firstFractions, secondFractions).toString());
        System.out.println(getStringResultAfterComparingFractions(firstFractions, secondFractions));
        System.out.println("_________________");

        /*5*. Класс Деньги для работы с денежными суммами.
        Число должно быть представлено двумя полями: типа long для гривен и типа byte - для копеек.
        Дробная часть (копейки) при выводе на экран должна быть отделена от целой части запятой.
        Реализовать сложение, вычитание, деление сумм, деление суммы на дробное число, умножение на дробное число
         и операции сравнения. В функции main проверить эти методы.*/

        System.out.println("Fifth task");
        Money firstCurrency = new Money(15, (byte) 20);
        Money secondCurrency = new Money(20, (byte) 45);

        System.out.printf("%s UAH + %s UAH = %s UAH%n",
                firstCurrency.toString(),
                secondCurrency.toString(),
                MathWithMoney.sum(firstCurrency, secondCurrency).toString());
        System.out.printf("%s UAH - %s UAH = %s UAH%n",
                firstCurrency.toString(),
                secondCurrency.toString(),
                MathWithMoney.subtraction(firstCurrency, secondCurrency).toString());
        System.out.printf("Multiply with Money: %s * %s = %s%n",
                firstCurrency.toString(),
                secondCurrency.toString(),
                MathWithMoney.multiplyMoneyByMoney(firstCurrency, secondCurrency).toString());
        System.out.printf("Divide with Money: %s / %s = %s%n",
                firstCurrency.toString(),
                secondCurrency.toString(),
                MathWithMoney.divideByMoney(firstCurrency, secondCurrency).toString());
        System.out.println(getStringResultAfterComparingMoney(firstCurrency, secondCurrency));

    }

}
