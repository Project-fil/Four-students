package com.github.view.formats.formatssss;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;

import java.io.File;
import java.util.List;

public class FormatXml {
    public static String toXml(PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        File file = new File("xm.xml");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("<Persons>\n");
        }
        for (Peoples person : personList
        ) {
            sb.append(" <Person>\n");
            sb.append(" <id>").append(person.getId()).append("</id>\n");
            sb.append(" <firstName>").append(person.getFirstName()).append("</firstName>\n");
            sb.append(" <lastName>").append(person.getLastName()).append("</lastName>\n");
            sb.append(" <age>").append(person.getAge()).append("</age>\n");
            sb.append(" <city>").append(person.getCity()).append("</city>\n");
            sb.append(" </Person>\n");
        }
        if (!personList.isEmpty())
            sb.append("</Persons>\n");
        return sb.toString();
    }
}
