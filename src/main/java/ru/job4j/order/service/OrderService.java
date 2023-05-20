package ru.job4j.order.service;

import ru.job4j.order.model.Order;
import ru.job4j.order.model.Status;

import java.util.Optional;

public interface OrderService {
    Optional<Order> create(Order order);
    Optional<Order> findOrderById(int orderId);
    boolean update(Order order);
    boolean delete(int orderId);
    Optional<Status> getStatusByOrderId(int orderId);
}
