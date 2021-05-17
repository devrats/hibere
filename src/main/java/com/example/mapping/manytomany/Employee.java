/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:04 PM
 *   File: Employee.java
 */

package com.example.mapping.manytomany;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee {

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eId;
    private String name;

    public Employee(int eId, String name, int salary) {
        this.eId = eId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return geteId() == employee.geteId() && getSalary() == employee.getSalary() && Objects.equals(getName(), employee.getName()) && Objects.equals(getProjects(), employee.getProjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(geteId(), getName(), getSalary(), getProjects());
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee() {
    }

    public Employee(int eId, String name, int salary, List<Project> projects) {
        this.eId = eId;
        this.name = name;
        this.salary = salary;
        this.projects = projects;
    }

    private int salary;
    @ManyToMany
    private List<Project> projects;
}