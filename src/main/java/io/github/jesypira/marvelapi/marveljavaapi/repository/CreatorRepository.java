package io.github.jesypira.marvelapi.marveljavaapi.repository;

import io.github.jesypira.marvelapi.marveljavaapi.model.creator.Creator;
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
public interface CreatorRepository extends JpaRepository<Creator, Long> {

    @Query(value = " SELECT c FROM Creator c " +
            " join SeriesCreator sc on sc.idCreator = c.id" +
            " where sc.idSeries = :idSeries ")
    List<Creator> findBySeries(@Param("idSeries") Long idSeries);

    @Query(value = " select COUNT(c) FROM Creator c ")
    int countAll();

    @Query(value = " SELECT c FROM Creator c " +
            " join CreatorComic creatorComic on creatorComic.idCreator = c.id" +
            " where creatorComic.idComic = :idComic ")
    List<Creator> findByComic(@Param("idComic") Long idComic);

    @Query(value = " SELECT c FROM Creator c " +
            " join CreatorStory cs on cs.idCreator = c.id" +
            " where cs.idStory = :idStory ")
    List<Creator> findByStory(@Param("idStory") Long idStory);

    @Query(value = " SELECT c FROM Creator c " +
            " join CreatorEvent ce on ce.idCreator = c.id" +
            " where ce.idEvent = :idEvent ")
    List<Creator> findByEvent(@Param("idEvent") Long idEvent);
}
