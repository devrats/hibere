/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/17/2021
 *   Time: 10:24 AM
 *   File: Main.java
 */

package com.example.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select ques.aId,ans.answer, ques.question from ques, ans where ques.aId = ans.aId and ques.qId = 4");
        Object[] objects = (Object[]) query.getSingleResult();
        for (Object object : objects) {
            System.out.println(object);
        }
        session.close();
        sessionFactory.close();
    }
}