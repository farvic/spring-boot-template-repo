package com.farvic.rpg.repositories;

import com.farvic.rpg.domain.Character;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Tag(name = "Character", description = "Character API")
public interface CharacterRepository extends JpaRepository<Character, Long> {

    /**
     * Find a character by id
     * 
     * @param id the id of the Character
     * @return the Character
     */
    // Query example
    @Query("SELECT c FROM Character c WHERE c.id = :id")
    Optional<Character> findById(@Param("id") long id);

    /**
     * Find all the characters by name containing the given string
     * 
     * @param name the name of the character
     * @return the list of characters
     */
    List<Character> findByNameContaining(@Param("name") String name);

    /**
     * Save a character
     *
     * @param Character the character to save
     * @return the saved character
     */

    @Override
    // @RestResource(exported = false)
    <S extends Character> S save(S Character);

    @Override
    @RestResource(exported = false)
    <S extends Character> List<S> saveAll(Iterable<S> Characters);

    // @RestResource(exported = false)
    void deleteById(long id);

    @Override
//    @RestResource(exported = false)
    void delete(Character Character);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Character> Characters);

}
