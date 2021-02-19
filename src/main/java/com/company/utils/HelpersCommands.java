package com.company.utils;

import com.company.persons.Person;
import com.company.StorageOfPersons;

import java.util.ArrayList;
import java.util.List;

public class HelpersCommands {

    public static Person getById(Integer id, StorageOfPersons personStorage) {
        List<Person> personList = personStorage.getPersons();
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public static List<Person> getAllByCity(String city, StorageOfPersons personStorage) {
        List<Person> personList = personStorage.getPersons();
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getCity().equals(city)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public static List<Person> getAllByAge(Integer age, StorageOfPersons personStorage) {
        List<Person> personList = personStorage.getPersons();
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge().equals(age)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public static List<Person> getAllByFirstName(String firstName, StorageOfPersons personStorage) {
        List<Person> personList = personStorage.getPersons();
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getFirstName().equals(firstName)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public static List<Person> getAllByLastName(String lastName, StorageOfPersons personStorage) {
        List<Person> personList = personStorage.getPersons();
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
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
        List<Person> personList = personStorage.getPersons();
        personList.clear();
    }
}
