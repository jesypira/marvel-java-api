package io.github.jesypira.marvelapi.marveljavaapi.repository;

import io.github.jesypira.marvelapi.marveljavaapi.model.story.Story;
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
public interface StoryRepository extends JpaRepository<Story, Long> {

    @Query(value = " SELECT s FROM Story s " +
            " join CharacterStory ch on ch.idStory = s.id" +
            " where ch.idCharacter = :idCharacter ")
    List<Story> findByCharacter(@Param("idCharacter") Long idCharacter);

    @Query(value = " SELECT s FROM Story s " +
            " join SeriesStory serieStory on serieStory.idStory = s.id" +
            " where serieStory.idSeries = :idSeries ")
    List<Story> findBySeries(@Param("idSeries") Long idSeries);

    @Query(value = " select COUNT(s) FROM Story s ")
    int countAll();

    @Query(value = " SELECT s FROM Story s " +
            " join StoryComic sc on sc.idStory = s.id" +
            " where sc.idComic = :idComic ")
    List<Story> findByComic(@Param("idComic") Long idComic);

    @Query(value = " SELECT s FROM Story s " +
            " join EventStory es on es.idStory = s.id" +
            " where es.idEvent = :idEvent ")
    List<Story> findByEvent(@Param("idEvent") Long idEvent);
}
