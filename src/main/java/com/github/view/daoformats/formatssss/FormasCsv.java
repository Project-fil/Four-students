package com.github.view.daoformats.formatssss;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import java.io.File;
import java.util.List;

public class FormasCsv {

    public static String toCsv(PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        File file = new File("cv.csv");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("id,firstName,lastName,age,city \n");
        }
        for (Peoples person : personList
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
