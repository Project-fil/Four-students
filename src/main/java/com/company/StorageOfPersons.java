package com.company;

import com.company.persons.Person;

import java.util.ArrayList;
import java.util.List;

public class StorageOfPersons {

    private List<Person> persons;

    public StorageOfPersons(List<Person> person) {

        this.persons = new ArrayList<>(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {

        this.persons = persons;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonStorage{");
        sb.append("persons=").append(persons);
        sb.append('}');
        return sb.toString();
    }
}
