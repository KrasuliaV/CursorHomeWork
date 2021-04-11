package com.cursor.krasulia.hw7.task1_2;

public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
    private final Country country;

    public Person(String name, int age, Gender gender, Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name + '(' + age + ')';
    }
}
