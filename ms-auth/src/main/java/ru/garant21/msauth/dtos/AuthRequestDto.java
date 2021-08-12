package ru.garant21.msauth.dtos;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String userName;
    private String password;
}
