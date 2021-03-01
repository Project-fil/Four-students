package com.github.project.checks;

import com.github.project.people.People;
import com.github.project.people.personStorage;

import java.util.List;

public class IdChecks {

    public static People getByIdForUpdate(Integer id, personStorage personStorage) {
        List<People> personList = personStorage.getPerson();
        for (People person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
}
