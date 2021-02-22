package com.github.view.formats;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;

import java.util.List;

public class UpdatePerson {
    public static void updatePerson(Integer id, String firstName, String lastName, Integer age, String city, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        for (Peoples person : personList) {
            if (person.getId().equals(id)) {
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setAge(age);
                person.setCity(city);
            }
        }
    }
}
