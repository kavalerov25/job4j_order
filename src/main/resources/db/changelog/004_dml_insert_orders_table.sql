INSERT INTO orders(order_name, order_description, status_id, dish_id)
VALUES ('Хочу пиццу', 'Оплата по карте',
        (SELECT s.id FROM statuses AS s WHERE s.status_name = 'Create'),
        1);