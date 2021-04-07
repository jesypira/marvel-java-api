package io.github.jesypira.marvelapi.marveljavaapi.controller;

import io.github.jesypira.marvelapi.marveljavaapi.model.comic.Comic;
import io.github.jesypira.marvelapi.marveljavaapi.service.ComicService;
import io.github.jesypira.marvelapi.marveljavaapi.validator.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ComicController {

    @Autowired
    ComicService comicService;

    @GetMapping(path = "/characters/{id}/comics", produces = {"application/json"})
    @ApiOperation(value="Returns a List of Comics by CharacterId")
    public ResponseEntity findById(@PathVariable("id") Long id){
        List<Comic> comics = comicService.findByCharacterId(id);
        if(comics.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty List.");
        return ResponseEntity.ok(comics);
    }

}
