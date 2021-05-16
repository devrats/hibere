/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/15/2021
 *   Time: 6:45 PM
 *   File: Main.java
 */

package com.example.simpleannotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Patient patient = new Patient();
        patient.setName("nidhi");
        patient.setAge(19);
        patient.setBill(15_000);
        patient.setDateOfAdmission(new Date());
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\mine\\nidhi.jpg");
            byte[] image = new byte[fileInputStream.available()];
            fileInputStream.read(image);
            patient.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        session.save(patient);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}