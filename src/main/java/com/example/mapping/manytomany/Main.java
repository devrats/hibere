/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:04 PM
 *   File: Main.java
 */

package com.example.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee("devvrat",36_00_000);
        Employee employee1 = new Employee("shruti",4_60_000);
        Employee employee2 = new Employee("richa",0);
        Employee employee3 = new Employee("mom",3_00_000);
        Employee employee4 = new Employee("rahul",36_56_756);
        Project project = new Project("chatbot",5);
        Project project1 = new Project("library",3);
        Project project2 = new Project("railway",4);
        Project project3 = new Project("marriage",6);
        Project project4 = new Project("market",8);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(employee3);
        employees1.add(employee4);
        List<Employee> employees2 = new ArrayList<>();
        employees2.add(employee4);
        employees2.add(employee2);
        List<Employee> employees3 = new ArrayList<>();
        employees3.add(employee1);
        employees3.add(employee4);
        List<Employee> employees4 = new ArrayList<>();
        employees4.add(employee1);
        employees4.add(employee3);
        employees4.add(employee4);
        List<Project> projects = new ArrayList<>();
        projects.add(project);
        projects.add(project1);
        List<Project> projects1 = new ArrayList<>();
        projects1.add(project2);
        projects1.add(project3);
        List<Project> projects2 = new ArrayList<>();
        projects2.add(project3);
        projects2.add(project4);
        List<Project> projects3 = new ArrayList<>();
        projects3.add(project1);
        projects3.add(project3);
        List<Project> projects4 = new ArrayList<>();
        projects4.add(project3);
        projects4.add(project1);
        projects4.add(project);
        employee.setProjects(projects);
        employee1.setProjects(projects1);
        employee2.setProjects(projects2);
        employee3.setProjects(projects3);
        employee4.setProjects(projects4);
        project.setEmployees(employees);
        project1.setEmployees(employees1);
        project2.setEmployees(employees2);
        project3.setEmployees(employees3);
        project4.setEmployees(employees4);
        session.save(employee);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(project);
        session.save(project1);
        session.save(project2);
        session.save(project3);
        session.save(project4);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}