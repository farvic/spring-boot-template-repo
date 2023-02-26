package com.farvic.rpg.web;

import com.farvic.rpg.domain.Character;

import com.farvic.rpg.dto.CharacterDto;
import com.farvic.rpg.service.CharacterService;

import com.farvic.rpg.utils.CharacterDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/characters")
@Tag(name = "Character", description = "Character API")
public class CharacterController {


    private final CharacterService characterService;

    private final CharacterDtoMapper characterDtoMapper;

    public CharacterController(CharacterService characterService, CharacterDtoMapper characterDtoMapper) {
        this.characterService = characterService;
        this.characterDtoMapper = characterDtoMapper;
    }

    @Operation(summary = "Get all Characters", description = "Get all Characters, available or not", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping()
    public List<Character> getAllCharacters() {
        return characterService.findAllCharacters();
    }

    @Operation(summary = "Get a Character by id", description = "Get a Character by id", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return characterService.findCharacterById(id);
    }

    @Operation(summary = "Get a Character by name", description = "Get a Character by name", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/name/{name}")
    public List<Character> getCharacterByName(@PathVariable String name) {
        return characterService.findCharactersByName(name);
    }

    @Operation(summary = "Create a Character", description = "Create a Character", tags = {
            "Character" })
    @ApiResponse(responseCode = "201", description = "OK")
    @PostMapping()
    public Character createCharacter(@RequestBody CharacterDto characterDto) {
        Character character = characterDtoMapper.toEntity(characterDto);
        return characterService.saveCharacter(character);
    }

    @Operation(summary = "Update a Character", description = "Update a Character", tags = {
            "Character" })
    @ApiResponse(responseCode = "204", description = "OK")
    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody CharacterDto characterDto) {
        Character character = characterDtoMapper.toEntity(characterDto);
        return characterService.updateCharacter(id, character);
    }

    @Operation(summary = "Delete a Character", description = "Delete a Character by id", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "No content")
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacterById(id);
    }

    @Operation(summary = "Delete a Character", description = "Delete a Character", tags = {
            "Character" })
    @ApiResponse(responseCode = "204", description = "No content")
    @DeleteMapping()
    public void deleteCharacter(@RequestBody CharacterDto characterDto) {
        Character character = characterDtoMapper.toEntity(characterDto);
        characterService.deleteCharacter(character);
    }

}