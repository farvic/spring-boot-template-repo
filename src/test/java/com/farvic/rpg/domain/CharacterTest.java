package com.farvic.rpg.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


class CharacterTest {

    private Character characterUnderTest;

    @BeforeEach
    void setUp() {
        characterUnderTest = new Character(0, "Victor", "Developer", 7000);
    }


    @Test
    void testGetters() {

        assertEquals(0, characterUnderTest.getId());
        assertEquals("Victor", characterUnderTest.getName());
        assertEquals("Developer", characterUnderTest.getJob());
        assertEquals(7000, characterUnderTest.getCoins());
    }

    @Test
    void testSetId() {

        // Run the test
        characterUnderTest.setId(1);

        // Verify the results
        assertEquals(1, characterUnderTest.getId());
    }


    @Test
    void testSetName() {
        // Setup
        // Run the test
        characterUnderTest.setName("Victor 2");

        // Verify the results
        assertEquals("Victor 2", characterUnderTest.getName());
    }

    @Test
    void testSetJob() {
        // Setup
        // Run the test
        characterUnderTest.setJob("Senior Developer");

        // Verify the results
        assertEquals("Senior Developer", characterUnderTest.getJob());

    }

    @Test
    void testTestToString() {
        // Setup
        // Run the test
        final String result = characterUnderTest.toString();

        // Verify the results
        assertEquals("Character{id=0, name='Victor', job='Developer', coins=7000}", result);
    }
}
