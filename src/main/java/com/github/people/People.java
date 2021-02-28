package com.github.people;

import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {

    private String firstname;
    private String lastname;
    private Integer age;
    private String city;
    private Integer id;
    public People(Integer id, String firstName, String lastName, Integer age, String city) {
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
        People person = (People) o;
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
        final StringBuffer sb = new StringBuffer("Person:\n");
        sb.append(" [First name = ").append(firstname).append("]\n");
        sb.append(" [Last name = ").append(lastname).append("]\n");
        sb.append(" [Age = ").append(age).append("]\n");
        sb.append(" [City = ").append(city).append("]\n");
        sb.append(" [ID = ").append(id);
        return sb.toString();
    }
}
