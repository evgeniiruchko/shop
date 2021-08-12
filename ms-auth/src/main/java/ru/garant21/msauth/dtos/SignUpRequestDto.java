package ru.garant21.msauth.dtos;

import lombok.Data;

@Data
public class SignUpRequestDto {
    private String userName;
    private String password;
}
