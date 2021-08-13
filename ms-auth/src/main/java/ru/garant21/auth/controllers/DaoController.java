package ru.garant21.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.garant21.auth.services.UserService;

@RestController
@RequiredArgsConstructor
public class DaoController {

    private final UserService userService;

//    @GetMapping
//    public String TestPage(Principal principal){
//        try {
//            User user = userService.findUserByUserName(principal.getName()).orElseThrow(() -> new NullPointerException("Надо авторизоваться"));
//            return "Привет " + user.getUsername();
//        } catch (NullPointerException e) {
//            return "Для выполнения команд необходимо <a href = \"login\"> авторизоваться </a>";
//        }
//    }

}
