package com.github.project.people;

import java.util.ArrayList;
import java.util.List;

public class PersonData {

    private List<People> persons;
    public PersonData(List<People> person) {
        this.persons = new ArrayList<>(person);
    }
    public List<People> getPersons() {
        return persons;
    }
    public void setPersons(List<People> persons) {
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
