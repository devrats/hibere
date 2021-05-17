/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/17/2021
 *   Time: 9:28 AM
 *   File: Main.java
 */

package com.example.pagination;

import com.example.readingdatabase.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from com.example.readingdatabase.Student");
        query.setFirstResult(13);
        query.setMaxResults(10);
        List<Student> resultList = query.getResultList();
        System.out.println(resultList);
        session.close();
        sessionFactory.close();
    }
}