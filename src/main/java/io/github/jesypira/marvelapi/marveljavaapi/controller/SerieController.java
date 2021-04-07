package io.github.jesypira.marvelapi.marveljavaapi.controller;

import io.github.jesypira.marvelapi.marveljavaapi.model.event.Event;
import io.github.jesypira.marvelapi.marveljavaapi.model.series.Series;
import io.github.jesypira.marvelapi.marveljavaapi.service.SeriesService;
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
public class SerieController {

    @Autowired
    SeriesService seriesService;

    @GetMapping(path = "/characters/{id}/series", produces = {"application/json"})
    @ApiOperation(value="Returns a List of Series by CharacterId")
    public ResponseEntity findById(@PathVariable("id") Long id){
        List<Series> series = seriesService.findByCharacterId(id);
        if(series.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty List.");
        return ResponseEntity.ok(series);
    }

}
