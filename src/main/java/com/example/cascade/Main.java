/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 7:47 PM
 *   File: Main.java
 */

package com.example.cascade;

import com.example.mapping.onetoone.Answer;
import com.example.mapping.onetoone.Question;
import com.example.states.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Question question = new Question(5,"how old are you",5);
        Answer answer = new Answer(5,"20 year",question);
        question.setAnswer(answer);
        System.out.println(question);
        session.save(question);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}