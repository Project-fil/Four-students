package crud4stud.dao;

import crud4stud.StorageOfPersons;
import crud4stud.persons.PersonCreate;

import java.io.File;
import java.util.List;

public class DaoXml {
    public static String toXml(StorageOfPersons personStorage) {

        List<PersonCreate> personList = personStorage.getPersons();
        File file = new File("xm.xml");
        StringBuffer sb = null;

        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("<Persons>\n");
        }
        for (PersonCreate person : personList
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
