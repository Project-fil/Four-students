package com.github.people;

import java.util.List;

public class SearchID {

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
