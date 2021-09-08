DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories(
                           id BIGSERIAL NOT NULL PRIMARY KEY,
                           code INTEGER NOT NULL,
                           title VARCHAR(200) NOT NULL);

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE Products(
                         id BIGSERIAL NOT NULL PRIMARY KEY,
                         categories_id INTEGER NOT NULL,
                         code INTEGER NOT NULL,
                         title VARCHAR(200),
                         price NUMERIC(6, 2),
                         remains NUMERIC(6, 2),
                         isweight BOOLEAN,
                         minprice NUMERIC(6, 2),
                         maxdiscount NUMERIC(5, 2),
                         picture VARCHAR(250),
                         description VARCHAR(1000),
                         country VARCHAR(15),
                         issale BOOLEAN,
                         oldprice NUMERIC(6, 2));

ALTER TABLE Products ADD CONSTRAINT FK_products_1 FOREIGN KEY (categories_id) REFERENCES
    Categories (id);

INSERT INTO categories (code, id, title) VALUES
                                       (000001, 1, 'Приправы, специи, пищевые концентраты'),
                                       (000002, 2, 'Кондитерские, хлебобулочные изделия');
INSERT INTO products (code, title,categories_id, price, isSale, isWeight) VALUES
                                        (123456, 'Аджика Дядя Ваня 140г соус поабхазски ст/б', 1, 79.90, false, false),
                                        (123654, 'Батончик Чио Рио 30г с нач.в мягкой карам м/у ', 2, 20.90, false, false);
INSERT INTO products (code, title, categories_id, price, isSale, oldprice, isWeight) VALUES
                                        (123987, 'Изд.кондитерское Хрустиш в конд.глазури Добр.печеньки', 2, 359.90, true, 409.9, false);
