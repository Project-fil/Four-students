package com.github.view.daoformats.formatssss;

import com.github.people.People;
import com.github.people.PersonData;
import java.io.File;
import java.util.List;

public class FormatXml {
    public static String toXml(PersonData personStorage) {
        List<People> personList = personStorage.getPersons();
        File file = new File("xm.xml");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("<Persons>\n");
        }
        for (People person : personList
        ) {
            sb.append(" <Person>\n");
            sb.append(" <id>").append(person.getId()).append("</id>\n");
            sb.append(" <firstname>").append(person.getFirstname()).append("</firstname>\n");
            sb.append(" <lastname>").append(person.getLastname()).append("</lastname>\n");
            sb.append(" <age>").append(person.getAge()).append("</age>\n");
            sb.append(" <city>").append(person.getCity()).append("</city>\n");
            sb.append(" </Person>\n");
        }
        if (!personList.isEmpty())
            sb.append("</Persons>\n");
        return sb.toString();
    }
}
