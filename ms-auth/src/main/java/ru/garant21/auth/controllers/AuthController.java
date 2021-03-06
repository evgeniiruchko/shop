package ru.garant21.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.garant21.auth.enteties.User;
import ru.garant21.auth.services.UserService;
import ru.garant21.core.interfaces.ITokenService;
import ru.garant21.core.models.UserInfo;
import ru.garant21.core.repositories.RedisRepository;
import ru.garant21.routing.dtos.AuthRequestDto;
import ru.garant21.routing.dtos.AuthResponseDto;
import ru.garant21.routing.dtos.SignUpRequestDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final ITokenService iTokenService;

    private final RedisRepository redisRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody SignUpRequestDto signUpRequestDto) {
        User user = new User();
        user.setPassword(signUpRequestDto.getPassword());
        user.setUsername(signUpRequestDto.getUserName());
        userService.saveUser(user);
    }

    @PostMapping("/login")
    public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto) {
        User user = userService.findUserByUserNameAndPassword(authRequestDto.getUserName(), authRequestDto.getPassword());
        List<String> roles = new ArrayList<>();
        user.getRoles().forEach(role -> roles.add(role.getName()));
        UserInfo userInfo = UserInfo.builder()
                .userId(user.getId())
                .userEmail(user.getEmail())
                .roles(roles)
                .build();
        String token = iTokenService.generateToken(userInfo);
        return new AuthResponseDto(token);
    }

    @GetMapping("/logout")
    public Boolean logout(@RequestHeader("Authorization") String token) {
        redisRepository.saveToken(token);
        return true;
    }
}
