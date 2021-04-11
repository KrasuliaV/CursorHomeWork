package com.cursor.krasulia.hw7.task1_2;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static List<Person> getAdultNonRetiredPersons(List<Person> peopleList) {
        return getPersonsFromAgeToAge(peopleList, 18, 60);
    }

    public static Set<String> getSetWithNameAndGender(List<Person> peopleList) {
        return peopleList.stream()
                .map(person -> person.getName() + " - " + person.getGender().toString().toLowerCase().charAt(0))
                .collect(Collectors.toSet());
    }

    public static Map<Continent, Map<Country, Map<Gender, List<Person>>>> getPersonMappingByContinents(List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 60)
                .collect(Collectors.groupingBy(person -> person.getCountry().getContinent(),
                        Collectors.groupingBy(Person::getCountry,
                                Collectors.groupingBy(Person::getGender, Collectors.toList()))));
    }

    private static List<Person> getPersonsFromAgeToAge(List<Person> peopleList, int fromAge, int toAge) {
        if (peopleList == null) {
            return Collections.emptyList();
        }
        return peopleList.stream()
                .filter(person -> person.getAge() > fromAge && person.getAge() < toAge)
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
    }
}
