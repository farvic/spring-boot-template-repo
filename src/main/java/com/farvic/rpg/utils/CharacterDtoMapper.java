package com.farvic.rpg.utils;

import com.farvic.rpg.dto.CharacterDto;

import com.farvic.rpg.domain.Character;
import org.springframework.stereotype.Component;

@Component
public class CharacterDtoMapper {
    public static CharacterDtoMapper INSTANCE = new CharacterDtoMapper();

    public CharacterDto toDto(Character character) {
        CharacterDto dto = new CharacterDto();
        dto.setName(character.getName());
        dto.setJob(character.getJob());
        dto.setCoins(character.getCoins());
        return dto;
    }

    public Character toEntity(CharacterDto dto) {
        Character character = new Character();
        character.setName(dto.getName());
        character.setJob(dto.getJob());
        character.setCoins(dto.getCoins());
        return character;
    }
}
