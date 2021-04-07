package io.github.jesypira.marvelapi.marveljavaapi.service;

import io.github.jesypira.marvelapi.marveljavaapi.model.series.Series;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Service
public class SeriesService extends MarvelService{

    public List<Series> findByCharacterId(Long characterId) {
        List<Series> result = seriesRepository.findByCharacter(characterId);
        result.stream().map(series -> setSeriesRelationships(series)).collect(Collectors.toList());
        return Optional.of(result).orElseThrow(NoResultException::new);
    }
}
