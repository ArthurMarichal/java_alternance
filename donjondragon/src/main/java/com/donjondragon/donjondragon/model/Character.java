package com.donjondragon.donjondragon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Character {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;

    public Character(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Character() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getType() {
        return type;
    }

    public void setType(String  type) {
        this.type = type;
    }
}
