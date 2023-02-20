package com.farvic.rpg.web;

import com.farvic.rpg.domain.Character;

import com.farvic.rpg.service.CharacterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/characters")
@Tag(name = "Character", description = "Character API")
public class CharacterController {

    private final CharacterService CharacterService;

    public CharacterController(CharacterService CharacterService) {
        this.CharacterService = CharacterService;
    }

    @Operation(summary = "Get all Characters", description = "Get all Characters, available or not", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping()
    public List<Character> getAllCharacters() {
        return CharacterService.findAllCharacters();
    }

    @Operation(summary = "Get a Character by id", description = "Get a Character by id", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return CharacterService.findCharacterById(id);
    }

    @Operation(summary = "Get a Character by name", description = "Get a Character by name", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/name/{name}")
    public List<Character> getCharacterByName(@PathVariable String name) {
        return CharacterService.findCharactersByName(name);
    }

    @Operation(summary = "Create a Character", description = "Create a Character", tags = {
            "Character" })
    @ApiResponse(responseCode = "201", description = "OK")
    @PostMapping()
    public Character createCharacter(@RequestBody Character Character) {
        return CharacterService.saveCharacter(Character);
    }

    @Operation(summary = "Update a Character", description = "Update a Character", tags = {
            "Character" })
    @ApiResponse(responseCode = "204", description = "OK")
    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody Character Character) {
        return CharacterService.updateCharacter(id, Character);
    }

    @Operation(summary = "Delete a Character", description = "Delete a Character by id", tags = {
            "Character" })
    @ApiResponse(responseCode = "200", description = "No content")
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        CharacterService.deleteCharacterById(id);
    }

    @Operation(summary = "Delete a Character", description = "Delete a Character", tags = {
            "Character" })
    @ApiResponse(responseCode = "204", description = "No content")
    @DeleteMapping()
    public void deleteCharacter(@RequestBody Character Character) {
        CharacterService.deleteCharacter(Character);
    }

}