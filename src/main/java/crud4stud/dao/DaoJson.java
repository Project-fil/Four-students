package crud4stud.dao;

import crud4stud.StorageOfPersons;
import crud4stud.persons.PersonCreate;

import java.io.File;
import java.util.List;

public class DaoJson {
    public static String toJSON(StorageOfPersons personStorage) {

        List<PersonCreate> personList = personStorage.getPersons();

        File file = new File("js.json");
        StringBuffer sb = null;
        if (personList.isEmpty())
            sb = new StringBuffer("");
        else {
            sb = new StringBuffer("[\n");
        }
        int count = 0;
        for (PersonCreate person : personList
        ) {
            sb.append("{\n");
            sb.append(" \"id\":").append(person.getId()).append(",\n");
            sb.append(" \"firstName\":\"").append(person.getFirstName()).append("\",\n");
            sb.append(" \"lastName\":\"").append(person.getLastName()).append("\",\n");
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
