/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/15/2021
 *   Time: 6:34 PM
 *   File: Patient.java
 */

package com.example.simpleannotation;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int pId;
    @Temporal(TemporalType.DATE)
    private Date dateOfAdmission;

    @Column(length = 5)
    private int bill;
    private String name;
    private int age;
    @Transient
    private int x;
    @Lob
    private byte[] image;

    public Patient() {

    }

    @Override
    public String toString() {
        return "Patient{" +
                "pId=" + pId +
                ", dateOfAdmission=" + dateOfAdmission +
                ", bill=" + bill +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", x=" + x +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getpId() == patient.getpId() && getBill() == patient.getBill() && getAge() == patient.getAge() && getX() == patient.getX() && Objects.equals(getDateOfAdmission(), patient.getDateOfAdmission()) && Objects.equals(getName(), patient.getName()) && Arrays.equals(getImage(), patient.getImage());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getpId(), getDateOfAdmission(), getBill(), getName(), getAge(), getX());
        result = 31 * result + Arrays.hashCode(getImage());
        return result;
    }

    public int getpId() {

        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Patient(int pId, Date dateOfAdmission, int bill, String name, int age, int x, byte[] image) {
        this.pId = pId;
        this.dateOfAdmission = dateOfAdmission;
        this.bill = bill;
        this.name = name;
        this.age = age;
        this.x = x;
        this.image = image;
    }
}