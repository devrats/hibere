/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 9:41 AM
 *   File: Main.java
 */

package com.example.embadible;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Address address = new Address("agra","137","india");
        Customer customer = new Customer("devvrat",2000,address);
        Customer customer1 = new Customer("rahul",1000,address);
        Customer customer2 = new Customer("richa",20000,address);
        Customer customer3 = new Customer("shruti",4000,address);
        Customer customer4 = new Customer("mom",200,address);
        session.save(customer);
        session.save(customer1);
        session.save(customer2);
        session.save(customer3);
        session.save(customer4);
        session.close();
        sessionFactory.close();
    }
}