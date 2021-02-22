package com.github.view;

import com.github.persons.Person;
import com.github.persons.PersonsData;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.github.persons.CleanerFile.*;

public class CrudFormats {

    private CrudFormats() {
    }
    public static String toJSON(PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        File file = new File("js.json");
        StringBuffer sb = null;
        if (personList.isEmpty())
            sb = new StringBuffer("");
        else {
            sb = new StringBuffer("[\n");
        }
        int count = 0;
        for (Person person : personList)
        {
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
    public static String toXml(PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        File file = new File("xm.xml");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("<Persons>\n");
        }
        for (Person person : personList
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
    public static String toCsv(PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        File file = new File("cv.csv");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("id,firstName,lastName,age,city \n");
        }
        for (Person person : personList
        ) {
            sb.append(person.getId()).append(",")
                    .append(person.getFirstName()).append(",")
                    .append(person.getLastName()).append(",")
                    .append(person.getAge()).append(",")
                    .append(person.getCity()).append(" \n");
        }
        return sb.toString();
    }
    public static String toYaml(PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        File file = new File("ya.yaml");
        StringBuffer sb = null;
        if (personList.isEmpty()) {
            sb = new StringBuffer("");
        } else {
            sb = new StringBuffer("---\n");
        }
        for (Person person : personList
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
    public static String toBinary(PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();
        return Arrays.toString(bytes);
    }
    public static List<Person> getAllObjects(String file) {
        String results = getResultFromFile(file);
        List<Person> persons = new ArrayList<>();
        if (!results.equals("")) {
            String[] arr = results.split(" ");
            for (int i = 0; i < arr.length; i = i + 5) {
                persons.add(new Person(Integer.parseInt(arr[i]),
                        arr[i + 1], arr[i + 2], Integer.parseInt(arr[i + 3]),
                        arr[i + 4]));
            }
        }
        return persons;
    }
    public static void updatePerson(Integer id, String firstName, String lastName, Integer age, String city, PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setAge(age);
                person.setCity(city);
            }
        }
    }
    public static void deleteById(Integer id, PersonsData personStorage) {
        List<Person> personList = personStorage.getPersons();
        personList.removeIf(person -> person.getId().equals(id));
    }
}
