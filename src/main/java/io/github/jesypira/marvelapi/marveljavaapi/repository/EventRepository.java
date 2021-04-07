package io.github.jesypira.marvelapi.marveljavaapi.repository;

import io.github.jesypira.marvelapi.marveljavaapi.model.event.Event;
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
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = " SELECT e FROM Event e " +
            " join CharacterEvent ch on ch.idEvent = e.id" +
            " where ch.idCharacter = :idCharacter ")
    List<Event> findByCharacter(@Param("idCharacter") Long idCharacter);

    @Query(value = " SELECT c FROM Event c " +
            " join SeriesEvent se on se.idEvent = c.id" +
            " where se.idSeries = :idSeries ")
    List<Event> findBySeries(@Param("idSeries") Long idSeries);

    @Query(value = " select COUNT(e) FROM Event e ")
    int countAll();

    @Query(value = " SELECT c FROM Event c " +
            " join EventComic ec on ec.idEvent = c.id" +
            " where ec.idComic = :idComic ")
    List<Event> findByComic(@Param("idComic") Long idComic);

    @Query(value = " SELECT c FROM Event c " +
            " join EventStory es on es.idEvent = c.id" +
            " where es.idStory = :idStory ")
    List<Event> findByStory(@Param("idStory") Long idComic);
}
