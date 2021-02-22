package com.github.persons;

import java.util.ArrayList;
import java.util.List;

public class GetBy {

    public static Person getById(Integer id,PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
    public static List<Person> getAllByCity(String city, PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getCity().equals(city)) {
                resultList.add(person);
            }
        }
        return resultList;
    }
    public static List<Person> getAllByAge(Integer age, PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge().equals(age)) {
                resultList.add(person);
            }
        }
        return resultList;
    }
    public static List<Person> getAllByFirstName(String firstName, PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getFirstName().equals(firstName)) {
                resultList.add(person);
            }
        }
        return resultList;
    }
    public static List<Person> getAllByLastName(String lastName, PersonsData personStorage) {
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
    public static void deleteAll(PersonsData personStorage ) {
        List<Person> personList = personStorage.getPersons();
        personList.clear();
    }
}
