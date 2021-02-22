package com.github.view.formats;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.github.view.formatsview.CleanerFile.*;

public class SearchAndDeletePersonById {



    public static void deleteById(Integer id, PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        personList.removeIf(person -> person.getId().equals(id));
    }
}
