package com.github.view.daoformats;

import com.github.people.People;
import com.github.people.PersonData;
import java.util.List;

public class UpdatePerson {
    public static void updatePerson(Integer id, String firstName, String lastName, Integer age, String city, PersonData personStorage) {
        List<People> personList = personStorage.getPersons();
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
