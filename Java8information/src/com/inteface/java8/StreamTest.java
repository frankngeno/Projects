package com.inteface.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person(2, "john"));
        personList.add(new Person(3, "Adams"));
        personList.add(new Person(4, "smith"));
        personList = personList.stream().filter(person -> person.getId() > 2).collect(Collectors.toList());
        List<Long> idList = personList.stream().map(person -> person.getId()).collect(Collectors.toList());

        System.out.println(personList.size()); // number of person with id number > 2
        System.out.println(idList); // list of ids only

    }

}
