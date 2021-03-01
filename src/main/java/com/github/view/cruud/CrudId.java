package com.github.view.cruud;

import com.github.people.People;
import com.github.people.PersonData;

import java.util.List;

public class CrudId {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static People createPerson(PersonData personStorage,
                                       String firstNameScan,
                                       String lastNameScan,
                                       Integer ageScan, String cityScan) {
        Integer id = 2;
        List<People> personList = personStorage.getPersons();
        if (personList.isEmpty()) {
            id = 2;
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
        System.out.println("Your id=" + id + "  :)\n");
        return new People(id, firstNameScan, lastNameScan, ageScan, cityScan);
    }
}