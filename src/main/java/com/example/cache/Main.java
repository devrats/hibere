/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 9:10 PM
 *   File: Main.java
 */

package com.example.cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Animal animal = new Animal(2,"dog");
        session.save(animal);
        transaction.commit();
        System.out.println(session.get(Animal.class, 1));
        System.out.println(session.get(Animal.class, 1));
        session.close();
        Session session1 = sessionFactory.openSession();
        System.out.println(session1.get(Animal.class, 1));
        sessionFactory.close();
    }
}