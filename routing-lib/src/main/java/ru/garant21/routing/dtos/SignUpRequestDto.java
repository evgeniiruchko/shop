package ru.garant21.routing.dtos;

import lombok.Data;

@Data
public class SignUpRequestDto {
    private String userName;
    private String password;
}
