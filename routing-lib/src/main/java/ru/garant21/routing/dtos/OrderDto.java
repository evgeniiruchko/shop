package ru.garant21.routing.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;

    private Long userId;

    private List<ProductDto> products;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
