package com.farvic.rpg.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "coins")
    private int coins;

    @Column(name = "class")
    private String job;

    public Character() {

    }

    public Character(String name, String job, int coins) {
        this.name = name;
        this.job = job;
        this.coins = coins;
    }

    public Character(long id, String name, String job, int coins) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.coins = coins;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "Character{id=" + id + ", name='" + name + "', job='" + job + "', coins=" + coins + "}";
    }

    public String toJson() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"job\":\"" + job + "\",\"coins\":" + coins + "}";
    }

}