package com.farvic.rpg.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterDtoTest {
    CharacterDto characterDtoUnderTest;
    @BeforeEach
    void setUp() {
        characterDtoUnderTest = new CharacterDto(
                "Victor",
                "Developer",
                700
        );
    }

    @Test
    void testGetters() {
        // Setup and test
        CharacterDto newCharacterDto = new CharacterDto(
                characterDtoUnderTest.getName(),
                characterDtoUnderTest.getJob(),
                characterDtoUnderTest.getCoins()
        );
        // Verify the results
        assertEquals(newCharacterDto.getName(), characterDtoUnderTest.getName());
        assertEquals(newCharacterDto.getJob(), characterDtoUnderTest.getJob());
        assertEquals(newCharacterDto.getCoins(), characterDtoUnderTest.getCoins());
    }

    @Test
    void testSetName() {
        // Setup
        String name = "Victorino";
        // Run the test
        characterDtoUnderTest.setName(name);

        // Verify the results
        assertEquals(name, characterDtoUnderTest.getName());
    }

    @Test
    void testSetJob() {
        // Setup
        String job = "Senior Developer";
        // Run the test
        characterDtoUnderTest.setJob(job);

        // Verify the results
        assertEquals(job, characterDtoUnderTest.getJob());
    }


    @Test
    void testSetCoins() {
        // Setup
        int coins = 15000;
        // Run the test
        characterDtoUnderTest.setCoins(coins);

        // Verify the results
        assertEquals(coins, characterDtoUnderTest.getCoins());
    }
}