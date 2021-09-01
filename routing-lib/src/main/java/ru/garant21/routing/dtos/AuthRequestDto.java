package ru.garant21.routing.dtos;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String userName;
    private String password;
}
