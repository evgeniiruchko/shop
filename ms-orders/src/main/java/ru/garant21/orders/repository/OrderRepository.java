package ru.garant21.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.garant21.orders.entities.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
}
