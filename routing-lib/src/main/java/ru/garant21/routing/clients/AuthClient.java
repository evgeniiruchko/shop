package ru.garant21.routing.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.garant21.routing.dtos.AuthResponseDto;
import ru.garant21.routing.dtos.SignUpRequestDto;

@FeignClient("ms-auth")
public interface AuthClient {

    @PostMapping("/signup")
    String signUp(@RequestBody SignUpRequestDto signUpRequest);

    @PostMapping("/login")
    AuthResponseDto login(@RequestBody AuthResponseDto request);
}
