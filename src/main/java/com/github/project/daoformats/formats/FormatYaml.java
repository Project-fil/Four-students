package com.github.project.daoformats.formats;

import com.github.project.people.People;
import com.github.project.people.PersonData;
import java.io.File;
import java.util.List;

public class FormatYaml {
    public static String toYaml(PersonData personStorage) {
        List<People> personList = personStorage.getPersons();
        File file = new File("ya.yaml");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("---\n");
        }
        for (People person : personList
        ) {
            sb.append("- ")
                    .append("\"id:").append(person.getId())
                    .append(", ").append("firstname:")
                    .append(person.getFirstname()).append(",")
                    .append("lastname:").append(person.getLastname())
                    .append(",").append("age:").append(person.getAge())
                    .append(",").append("city:").append(person.getCity())
                    .append("\" \n");
        }
        return sb.toString();
    }
}
