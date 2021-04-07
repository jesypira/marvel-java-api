package io.github.jesypira.marvelapi.marveljavaapi.model.character;

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
public class Character implements MarvelObject {

   @Id
   private Long id;
   private String name;
   private String description;
   private Date modified;
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
