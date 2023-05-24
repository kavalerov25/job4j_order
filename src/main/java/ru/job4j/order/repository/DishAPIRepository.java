package ru.job4j.order.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.job4j.order.model.Dish;

import java.util.Optional;

@Repository
@Slf4j
public class DishAPIRepository  implements DishRepository {

    private final RestTemplate restClient;

    @Value("${url-api.dish}")
    private String urlApiDish;

    public DishAPIRepository(RestTemplate restClient) {
        this.restClient = restClient;
    }
    @Override
    public Optional<Dish> findById(int dishId) {
        String url = String.format("%s/%d", urlApiDish, dishId);
        try {
            Dish dish = restClient.getForObject(
                    url,
                    Dish.class
            );
            return Optional.ofNullable(dish);
        } catch (Exception exception) {
            log.error("Error rest Client: {}", exception);
            return Optional.empty();
        }
    }
}
