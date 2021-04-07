package io.github.jesypira.marvelapi.marveljavaapi.model.event;

import io.github.jesypira.marvelapi.marveljavaapi.model.MarvelObject;
import io.github.jesypira.marvelapi.marveljavaapi.model.character.Character;
import io.github.jesypira.marvelapi.marveljavaapi.model.comic.Comic;
import io.github.jesypira.marvelapi.marveljavaapi.model.summaries.Summary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event implements MarvelObject {
    @Id
    private Long id;
    private String title;
    private String description;
    private Date modified;
    private Date startDate;
    private Date endDate;
    private Long nextEventId;
    private Long previousEventId;
    private String resourceURI;


    @Transient
    private Summary stories;
    @Transient
    private Summary series;
    @Transient
    private Summary comics;
    @Transient
    private Summary creators;
    @Transient
    private Summary characters;

}
