package ru.garant21.orders.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.garant21.core.models.UserInfo;
import ru.garant21.orders.services.CartService;
import ru.garant21.routing.dtos.CartDto;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public UUID createNewCart() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null) {
            return cartService.getCartForUser(null, null);
        }
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return cartService.getCartForUser(userInfo.getUserId(), null);
    }

    @GetMapping("/{uuid}")
    public CartDto getCurrentCart(@PathVariable String uuid) {
        return cartService.findById(UUID.fromString(uuid));
    }

    @PostMapping("/add")
    public void addProductToCart(@RequestParam String uuid, @RequestParam(name = "product_id") Long productId) {
        cartService.addToCart(UUID.fromString(uuid), productId);
    }

    @PostMapping("/clear")
    public void clearCart(@RequestParam String uuid) {
        cartService.clearCart(UUID.fromString(uuid));
    }
}
