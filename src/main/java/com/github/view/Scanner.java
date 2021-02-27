package com.github.view;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import java.util.List;

public class Scanner {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static Peoples createPerson(PersonsData personStorage,
                                       String firstNameScan,
                                       String lastNameScan,
                                       Integer ageScan, String cityScan) {
        Integer id = 2;
        List<Peoples> personList = personStorage.getPersons();
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
        System.out.println("Your id=" + id + "  :)");
        return new Peoples(id, firstNameScan, lastNameScan, ageScan, cityScan);
    }
}
