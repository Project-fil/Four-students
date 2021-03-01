package com.github.project.checks;

import com.github.project.people.People;
import com.github.project.people.PersonData;

import java.util.List;

public class IdChecks {

    public static People getByIdForUpdate(Integer id, PersonData personStorage) {
        List<People> personList = personStorage.getPersons();
        for (People person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
}
