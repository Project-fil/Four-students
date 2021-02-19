package com.company.Scanner;

import com.company.Persons.PersonCreate;
import com.company.StorageOfPersons;

import java.util.List;

public class ScannerPers {


    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static PersonCreate createPerson(StorageOfPersons personStorage,
                                            String firstNameScan,
                                            String lastNameScan,
                                            Integer ageScan, String cityScan) {
        Integer id = 0;
        List<PersonCreate> personList = personStorage.getPersons();
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
        return new PersonCreate(id, firstNameScan, lastNameScan, ageScan, cityScan);
    }
}




