package io.github.jesypira.marvelapi.marveljavaapi.controller;

import io.github.jesypira.marvelapi.marveljavaapi.model.character.Character;
import io.github.jesypira.marvelapi.marveljavaapi.service.CharacterService;
import io.github.jesypira.marvelapi.marveljavaapi.validator.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@RestController
@RequestMapping("/v1/public")
@Api(value="Marvel Java API REST")
@CrossOrigin(origins="*")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    @ApiOperation(value="Returns a list of Characters")
    public ResponseEntity listCharacters(){
        List<Character> characters = characterService.findAll();
        if(characters.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty List.");
        return ResponseEntity.ok(characters);
    }

    @GetMapping(path = "/characters/{id}", produces = {"application/json"})
    @ApiOperation(value="Returns a Character by Id")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Character character = characterService.findById(id);
        if(ValidatorUtil.isEmpty(character))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Character not found.");
        return ResponseEntity.ok(character);
    }

}
