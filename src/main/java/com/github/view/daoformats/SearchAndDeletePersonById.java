package com.github.view.daoformats;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import java.util.List;

public class SearchAndDeletePersonById {

    public static void deleteById(Integer id, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        personList.removeIf(person -> person.getId().equals(id));
    }
}
