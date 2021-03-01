package com.github.project.daoformats;

import com.github.project.people.People;
import com.github.project.people.personStorage;
import java.util.List;

public class UpdatePerson {
    public static void updatePerson(Integer id, String firstName, String lastName, Integer age, String city, personStorage personStorage) {
        List<People> personList = personStorage.getPerson();
        for (People person : personList) {
            if (person.getId().equals(id)) {
                person.setFirstname(firstName);
                person.setLastname(lastName);
                person.setAge(age);
                person.setCity(city);
            }
        }
    }
}
