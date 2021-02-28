package com.github.view.daoformats;

import com.github.people.People;
import com.github.people.PersonData;
import java.util.List;

public class SearchAndDeletePersonById {

    public static void deleteById(Integer id, PersonData personStorage) {
        List<People> personList = personStorage.getPersons();
        personList.removeIf(person -> person.getId().equals(id));
    }
}
