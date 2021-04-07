package io.github.jesypira.marvelapi.marveljavaapi.service;

import io.github.jesypira.marvelapi.marveljavaapi.model.story.Story;
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
public class StoryService extends MarvelService{

    public List<Story> findByCharacterId(Long characterId) {
        List<Story> result = storyRepository.findByCharacter(characterId);
        result.stream().map(story -> setStoryRelationships(story)).collect(Collectors.toList());
        return Optional.of(result).orElseThrow(NoResultException::new);
    }

}
