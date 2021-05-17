/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 5/16/2021
 *   Time: 9:07 PM
 *   File: Animal.java
 */

package com.example.cache;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Animal {

    @Id
    private int aId;
    private String name;

    @Override
    public String toString() {
        return "Animal{" +
                "aId=" + aId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getaId() == animal.getaId() && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getaId(), getName());
    }

    public int getaId() {

        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public Animal(int aId, String name) {
        this.aId = aId;
        this.name = name;
    }
}