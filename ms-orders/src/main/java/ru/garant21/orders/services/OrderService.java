package ru.garant21.orders.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.garant21.orders.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Long> getAllProducts() {
        List<Long> productsId = new ArrayList<>();
        orderRepository.findAll().forEach(order -> productsId.add(order.getProductId()));
        return productsId;
    }
}
