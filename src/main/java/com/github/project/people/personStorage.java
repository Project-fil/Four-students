package com.github.project.people;

import java.util.ArrayList;
import java.util.List;

public class personStorage {

    private List<People> people;
    public personStorage(List<People> person) {
        this.people = new ArrayList<>(person);
    }
    public List<People> getPerson() {
        return people;
    }
    public void setPerson(List<People> persons) {
        this.people = persons;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonStorage{");
        sb.append("people=").append(people);
        sb.append('}');
        return sb.toString();
    }
}
