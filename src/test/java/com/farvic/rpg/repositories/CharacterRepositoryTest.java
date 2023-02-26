package com.farvic.rpg.repositories;

import com.farvic.rpg.domain.Character;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CharacterRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void contextLoads() {
        assertNotNull(entityManager);
    }

    @Test
    void findNoCharacters() {
        // Setup and Run the test
        List<Character> characters = characterRepository.findAll();

        // Verify the results
        assertTrue(characters.isEmpty());
    }

    @Nested
    public class NestedTestBlock {
        Character character1;
        Character character2;
        Character character3;

        @BeforeEach
        void setUp() {
            character1 = new Character("Victor", "Developer", 7000);
            entityManager.persist(character1);

            character2 = new Character("Ariel", "Developer", 7000);
            entityManager.persist(character2);

            character3 = new Character("Victorino", "Developer", 7000);
            entityManager.persist(character3);
        }
        @Test
        void save() {


            // Run the test

            Character savedCharacter = characterRepository.save(character1);

            // Verify the results
            assertNotNull(savedCharacter);
            assertEquals(character1.getName(), savedCharacter.getName());
            assertEquals(character1.getJob(), savedCharacter.getJob());
            assertEquals(character1.getCoins(), savedCharacter.getCoins());
        }

        @Test
        void findAllCharacters() {

            // Run the test
            List<Character> characters = characterRepository.findAll();

            // Verify the results
            assertThat(characters).hasSize(3).contains(character1, character2, character3);
        }

        @Test
        void findById() {

            // Run the test
            Character foundCharacter = characterRepository.findById(character2.getId()).orElseThrow(() -> new RuntimeException("Character not found!") );

            // Verify the results
            assertThat(foundCharacter).isEqualTo(character2);

        }

        @Test
        void findByNameContaining() {
            // Run the test
            List<Character> foundCharacter = characterRepository.findByNameContaining("Victor");

            // Verify the results
            assertThat(foundCharacter).hasSize(2).contains(character1, character3);
        }

        @Test
        void updateCharacter() {

            Character updatedCharacter = new Character("Ariel Pierot", "Senior Developer", 15000);

            Character character = characterRepository.findById(character2.getId()).orElseThrow(() -> new RuntimeException("Character not found!") );
            character.setName(updatedCharacter.getName());
            character.setJob(updatedCharacter.getJob());
            character.setCoins(updatedCharacter.getCoins());
            characterRepository.save(character);

            Character checkCharacter = characterRepository.findById(character2.getId()).orElseThrow(() -> new RuntimeException("Character not found!") );

            assertThat(checkCharacter.getName()).isEqualTo(updatedCharacter.getName());
            assertThat(checkCharacter.getJob()).isEqualTo(updatedCharacter.getJob());
            assertThat(checkCharacter.getCoins()).isEqualTo(updatedCharacter.getCoins());

        }

        @Test
        void deleteById() {

            // Run the test
            characterRepository.deleteById(character2.getId());

            // Verify the results
            List<Character> characters = characterRepository.findAll();
            assertThat(characters).hasSize(2).contains(character1, character3);

        }

        @Test
        void delete() {

            // Run the test
            characterRepository.delete(character2);
            List<Character> characters = characterRepository.findAll();

            // Verify the results
            assertThat(characters).hasSize(2).contains(character1, character3);

        }

        @Test
        void deleteAll() {

            // Run the test
            characterRepository.deleteAll();
            List<Character> characters = characterRepository.findAll();

            // Verify the results
            assertThat(characters).isEmpty();

        }

    }

}