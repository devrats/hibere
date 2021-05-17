/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:05 PM
 *   File: Mobile.java
 */

package com.example.mapping.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Mobile {

    @Id
    private int mId;
    private long number;

    @Override
    public String toString() {
        return "Mobile{" +
                "mId=" + mId +
                ", number=" + number +
                '}';
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public Mobile(int mId, long number, Human human) {
        this.mId = mId;
        this.number = number;
        this.human = human;
    }

    @ManyToOne
    private Human human;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mobile)) return false;
        Mobile mobile = (Mobile) o;
        return getmId() == mobile.getmId() && getNumber() == mobile.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getmId(), getNumber());
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Mobile() {
    }

    public Mobile(int mId, long number) {
        this.mId = mId;
        this.number = number;
    }
}