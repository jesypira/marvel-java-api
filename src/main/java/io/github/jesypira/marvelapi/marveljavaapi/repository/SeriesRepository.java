package io.github.jesypira.marvelapi.marveljavaapi.repository;

import io.github.jesypira.marvelapi.marveljavaapi.model.series.Series;
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
public interface SeriesRepository extends JpaRepository<Series, Long> {

    @Query(value = " SELECT s FROM Series s " +
            " join CharacterSeries ch on ch.idSeries = s.id" +
            " where ch.idCharacter = :idCharacter ")
    List<Series> findByCharacter(@Param("idCharacter") Long idCharacter);

    @Query(value = " select COUNT(s) FROM Series s ")
    int countAll();

    @Query(value = " SELECT s FROM Series s " +
            " join SeriesComic sc on sc.idSeries = s.id" +
            " where sc.idComic = :idComic ")
    List<Series> findByComic(@Param("idComic") Long idComic);

    @Query(value = " SELECT s FROM Series s " +
            " join SeriesStory seriesStory on seriesStory.idSeries = s.id" +
            " where seriesStory.idStory = :idStory ")
    List<Series> findByStory(@Param("idStory") Long iStory);

    @Query(value = " SELECT s FROM Series s " +
            " join SeriesEvent se on se.idSeries = s.id" +
            " where se.idEvent = :idEvent ")
    List<Series> findByEvent(@Param("idEvent") Long idEvent);
}
