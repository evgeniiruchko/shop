package ru.garant21.auth.dtos;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String userName;
    private String password;
}
