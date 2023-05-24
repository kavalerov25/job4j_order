package ru.job4j.order.repository;

import ru.job4j.order.model.Dish;

import java.util.Optional;

public interface DishRepository {
    Optional<Dish> findById(int dishId);
}
