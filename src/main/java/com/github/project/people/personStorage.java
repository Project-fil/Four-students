package com.github.project.people;

import java.util.ArrayList;
import java.util.List;

public class personStorage {

    private List<People> persons;
    public personStorage(List<People> person) {
        this.persons = new ArrayList<>(person);
    }
    public List<People> getPerson() {
        return persons;
    }
    public void setPerson(List<People> persons) {
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
