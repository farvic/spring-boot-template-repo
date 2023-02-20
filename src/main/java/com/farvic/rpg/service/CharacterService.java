package com.farvic.rpg.service;

import com.farvic.rpg.domain.Character;

import java.util.List;

public interface CharacterService {

    List<Character> findAllCharacters();

    Character findCharacterById(Long id);

    List<Character> findCharactersByName(String name);

    Character saveCharacter(Character Character);

    Character updateCharacter(Long id, Character Character);

    void deleteCharacterById(Long id);

    void deleteCharacter(Character Character);

}
