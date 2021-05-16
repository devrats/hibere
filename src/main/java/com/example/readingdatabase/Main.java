/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/15/2021
 *   Time: 7:20 PM
 *   File: Main.java
 */

package com.example.readingdatabase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int index = 0; index < 50; index++) {
            String string = "student" + String.valueOf(index);
            session.save(new Student(string));
        }
        transaction.commit();
        System.out.println(session.get(Student.class, 02));
        System.out.println(session.load(Student.class,07));
        session.close();
        sessionFactory.close();
    }
}