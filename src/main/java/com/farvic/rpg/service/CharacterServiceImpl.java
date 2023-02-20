package com.farvic.rpg.service;

import com.farvic.rpg.domain.Character;

import com.farvic.rpg.errors.CharacterNotFoundException;

import com.farvic.rpg.repositories.CharacterRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    final private CharacterRepository characterRepository;

    /**
     * Construct CharacterService
     *
     * @param characterRepository Character Repository
     *
     */
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;

    }

    /**
     * Get all Characters from the database
     * 
     * @return List of Characters
     * 
     */
    @Override
    public List<Character> findAllCharacters() {
        return characterRepository.findAll();
    }

    /**
     * Find a character by id
     * 
     * @param id the id of the Character
     * @return the Character
     * @throws CharacterNotFoundException if the Character is not found
     * 
     */
    @Override
    public Character findCharacterById(Long id) {
        return characterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException("Character not found"));
    }

    /**
     * Find all the characters by name containing the given string
     * 
     * @param name the name of the character
     * @return the list of characters
     * 
     */
    @Override
    public List<Character> findCharactersByName(String name) {
        return characterRepository.findByNameContaining(name);
    }

    /**
     * Save a Character to the database
     * 
     * @param character     the name of the Character
     * @return Character
     * 
     */

    @Override
    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    /**
     * Update a Character
     * 
     * @param id        the id of the Character
     * 
     * @param character character
     * 
     * @return Character
     */
    @Override
    public Character updateCharacter(Long id, Character character) {
        Character _character = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character not found"));

        _character.setName(character.getName());
        _character.setJob(character.getJob());
        _character.setCoins(character.getCoins());

        return characterRepository.save(_character);
    }

    /**
     * Delete a Character
     * 
     * @param id the id of the Character
     * 
     */
    @Override
    public void deleteCharacterById(Long id) {
        characterRepository.deleteById(id);
    }

    /**
     * Delete a Character
     * 
     * @param character character
     * 
     */
    @Override
    public void deleteCharacter(Character character) {
        characterRepository.delete(character);
    }

}
