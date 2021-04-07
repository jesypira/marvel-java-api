package io.github.jesypira.marvelapi.marveljavaapi.service;

import io.github.jesypira.marvelapi.marveljavaapi.model.character.Character;
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
public class CharacterService extends MarvelService {

    public List<Character> findAll(){
        List<Character> result = characterRepository.findAll();
        result.stream().map(character -> setCharacterRelationships(character)).collect(Collectors.toList());
        return Optional.of(result).orElseThrow(NoResultException::new);
    }

    public Character findById(Long id) {
        Character character = characterRepository.findFirstById(id);
        if(character!=null)
            setCharacterRelationships(character);
        return character;
    }

}
