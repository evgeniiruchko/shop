package ru.garant21.orders.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.garant21.core.interfaces.ITokenService;
import ru.garant21.core.models.UserInfo;
import ru.garant21.orders.services.CartService;
import ru.garant21.routing.dtos.CartDto;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    private final ITokenService tokenService;

    @PostMapping
    public UUID createNewCart(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String token) {
        if (token == null) {
            return cartService.getCartForUser(null, null);
        }
        UserInfo userInfo = tokenService.parseToken(token);
        return cartService.getCartForUser(userInfo.getUserId(), null);
    }

    @GetMapping("/{uuid}")
    public CartDto getCurrentCart(@PathVariable UUID uuid) {
        return cartService.findById(uuid);
    }

    @PostMapping("/add")
    public void addProductToCart(@RequestParam UUID uuid, @RequestParam(name = "product_id") Long productId) {
        cartService.addToCart(uuid, productId);
    }

    @PostMapping("/clear")
    public void clearCart(@RequestParam UUID uuid) {
        cartService.clearCart(uuid);
    }
}
