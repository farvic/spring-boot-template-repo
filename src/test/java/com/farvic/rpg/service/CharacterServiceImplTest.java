package com.farvic.rpg.service;

import com.farvic.rpg.domain.Character;
import com.farvic.rpg.errors.CharacterNotFoundException;
import com.farvic.rpg.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class CharacterServiceImplTest {

    @Mock
    private CharacterRepository mockCharacterRepository;

    @InjectMocks
    private CharacterServiceImpl characterServiceImplUnderTest;

    private Character character;
    private Character character2;

    @BeforeEach
    void setUp() {
        character = new Character(0L, "Victor", "Developer", 7000);
        character2 = new Character(1L, "Ariel", "Developer", 7000);
    }

    @Test
    void testFindAllCharacters() {

        // Setup
        final List<Character> characters = List.of(character, character2);
        when(mockCharacterRepository.findAll()).thenReturn(characters);

        // Run the test
        final List<Character> result = characterServiceImplUnderTest.findAllCharacters();

        // Verify the results
        verify(mockCharacterRepository).findAll();
        assertThat(result).isEqualTo(characters);
    }

    @Test
    void testFindAllCharacters_CharacterRepositoryReturnsNoItems() {
        // Setup
        when(mockCharacterRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Character> result = characterServiceImplUnderTest.findAllCharacters();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testFindCharacterById() throws CharacterNotFoundException {

        long id = character2.getId();

        // Setup
        given(mockCharacterRepository.findById(any())).willReturn(Optional.of(character2));


        // Run the test
        final Character result = characterServiceImplUnderTest.findCharacterById(id);

        // Verify the results
        verify(mockCharacterRepository).findById(any());
        assertThat(result).isEqualTo(character2);
    }

    @Test
    void testFindCharacterById_CharacterRepositoryReturnsAbsent() {
        // Setup
        when(mockCharacterRepository.findById(any())).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> characterServiceImplUnderTest.findCharacterById(0L))
                .isInstanceOf(CharacterNotFoundException.class);
    }

    @Test
    void testFindCharacterById_ThrowsResourceNotFoundException() {

        // Setup
        when(mockCharacterRepository.findById(any())).thenThrow(CharacterNotFoundException.class);

        // Run the test
        assertThatThrownBy(() -> characterServiceImplUnderTest.findCharacterById(0L))
                .isInstanceOf(CharacterNotFoundException.class);
    }

    @Test
    void testFindCharactersByName() {
        // Setup
        final List<Character> characters = List.of(new Character(0L, "name", "job", 0));
        when(mockCharacterRepository.findByNameContaining("name")).thenReturn(characters);

        // Run the test
        final List<Character> result = characterServiceImplUnderTest.findCharactersByName("name");

        // Verify the results
        verify(mockCharacterRepository).findByNameContaining("name");
        assertThat(result).isEqualTo(characters);
    }

    @Test
    void testFindCharactersByName_CharacterRepositoryReturnsNoItems() {
        // Setup
        when(mockCharacterRepository.findByNameContaining("name")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Character> result = characterServiceImplUnderTest.findCharactersByName("name");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testSaveCharacter() {
        // Setup
        final Character character = new Character(0L, "name", "job", 0);
        when(mockCharacterRepository.save(any(Character.class))).thenReturn(new Character(0L, "name", "job", 0));

        // Run the test
        final Character result = characterServiceImplUnderTest.saveCharacter(character);

        // Verify the results
        verify(mockCharacterRepository).save(any(Character.class));
    }

    @Test
    void testUpdateCharacter() {
        // Setup
        final Character updatedCharacter = new Character(0L, "Ariel Pierot", "Senior Developer", 15000);
        when(mockCharacterRepository.findById(any())).thenReturn(Optional.of(character2));

        when(mockCharacterRepository.save(any(Character.class))).thenReturn(updatedCharacter);

        // Run the test
        final Character result = characterServiceImplUnderTest.updateCharacter(0L, character);

        // Verify the results
        verify(mockCharacterRepository).findById(any());
        verify(mockCharacterRepository).save(any(Character.class));
        assertThat(result).isEqualTo(updatedCharacter);
    }

    @Test
    void testUpdateCharacter_CharacterRepositoryFindByIdReturnsAbsent() {

        // Run the test
        when(mockCharacterRepository.findById(any())).thenReturn(Optional.empty());

        // Verify the results
        assertThatThrownBy(() -> characterServiceImplUnderTest.updateCharacter(0L, character))
                .isInstanceOf(CharacterNotFoundException.class);
    }

    @Test
    void testDeleteCharacterById() {

        // Run the test
        characterServiceImplUnderTest.deleteCharacterById(0L);

        // Verify the results
        verify(mockCharacterRepository).deleteById(any(Long.class));

    }

    @Test
    void testDeleteCharacter() {
        // Setup
        final Character character = new Character(0L, "name", "job", 0);

        // Run the test
        characterServiceImplUnderTest.deleteCharacter(character);

        // Verify the results
        verify(mockCharacterRepository).delete(any(Character.class));
    }
}
