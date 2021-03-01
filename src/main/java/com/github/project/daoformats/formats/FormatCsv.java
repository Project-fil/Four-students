package com.github.project.daoformats.formats;

import com.github.project.people.People;
import com.github.project.people.personStorage;
import java.io.File;
import java.util.List;

public class FormatCsv {

    public static String toCsv(personStorage personStorage) {
        List<People> personList = personStorage.getPerson();
        File file = new File("cv.csv");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("id,firstname,lastname,age,city \n");
        }
        for (People person : personList) {
            sb.append(person.getId()).append(",")
                    .append(person.getFirstname()).append(",")
                    .append(person.getLastname()).append(",")
                    .append(person.getAge()).append(",")
                    .append(person.getCity()).append(" \n");
        }
        return sb.toString();
    }
}
