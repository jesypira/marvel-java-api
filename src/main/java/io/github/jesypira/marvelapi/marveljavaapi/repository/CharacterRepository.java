package io.github.jesypira.marvelapi.marveljavaapi.repository;

import io.github.jesypira.marvelapi.marveljavaapi.model.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query("SELECT character FROM Character character")
    List<Character> findAll();

    Character findFirstById(Long id);

    @Query(value = " SELECT c FROM Character c " +
            " join CharacterSeries ch on ch.idCharacter = c.id" +
            " where ch.idSeries = :idSeries ")
    List<Character> findBySeries(@Param("idSeries") Long idSeries);

    @Query(value = " select COUNT(c) FROM Character c ")
    int countAll();

    @Query(value = " SELECT c FROM Character c " +
            " join CharacterComic ch on ch.idCharacter = c.id" +
            " where ch.idComic = :idComic ")
    List<Character> findByComic(@Param("idComic") Long idComic);

    @Query(value = " SELECT c FROM Character c " +
            " join CharacterStory cs on cs.idCharacter = c.id" +
            " where cs.idStory = :idStory ")
    List<Character> findByStory(@Param("idStory") Long idStory);

    @Query(value = " SELECT c FROM Character c " +
            " join CharacterEvent ce on ce.idCharacter = c.id" +
            " where ce.idEvent = :idEvent ")
    List<Character> findByEvent(@Param("idEvent") Long idEvent);
}
