package io.github.jesypira.marvelapi.marveljavaapi.service;

import io.github.jesypira.marvelapi.marveljavaapi.model.event.Event;
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
public class EventService extends MarvelService{

    public List<Event> findByCharacterId(Long characterId) {
        List<Event> result = eventRepository.findByCharacter(characterId);
        result.stream().map(event -> setEventRelationships(event)).collect(Collectors.toList());
        return Optional.of(result).orElseThrow(NoResultException::new);
    }

}
