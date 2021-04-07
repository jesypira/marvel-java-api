package io.github.jesypira.marvelapi.marveljavaapi.model.summaries;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@Getter
@Setter
public class ItemSummary {

    public ItemSummary(String resourceURI, String name){
        this.resourceURI = resourceURI;
        this.name = name;
    }

    public ItemSummary(String resourceURI, String name, String type){
        this.resourceURI = resourceURI;
        this.name = name;
        this.type = type;
    }

    private String resourceURI;
    private String name;
    private String type;

}
