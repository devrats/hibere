/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/14/2021
 *   Time: 4:50 PM
 *   File: Person.java
 */

package com.example.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Person {

    @Id
    private int id;
    private String name;
    private String education;
    private double number;
    private String gender;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", education='" + education + '\'' +
                ", number=" + number +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() && Double.compare(person.getNumber(), getNumber()) == 0 && Objects.equals(getName(), person.getName()) && Objects.equals(getEducation(), person.getEducation()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getEducation(), getNumber(), getGender());
        return result;
    }


    public Person(int id, String name, double number, String education, String gender) {
        this.id = id;
        this.name = name;
        this.education = education;
        this.number = number;
        this.gender = gender;
    }

    public Person() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(int id, String name, String education, double number, String gender) {
        this.id = id;
        this.name = name;
        this.education = education;
        this.number = number;
        this.gender = gender;
    }
}