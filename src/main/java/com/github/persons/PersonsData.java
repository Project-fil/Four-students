package com.github.persons;

import java.util.ArrayList;
import java.util.List;

public class PersonsData {

    private List<Peoples> persons;
    public PersonsData(List<Peoples> person) {
        this.persons = new ArrayList<>(person);
    }
    public List<Peoples> getPersons() {
        return persons;
    }
    public void setPersons(List<Peoples> persons) {
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
