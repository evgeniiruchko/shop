package ru.garant21.routing.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CardDto {
    private Integer number;
    private Double balance;
}
