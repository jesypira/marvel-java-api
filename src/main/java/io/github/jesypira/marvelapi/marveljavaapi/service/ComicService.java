package io.github.jesypira.marvelapi.marveljavaapi.service;

import io.github.jesypira.marvelapi.marveljavaapi.model.comic.Comic;
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
public class ComicService extends MarvelService{

    public List<Comic> findByCharacterId(Long characterId) {
        List<Comic> result = comicRepository.findByCharacter(characterId);
        result.stream().map(comic -> setComicRelationships(comic)).collect(Collectors.toList());
        return Optional.of(result).orElseThrow(NoResultException::new);
    }
}
