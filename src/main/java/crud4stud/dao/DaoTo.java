package crud4stud.dao;

import crud4stud.persons.PersonCreate;
import crud4stud.StorageOfPersons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static crud4stud.utils.Utils.*;

public class DaoTo {

    public static List<PersonCreate> getAllObjects(String file) {

        String results = getResultFromFile(file);
        List<PersonCreate> persons = new ArrayList<>();
        if (!results.equals("")) {
            String[] arr = results.split(" ");
            for (int i = 0; i < arr.length; i = i + 5) {
                persons.add(new PersonCreate(Integer.parseInt(arr[i]),
                        arr[i + 1], arr[i + 2], Integer.parseInt(arr[i + 3]),
                        arr[i + 4]));
            }
        }
        return persons;
    }

    public static void updatePerson(Integer id, String firstName, String lastName, Integer age, String city, StorageOfPersons personStorage) {
        List<PersonCreate> personList = personStorage.getPersons();

        for (PersonCreate person : personList) {
            if (person.getId().equals(id)) {
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setAge(age);
                person.setCity(city);
            }
        }
    }

    public static void deleteById(Integer id, StorageOfPersons personStorage) {
        List<PersonCreate> personList = personStorage.getPersons();
        personList.removeIf(person -> person.getId().equals(id));
    }
}
