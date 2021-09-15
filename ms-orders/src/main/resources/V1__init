DROP TABLE IF EXISTS Orders CASCADE;
CREATE TABLE Orders(
                       id BIGSERIAL NOT NULL PRIMARY KEY,
                       orderNumber VARCHAR(10) NOT NULL,
                       Users_Id INTEGER NOT NULL,
                       Products_id INTEGER NOT NULL,
                       count NUMERIC(6, 2),
                       price NUMERIC(6, 2),
                       sum NUMERIC(6, 2),
                       totalSum NUMERIC(6, 2),
                       date DATE,
                       Delivery_id INTEGER NOT NULL,
                       Payment_id INTEGER NOT NULL,
                       bonusAccrued FLOAT,
                       bonusPay FLOAT);

INSERT INTO Orders (orderNumber, Users_Id, Products_id,count, price, totalSum, Delivery_id, Payment_id) VALUES
      ('000000001a', 1, 1, 1, 79.90, 79.90, 1, 1),
      ('000000001a', 1, 2, 2, 20.90, 41.8, 1, 1),
      ('000000001a', 1, 3, 1, 41.90, 41.9, 1, 1),
      ('000000002a', 1, 4, 1, 39.90, 39.90, 1, 1),
      ('000000002a', 1, 5, 1, 999.90, 999.90, 1, 1),
      ('000000002a', 1, 6, 2, 449.90, 899.8, 1, 1),
      ('000000001b', 2, 7, 1, 310.90, 310.9, 1, 1),
      ('000000001b', 2, 8, 1, 1099.90, 1099.9, 1, 1),
      ('000000002c', 2, 9, 2, 499.90, 999.8, 1, 1),
      ('000000003d', 2, 10, 2, 20.90, 41.8, 1, 1),
      ('000000003d', 2, 11, 1, 399.90, 399.9, 1, 1);

