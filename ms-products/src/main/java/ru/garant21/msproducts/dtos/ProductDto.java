package ru.garant21.msproducts.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.garant21.msproducts.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Double price;
    private String category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }
}
