/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 7:33 PM
 *   File: Main.java
 */

package com.example.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = new Car("nano");
        //transient state
        session.save(car);
        car.setName("farari");
        //persistence
        transaction.commit();
        session.close();
        //detached
        Session session1 = sessionFactory.openSession();
        session1.delete(car);
        session1.close();
        //removed
        sessionFactory.close();
    }
}