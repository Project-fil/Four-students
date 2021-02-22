package com.github.view.formats.formatssss;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;

import java.io.File;
import java.util.List;

public class FormatYaml {
    public static String toYaml(PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        File file = new File("ya.yaml");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("---\n");
        }
        for (Peoples person : personList
        ) {
            sb.append("- ")
                    .append("\"id:").append(person.getId())
                    .append(", ").append("firstName:")
                    .append(person.getFirstName()).append(",")
                    .append("lastName:").append(person.getLastName())
                    .append(",").append("age:").append(person.getAge())
                    .append(",").append("city:").append(person.getCity())
                    .append("\" \n");
        }
        return sb.toString();
    }
}
