package ru.job4j.order.mapper;

import org.springframework.stereotype.Component;
import ru.job4j.order.dto.OrderDTO;
import ru.job4j.order.model.Dish;
import ru.job4j.order.model.Order;

@Component
public class OrderDTOMapper {

    public OrderDTO getOrderAndDish(Order order, Dish dish) {
        return new OrderDTO(order.getId(),
                order.getName(),
                order.getDescription(),
                order.getStatus().getId(),
                order.getStatus().getName(),
                dish.getId(),
                dish.getName());
    }
}
