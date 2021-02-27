package com.github.view.daoformats.formatssss;

import com.github.persons.Peoples;
import com.github.persons.PersonsData;
import java.io.File;
import java.util.List;

public class FormatJson {
    public static String toJSON(PersonsData personStorage) {
        List<Peoples> personList = personStorage.getPersons();
        File file = new File("js.json");
        StringBuffer sb = null;
        if (personList.isEmpty())
            sb = new StringBuffer("");
        else {
            sb = new StringBuffer("[\n");
        }
        int count = 0;
        for (Peoples person : personList)
        {
            sb.append("{\n");
            sb.append(" \"id\":").append(person.getId()).append(",\n");
            sb.append(" \"firstname\":\"").append(person.getFirstname()).append("\",\n");
            sb.append(" \"lastname\":\"").append(person.getLastname()).append("\",\n");
            sb.append(" \"age\":").append(person.getAge()).append(",\n");
            sb.append(" \"city\":\"").append(person.getCity()).append("\" \n");
            count++;
            if (count == personList.size()) {
                sb.append(" }\n");
            } else {
                sb.append(" },\n");
            }
        }
        if (!personList.isEmpty()) {
            sb.append("]");
        }
        return sb.toString();
    }
}
