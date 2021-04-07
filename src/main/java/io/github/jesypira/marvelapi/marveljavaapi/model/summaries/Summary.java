package io.github.jesypira.marvelapi.marveljavaapi.model.summaries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Summary {

    private List<ItemSummary> itens;
    private int available;
    private String collectionURI;
    private int returned;

}
