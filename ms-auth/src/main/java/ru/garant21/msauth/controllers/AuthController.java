package ru.garant21.msauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.garant21.msauth.dtos.AuthRequestDto;
import ru.garant21.msauth.dtos.AuthResponseDto;
import ru.garant21.msauth.dtos.SignUpRequestDto;
import ru.garant21.msauth.enteties.User;
import ru.garant21.msauth.configurations.JwtProvider;
import ru.garant21.msauth.services.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/signup")
    public String registerUser(@RequestBody SignUpRequestDto signUpRequestDto) {
        User user = new User();
        user.setPassword(signUpRequestDto.getPassword());
        user.setUsername(signUpRequestDto.getUserName());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/login")
    public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto) {
        User user = userService.findUserByUserAndPassword(authRequestDto.getUserName(), authRequestDto.getPassword());
        String token = jwtProvider.generateToken(user.getUsername());
        return new AuthResponseDto(token);
    }
}
