package io.github.jesypira.marvelapi.marveljavaapi.model.creator;

import io.github.jesypira.marvelapi.marveljavaapi.model.MarvelObject;
import io.github.jesypira.marvelapi.marveljavaapi.model.summaries.Summary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Creator implements MarvelObject {
    @Id
    private Long id;
    private String name;
    private String resourceURI;


    @Transient
    private Summary stories;
    @Transient
    private Summary series;
    @Transient
    private Summary events;
    @Transient
    private Summary comics;
}
