package ru.garant21.products.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Remains {
    private Long id;
    private Long productId;
    private Long shopId;
    private Double remains;
}
