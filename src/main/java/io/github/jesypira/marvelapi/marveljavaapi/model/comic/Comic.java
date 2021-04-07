package io.github.jesypira.marvelapi.marveljavaapi.model.comic;

import io.github.jesypira.marvelapi.marveljavaapi.model.*;
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
public class Comic implements MarvelObject {

    @Id
    private Long id;
    private Long digitalId;
    private String title;
    private Double issueNumber;
    private String variantDescription;
    private Date modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;
    private Long seriesSummaryId;
    private String resourceURI;


    @Transient
    private Summary series;
    @Transient
    private Summary stories;
    @Transient
    private Summary events;
    @Transient
    private Summary creators;
    @Transient
    private Summary characters;

}
