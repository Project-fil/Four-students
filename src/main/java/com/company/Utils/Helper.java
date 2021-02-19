package com.company.Utils;

import com.company.Persons.PersonCreate;
import com.company.StorageOfPersons;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static PersonCreate getById(Integer id, StorageOfPersons personStorage) {
        List<PersonCreate> personList = personStorage.getPersons();
        for (PersonCreate person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public static List<PersonCreate> getAllByCity(String city, StorageOfPersons personStorage) {
        List<PersonCreate> personList = personStorage.getPersons();
        List<PersonCreate> resultList = new ArrayList<>();
        for (PersonCreate person : personList) {
            if (person.getCity().equals(city)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public static List<PersonCreate> getAllByAge(Integer age, StorageOfPersons personStorage) {
        List<PersonCreate> personList = personStorage.getPersons();
        List<PersonCreate> resultList = new ArrayList<>();
        for (PersonCreate person : personList) {
            if (person.getAge().equals(age)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public static List<PersonCreate> getAllByFirstName(String firstName, StorageOfPersons personStorage) {
        List<PersonCreate> personList = personStorage.getPersons();
        List<PersonCreate> resultList = new ArrayList<>();
        for (PersonCreate person : personList) {
            if (person.getFirstName().equals(firstName)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public static List<PersonCreate> getAllByLastName(String lastName, StorageOfPersons personStorage) {
        List<PersonCreate> personList = personStorage.getPersons();
        List<PersonCreate> resultList = new ArrayList<>();
        for (PersonCreate person : personList) {
            if (person.getLastName().equals(lastName)) {
                resultList.add(person);
            }
        }
        if (resultList.isEmpty()) {
            System.out.println("No persons found");
        }
        return resultList;
    }

    public static void deleteAll(StorageOfPersons personStorage ) {
        List<PersonCreate> personList = personStorage.getPersons();
        personList.clear();
    }
}
