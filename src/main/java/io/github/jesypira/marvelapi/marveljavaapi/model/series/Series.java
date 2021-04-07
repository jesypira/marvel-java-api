package io.github.jesypira.marvelapi.marveljavaapi.model.series;

import io.github.jesypira.marvelapi.marveljavaapi.model.MarvelObject;
import io.github.jesypira.marvelapi.marveljavaapi.model.summaries.Summary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Series implements MarvelObject {
    @Id
    private Long id;
    private String title;
    private String description;
    private int startYear;
    private int endYear;
    private String rating;
    private Date modified;
    private Long nextSeriesId;
    private Long previousSeriesId;
    private String resourceURI;


    @Transient
    private Summary comics;
    @Transient
    private Summary stories;
    @Transient
    private Summary events;
    @Transient
    private Summary characters;
    @Transient
    private Summary creators;
}
