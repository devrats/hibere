/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:05 PM
 *   File: Main.java
 */

package com.example.mapping.onetomany;

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
        Mobile mobile = new Mobile(1,8532066858L);
        Mobile mobile1 = new Mobile(2,7983458989L);
        Mobile mobile2 = new Mobile(3, 8532957250L);
        Mobile mobile3 = new Mobile(4,9027214058L);
        List<Mobile> list = new ArrayList<>();
        list.add(mobile);
        list.add(mobile1);
        list.add(mobile2);
        list.add(mobile3);
        Human human = new Human(1,"devvrat","male",list);
        mobile.setHuman(human);
        mobile1.setHuman(human);
        mobile2.setHuman(human);
        mobile3.setHuman(human);
        session.save(human);
        session.save(mobile);
        session.save(mobile1);
        session.save(mobile2);
        session.save(mobile3);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}