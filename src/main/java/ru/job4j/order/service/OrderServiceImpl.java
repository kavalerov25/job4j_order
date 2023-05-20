package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Order;
import ru.job4j.order.model.Status;
import ru.job4j.order.repository.OrderRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> create(Order order) {
        try {
            orderRepository.save(order);
            return Optional.of(order);
        } catch (Exception e) {
            log.error("Fail create order: {}, error: {}", order, e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Order> findOrderById(int orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public boolean update(Order order) {
        try {
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            log.error("Fail update order: {}, error: {}", order, e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int orderId) {
        try {
            orderRepository.deleteById(orderId);
            return true;
        } catch (Exception e) {
            log.error("Fail delete orderId: {}, error: {}", orderId, e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Status> getStatusByOrderId(int orderId) {
        return findOrderById(orderId).map(Order::getStatus);
    }
}
