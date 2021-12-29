package dev.feryadi.belajarspringdataredis;

import lombok.Data;

/**
 * @author Feryadialoi
 * @date 12/12/2021 8:31 PM
 */
@Data
public class ProductResponse {
    private String id;
    private String name;
    private Long price;
}
