package com.github.persons;

import java.util.ArrayList;
import java.util.List;

public class GetBy {

    public static Peoples getById(Integer id, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        for (Peoples person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
    public static List<Peoples> getAllByCity(String city, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        List<Peoples> resultList = new ArrayList<>();
        for (Peoples person : personList) {
            if (person.getCity().equals(city)) {
                resultList.add(person);
            }
        }
        return resultList;
    }
    public static List<Peoples> getAllByAge(Integer age, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        List<Peoples> resultList = new ArrayList<>();
        for (Peoples person : personList) {
            if (person.getAge().equals(age)) {
                resultList.add(person);
            }
        }
        return resultList;
    }
    public static List<Peoples> getAllByFirstName(String firstName, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        List<Peoples> resultList = new ArrayList<>();
        for (Peoples person : personList) {
            if (person.getFirstName().equals(firstName)) {
                resultList.add(person);
            }
        }
        return resultList;
    }
    public static List<Peoples> getAllByLastName(String lastName, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        List<Peoples> resultList = new ArrayList<>();
        for (Peoples person : personList) {
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
        List<Peoples> personList = personStorage.getPersons();
        personList.clear();
    }
}
