package com.github.project.daoformats.formats;

import com.github.project.people.People;
import com.github.project.people.personStorage;
import java.io.File;
import java.util.List;

public class FormatXml {
    public static String toXml(personStorage personStorage) {
        List<People> personList = personStorage.getPerson();
        File file = new File("xm.xml");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("<People>\n");
        }
        for (People person : personList
        ) {
            sb.append("  <Person>\n\t");
            sb.append("     <id>").append(person.getId()).append("</id>\n\t");
            sb.append("     <firstname>").append(person.getFirstname()).append("</firstname>\n\t");
            sb.append("     <lastname>").append(person.getLastname()).append("</lastname>\n\t");
            sb.append("     <age>").append(person.getAge()).append("</age>\n\t");
            sb.append("     <city>").append(person.getCity()).append("</city>\n");
            sb.append("    </Person>\n");
        }
        if (!personList.isEmpty())
            sb.append("</Persons>\n");
        return sb.toString();
    }
}
