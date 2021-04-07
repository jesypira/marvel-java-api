package io.github.jesypira.marvelapi.marveljavaapi.model.story;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@Entity
public class StoryComic implements Serializable {
    @Id
    Long idStory;
    @Id
    Long idComic;
}
