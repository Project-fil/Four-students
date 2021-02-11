package crud4stud.dao;

import crud4stud.StorageOfPersons;
import crud4stud.persons.PersonCreate;

import java.io.File;
import java.util.List;

public class DaoCsv {
    public static String toCsv(StorageOfPersons personStorage) {

        List<PersonCreate> personList = personStorage.getPersons();
        File file = new File("cv.csv");

        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("id,firstName,lastName,age,city \n");
        }

        for (PersonCreate person : personList
        ) {
            sb.append(person.getId()).append(",")
                    .append(person.getFirstName()).append(",")
                    .append(person.getLastName()).append(",")
                    .append(person.getAge()).append(",")
                    .append(person.getCity()).append(" \n");
        }
        return sb.toString();
    }
}
