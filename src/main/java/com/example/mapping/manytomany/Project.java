/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:04 PM
 *   File: Project.java
 */

package com.example.mapping.manytomany;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {

    public Project(String name, int deadLineInMonth) {
        this.name = name;
        this.deadLineInMonth = deadLineInMonth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String name;
    private int deadLineInMonth;
    @ManyToMany(mappedBy = "projects")
    List<Employee> employees;

    @Override
    public String toString() {
        return "Project{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", deadLineInMonth=" + deadLineInMonth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return getpId() == project.getpId() && getDeadLineInMonth() == project.getDeadLineInMonth() && Objects.equals(getName(), project.getName()) && Objects.equals(getEmployees(), project.getEmployees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getpId(), getName(), getDeadLineInMonth(), getEmployees());
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeadLineInMonth() {
        return deadLineInMonth;
    }

    public void setDeadLineInMonth(int deadLineInMonth) {
        this.deadLineInMonth = deadLineInMonth;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Project() {
    }

    public Project(int pId, String name, int deadLineInMonth) {
        this.pId = pId;
        this.name = name;
        this.deadLineInMonth = deadLineInMonth;
    }

    public Project(int pId, String name, int deadLineInMonth, List<Employee> employees) {
        this.pId = pId;
        this.name = name;
        this.deadLineInMonth = deadLineInMonth;
        this.employees = employees;
    }
}