/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:09 PM
 *   File: Main.java
 */

package com.example.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Question question = new Question(01,"what is your name",2);
        Question question2 = new Question(02,"where do you live",3);
        Question question3 = new Question(03,"how are you",4);

        Answer answer = new Answer(11,"my name is devvrat",question);
        Answer answer2 = new Answer(12,"i live in agra",question2);
        Answer answer3 = new Answer(13,"i am fine",question3);

        question.setAnswer(answer);
        question2.setAnswer(answer2);
        question3.setAnswer(answer3);

        session.save(question);
        session.save(question2);
        session.save(question3);

        session.save(answer);
        session.save(answer2);
        session.save(answer3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}