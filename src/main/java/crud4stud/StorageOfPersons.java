package crud4stud;

import crud4stud.persons.PersonCreate;

import java.util.ArrayList;
import java.util.List;

public class StorageOfPersons {

    private List<PersonCreate> persons;

    public StorageOfPersons(List<PersonCreate> person) {

        this.persons = new ArrayList<>(person);
    }

    public List<PersonCreate> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonCreate> persons) {

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