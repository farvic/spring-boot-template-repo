package com.farvic.rpg.web;

import com.farvic.rpg.domain.Character;
import com.farvic.rpg.dto.CharacterDto;
import com.farvic.rpg.service.CharacterService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CharacterController.class)
class CharacterControllerTest {

    @MockBean
    private CharacterService characterService;

    @MockBean
    private CharacterDto characterDto;
    @Autowired
    private MockMvc mockMvc;
    Character character1;
    Character character2;
    Character character3;

    @BeforeEach
    void setUp() {

        character1 = new Character(0,"Victor", "Developer", 7000);

        character2 = new Character(1,"Ariel", "Developer", 7000);

        character3 = new Character(2,"Nahum", "Developer", 7000);

    }


    @Test
    void testGetAllCharacters() throws Exception {

        // Setup

        List<Character> characters = List.of(character1, character2, character3);
        when(characterService.findAllCharacters()).thenReturn(characters);

        // Run the test and verify the results

        mockMvc.perform(get("/characters")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name").value("Victor"))
                .andExpect(jsonPath("$[1].name").value("Ariel"));

    }

    @Test
    void testGetAllCharactersButReturnEmpty() throws Exception {

        // Run the test and verify the results

        final MockHttpServletResponse response = mockMvc.perform(get("/characters")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().getResponse();
        mockMvc.perform(get("/characters")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

    }

    @Test
    void testCreateCharacter() throws Exception {

        // Setup

        when(characterService.saveCharacter(any())).thenReturn(character1);

        // Run the test and verify the results

        mockMvc.perform(post("/characters")
                        .content(character1.toJson()).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Victor"))
                .andExpect(jsonPath("$.job").value("Developer"))
                .andExpect(jsonPath("$.coins").value(7000));

    }

    @Test
    void testDeleteCharacter1() throws Exception {

        // Run the test and verify the results

        mockMvc.perform(delete("/characters/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }




    @Test
    void testGetCharacterById() throws Exception {

        // Setup

        when(characterService.findCharacterById(0L)).thenReturn(character1);

        // Run the test and verify the results

        mockMvc.perform(get("/characters/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Victor"))
                .andExpect(jsonPath("$.job").value("Developer"))
                .andExpect(jsonPath("$.coins").value(7000));
    }

    @Test
    void testGetCharacterByName() throws Exception {

        // Setup

        when(characterService.findCharactersByName("Victor")).thenReturn(List.of(character1));

        // Run the test and verify the results

        mockMvc.perform(get("/characters/name/{name}", "Victor")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Victor"))
                .andExpect(jsonPath("$[0].job").value("Developer"))
                .andExpect(jsonPath("$[0].coins").value(7000));
    }

    @Test
    void testUpdateCharacter() throws Exception {

        // Setup
        Character character = new Character(0,"Victor Fonseca", "Senior Developer", 15000);
        when(characterService.updateCharacter(any(),any())).thenReturn(character);


        // Run the test and verify the results
        mockMvc.perform(put("/characters/{id}", 0)
                        .content(character1.toJson()).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Victor Fonseca"))
                .andExpect(jsonPath("$.job").value("Senior Developer"))
                .andExpect(jsonPath("$.coins").value(15000));

    }
}