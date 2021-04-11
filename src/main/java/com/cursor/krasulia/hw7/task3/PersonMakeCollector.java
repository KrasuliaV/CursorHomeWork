package com.cursor.krasulia.hw7.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class PersonMakeCollector implements Collector<String, List<Person>, List<Person>> {

    @Override
    public Supplier<List<Person>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Person>, String> accumulator() {
        return toAccumulator;
    }

    public final BiConsumer<List<Person>, String> toAccumulator = this::makeAccumulator;

    private void makeAccumulator(List<Person> personList, String str) {
        if (personList.isEmpty() && str == null) new ArrayList<Person>();
        else if (personList.isEmpty() || personList.get(personList.size() - 1).getSecondName() != null) {
            Person newPerson = new Person();
            newPerson.setFirstName(str);
            personList.add(newPerson);
        } else {
            personList.get(personList.size() - 1).setSecondName(str);
        }
    }

    @Override
    public BinaryOperator<List<Person>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Person>, List<Person>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(IDENTITY_FINISH);
    }

    public static PersonMakeCollector toPersonList() {
        return new PersonMakeCollector();
    }
}
