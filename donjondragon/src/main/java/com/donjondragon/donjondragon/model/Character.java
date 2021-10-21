package com.donjondragon.donjondragon.model;

import javax.persistence.*;

@Entity
@Table(name = "Personnages")
public class Character {
    private Integer id;
    private String name;
    private String type;

    public Character(Integer id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Character() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nom")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String  getType() {
        return type;
    }
    public void setType(String  type) {
        this.type = type;
    }
}
