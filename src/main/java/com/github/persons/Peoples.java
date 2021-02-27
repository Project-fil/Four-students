package com.github.persons;

import java.io.Serializable;
import java.util.Objects;

public class Peoples implements Serializable {

    private String firstname;
    private String lastname;
    private Integer age;
    private String city;
    private Integer id;
    public Peoples(Integer id, String firstName, String lastName, Integer age, String city) {
        this.id = id;
        this.firstname = firstName;
        this.lastname = lastName;
        this.age = age;
        this.city = city;
    }
    public Integer getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peoples person = (Peoples) o;
        return Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(age, person.age) &&
                Objects.equals(city, person.city) &&
                Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, age, city, id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", city='").append(city).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
