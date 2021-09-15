package ru.garant21.orders.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.garant21.core.models.UserInfo;
import ru.garant21.orders.services.CartService;
import ru.garant21.orders.services.OrderService;
import ru.garant21.routing.dtos.OrderDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    private final CartService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrderFromCart(@RequestParam UUID cartUuid, @RequestParam String address) {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OrderDto orderDto = orderService.createFromUserCart(userInfo.getUserId(), cartUuid, address);
        cartService.clearCart(cartUuid);
        return orderDto;
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping
    public List<OrderDto> getCurrentUserOrders() {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.findAllOrdersByUserId(userInfo.getUserId());
    }
}
