package com.cursor.krasulia.hw7.task1_2;

import java.util.List;

import static com.cursor.krasulia.hw7.task1_2.Country.*;
import static com.cursor.krasulia.hw7.task1_2.Gender.FEMALE;
import static com.cursor.krasulia.hw7.task1_2.Gender.MALE;

public class Test {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Petro", 25, MALE, UKRAINE),
                new Person("Olena", 19, FEMALE, UKRAINE),
                new Person("Marek", 50, MALE, POLAND),
                new Person("Rasine", 65, FEMALE, POLAND),
                new Person("Cherina", 42, FEMALE, FRANCE),
                new Person("Bridgett", 18, FEMALE, FRANCE),
                new Person("Jaron", 42, MALE, ISRAEL),
                new Person("Namir", 18, MALE, ISRAEL),
                new Person("John", 10, MALE, USA),
                new Person("Jane", 78, FEMALE, USA),
                new Person("Alonzo", 12, MALE, ARGENTINA),
                new Person("Azael", 43, FEMALE, ARGENTINA),
                new Person("Thomas", 12, MALE, AUSTRALIA),
                new Person("Brittney", 43, FEMALE, AUSTRALIA)
        );

        System.out.println("First task");
        System.out.println(Util.getAdultNonRetiredPersons(people));

        System.out.println(Util.getSetWithNameAndGender(people));

        System.out.println("\nSecond task");
        System.out.println(Util.getPersonMappingByContinents(people));
    }
}
