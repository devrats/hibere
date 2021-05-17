/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:09 PM
 *   File: Main.java
 */

package com.example.fetchtype.lazy;

import com.example.mapping.onetomany.Human;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Human human = session.get(Human.class, 1);
        System.out.println(human.getMobiles());
        session.close();
        sessionFactory.close();
    }
}