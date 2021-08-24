package ru.garant21.products.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.garant21.products.entities.Category;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;

    public CategoryDto (Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }
}