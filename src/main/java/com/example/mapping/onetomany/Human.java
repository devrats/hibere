/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 12:04 PM
 *   File: Human.java
 */

package com.example.mapping.onetomany;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Human {

    @Id
    private int hId;
    private String name;
    private String gender;
    @OneToMany(mappedBy = "human", fetch = FetchType.EAGER)
    private List<Mobile> mobiles;

    @Override
    public String toString() {
        return "Human{" +
                "hId=" + hId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", mobiles=" + mobiles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return gethId() == human.gethId() && Objects.equals(getName(), human.getName()) && Objects.equals(getGender(), human.getGender()) && Objects.equals(getMobiles(), human.getMobiles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(gethId(), getName(), getGender(), getMobiles());
    }

    public Human() {
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    public Human(int hId, String name, String gender, List<Mobile> mobiles) {
        this.hId = hId;
        this.name = name;
        this.gender = gender;
        this.mobiles = mobiles;
    }
}