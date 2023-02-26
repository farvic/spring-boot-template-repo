package com.farvic.rpg.dto;

import jakarta.annotation.Nonnull;

public class CharacterDto {

    @Nonnull
    private String name;
    @Nonnull
    private String job;
    @Nonnull
    private int coins;

    public CharacterDto() {
    }

    public CharacterDto(String name, String job, int coins) {
        this.name = name;
        this.job = job;
        this.coins = coins;
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
}
