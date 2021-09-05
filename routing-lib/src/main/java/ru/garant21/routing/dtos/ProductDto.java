package ru.garant21.routing.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Double price;
    private String category;
}
