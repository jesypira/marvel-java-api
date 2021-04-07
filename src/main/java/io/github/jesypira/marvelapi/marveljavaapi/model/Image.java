package io.github.jesypira.marvelapi.marveljavaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Image{
    private String path;
    private String extension;
}
