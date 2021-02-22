package com.github.utils;

import com.github.persons.Person;
import com.github.persons.PersonsData;

import java.util.List;

public class ScannerPers {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static Person createPerson(PersonsData personStorage,
                                      String firstNameScan,
                                      String lastNameScan,
                                      Integer ageScan, String cityScan) {
        Integer id = 0;
        List<Person> personList = personStorage.getPersons();
        if (personList.isEmpty()) {
            id = 0;
        } else {
            id = personList.stream().max((o1, o2) -> {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else return 0;
            }).get().getId();
            id++;
        }
        System.out.println("Your id=" + id + ")");
        return new Person(id, firstNameScan, lastNameScan, ageScan, cityScan);
    }
}
