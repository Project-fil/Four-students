package com.github.project.utils;

import com.github.project.people.People;
import com.github.project.people.PersonData;
import java.util.List;

public class SearchAndDeletePersonById {

    public static void deleteById(Integer id, PersonData personStorage) {
        List<People> personList = personStorage.getPersons();
        personList.removeIf(person -> person.getId().equals(id));
    }
}
