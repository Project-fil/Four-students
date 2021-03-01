package com.github.project.utils;

import com.github.project.people.People;
import com.github.project.people.personStorage;
import java.util.List;

public class SearchAndDeletePersonById {

    public static void deleteById(Integer id, personStorage personStorage) {
        List<People> personList = personStorage.getPerson();
        personList.removeIf(person -> person.getId().equals(id));
    }
}
