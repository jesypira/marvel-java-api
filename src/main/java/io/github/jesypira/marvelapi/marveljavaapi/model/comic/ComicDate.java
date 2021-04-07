package io.github.jesypira.marvelapi.marveljavaapi.model.comic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ComicDate {
    private String type;
    private Date date;
}
