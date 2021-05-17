/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/17/2021
 *   Time: 9:45 AM
 *   File: Main.java
 */

package com.example.hql;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student ");
        Query query1 = session.createQuery("update Student set name = 'devvrat' where id = 7");
        query1.executeUpdate();
        Query query2 = session.createQuery("delete from Student where id = :x");
        query2.setParameter("x",1);
        query2.executeUpdate();
        System.out.println(query.getResultList());
        Query query3 = session.createQuery("from Student where id = :x");
        query3.setParameter("x",5);
        System.out.println(query3.getSingleResult());
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}