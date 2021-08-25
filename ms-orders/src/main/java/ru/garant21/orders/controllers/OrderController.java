package ru.garant21.orders.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.garant21.orders.services.OrderClient;
import ru.garant21.orders.services.OrderService;
import ru.garant21.products.dtos.ProductDto;
import ru.garant21.routing.dtos.ListIdProducts;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderClient orderClient;

    @GetMapping("/get-from-orders")
    public List<ProductDto> getProductsByListId(ListIdProducts listId) {
        return orderClient.getProductsByListId(orderService.getAllProducts());
    }
}
