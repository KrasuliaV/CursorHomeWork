package com.cursor.krasulia.hw2;

import com.cursor.krasulia.hw2.task4.Fractions;
import com.cursor.krasulia.hw2.task4.MathWithFractions;

public class Test {
    public static void main(String[] args) {

//        /* 1. Написать класс Circle (круг) и метод, который будет возвращать его площадь.*/
//        Circle circle = new Circle(10);
//        System.out.println("Circle square: " + circle.square());
//
//        /*2. Написать класс, который умеет считать количество созданных объектов этого класса.*/
//        System.out.println("Class objects number before object creation: " + CountingSelfObjectsClass.getClassObjectsNumber());
//        CountingSelfObjectsClass exampleClassObject = new CountingSelfObjectsClass();
//        System.out.println("Class objects number after object creation: " + CountingSelfObjectsClass.getClassObjectsNumber());
//
//        /*3. Написать класс «автомобиль», который должен уметь заводится, глушить мотор, ехать и держать необходимую скорость.*/
//        Car defaultCar = new Car();
//        defaultCar.startEngine();
//        defaultCar.startMove();
//        defaultCar.shutsDownTheEngine();
//
//        Car fasterCar = new Car(300);
//        fasterCar.startEngine();
//        fasterCar.startMove();
//        fasterCar.shutsDownTheEngine();
//
//        Car usualCar = new Car();
//        usualCar.startEngine();
//        usualCar.startMove(100);
//        usualCar.shutsDownTheEngine();

        /*4*. Класс Дробное число со знаком (Fractions).
        Число должно быть представлено двумя полями:
        целая часть - длинное целое, дробная часть - короткое целое.
        Реализовать арифметические операции сложения, вычитания, умножения и операции сравнения.
        В функции main проверить эти методы.*/

        Fractions firstFractions = new Fractions(56, (short) 569);
        Fractions secondFractions = new Fractions(20, (short) 723);
        System.out.printf("%s + %s = %s\n", firstFractions.toString(), secondFractions.toString(), MathWithFractions.sum(firstFractions, secondFractions).toString());
        System.out.printf("%s - %s = %s\n", firstFractions.toString(), secondFractions.toString(), MathWithFractions.subtraction(firstFractions, secondFractions).toString());
        System.out.printf("%s * %s = %s\n", firstFractions.toString(), secondFractions.toString(), MathWithFractions.multiply(firstFractions, secondFractions).toString());
//        System.out.printf("%s + %s = %s", firstFractions.toString(), secondFractions.toString(), MathWithFractions.sum(firstFractions, secondFractions).toString());
    }


}
