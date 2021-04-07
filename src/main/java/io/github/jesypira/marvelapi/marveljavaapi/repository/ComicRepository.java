package io.github.jesypira.marvelapi.marveljavaapi.repository;

import io.github.jesypira.marvelapi.marveljavaapi.model.comic.Comic;
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
public interface ComicRepository extends JpaRepository<Comic, Long> {

    @Query(value = " SELECT c FROM Comic c " +
            " join CharacterComic ch on ch.idComic = c.id" +
            " where ch.idCharacter = :idCharacter ")
    List<Comic> findByCharacter(@Param("idCharacter") Long idCharacter);

    @Query(value = " SELECT c FROM Comic c " +
            " join SeriesComic sc on sc.idComic = c.id" +
            " where sc.idSeries = :idSeries ")
    List<Comic> findBySeries(@Param("idSeries") Long idSeries);

    @Query(value = " select COUNT(c) FROM Comic c ")
    int countAll();

    @Query(value = " SELECT c FROM Comic c " +
            " join StoryComic sc on sc.idComic = c.id" +
            " where sc.idStory = :idStory ")
    List<Comic> findByStory(@Param("idStory") Long idStory);

    @Query(value = " SELECT c FROM Comic c " +
            " join EventComic ec on ec.idComic = c.id" +
            " where ec.idEvent = :idEvent ")
    List<Comic> findByEvent(@Param("idEvent") Long idEvent);
}
