package ru.garant21.auth.dtos;

import lombok.Data;

@Data
public class SignUpRequestDto {
    private String userName;
    private String password;
}
