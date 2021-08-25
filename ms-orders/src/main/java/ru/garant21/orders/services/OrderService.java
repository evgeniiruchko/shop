package ru.garant21.orders.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.garant21.orders.repository.OrderRepository;
import ru.garant21.routing.dtos.ListIdProducts;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public ListIdProducts getAllProducts() {
        List<Long> productsId = new ArrayList<>();
        orderRepository.findAll().forEach(order -> productsId.add(order.getProductId()));
        ListIdProducts listIdProducts = new ListIdProducts();
        listIdProducts.setListId(productsId);
        return (ListIdProducts) listIdProducts.getListId();
    }
}
