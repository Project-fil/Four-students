package com.github.persons;

import java.util.List;

public class SearchID {

    public static Peoples getByIdForUpdate(Integer id, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        for (Peoples person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
}
