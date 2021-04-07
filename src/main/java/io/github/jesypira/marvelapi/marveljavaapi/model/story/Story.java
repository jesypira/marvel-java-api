package io.github.jesypira.marvelapi.marveljavaapi.model.story;

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
public class Story implements MarvelObject {
    @Id
    private Long id;
    private String title;
    private String description;
    private String type;
    private Date modified;
    private String resourceURI;

    @Transient
    private Summary series;
    @Transient
    private Summary comics;
    @Transient
    private Summary creators;
    @Transient
    private Summary events;
    @Transient
    private Summary characters;
}
