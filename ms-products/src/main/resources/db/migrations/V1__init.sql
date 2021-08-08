DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories(
                           id BIGSERIAL NOT NULL PRIMARY KEY,
                           code INTEGER NOT NULL,
                           name VARCHAR(20) NOT NULL);

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE Products(
                         id BIGSERIAL NOT NULL PRIMARY KEY,
                         categories_id BIGSERIAL NOT NULL,
                         code INTEGER NOT NULL,
                         name VARCHAR(200),
                         price NUMERIC(6, 2),
                         remains NUMERIC(6, 2),
                         isWeight BOOLEAN,
                         minprice NUMERIC(6, 2),
                         maxdiscount NUMERIC(3, 2),
                         picture VARCHAR(250),
                         description VARCHAR(1000),
                         country VARCHAR(15),
                         isSale BOOLEAN,
                         oldprice NUMERIC(3, 2));

ALTER TABLE Products ADD CONSTRAINT FK_products_1 FOREIGN KEY (categories_id) REFERENCES
    Categories (id);

INSERT INTO categories (id, name) VALUES
                                       (1, 'Приправы, специи, пищевые концентраты'),
                                       (2, 'Кондитерские, хлебобулочные изделия'),
                                       (3, 'Лимонады, квас, минеральная вода'),
                                       (4, 'Фрукты,овощи, орехи'),
                                       (5, 'Готовые блюда'),
                                       (6, 'Рыба, рыбопродукты'),
                                       (7, 'Алкоголь'),
                                       (8, 'Молочная продукция');

INSERT INTO products (code, name,categories_id, price, isSale, isWeight) VALUES
                                                          (123456, 'Аджика Дядя Ваня 140г соус поабхазски ст/б', 1, 79.90, false, false),
                                                          (123654, 'Батончик Чио Рио 30г с нач.в мягкой карам м/у ', 2, 20.90, false, false),
                                                          (654123, 'Батон Здоровье 350г изд.х/б м/у ОАО Северодвинский ХК', 2, 41.90, false, false),
                                                          (321456, 'Вода питьевая Снежок 5л негазированная артезианская пл/б', 3, 39.90, false, false),
                                                          (321654, 'Грецкий орех очищенный', 4, 999.90, false, true),
                                                          (654321, 'Драже Вафельное в шок.глазури ООО КДВ Яшкино', 2, 449.90, false, false),
                                                          (456123, 'Запеканка картофельная с мясным фаршем ИП Федотова Г.В.', 5, 310.90, false, true),
                                                          (456321, 'КамбалаЕрш вяленый б/г потр.', 6, 1099.90, false, true),
                                                          (789123, 'Вино Алазанская Долина 0.75л стол.бел.п/сл.11% OLD TELAVI', 7, 499.90, false, false),
                                                          (789321, 'Вино Киндзмараули 0,75л красное пл/с регион Кахетия ', 7, 499.90, false, false),
                                                          (123789, 'Вино Киндзмараули 0,75л красное пл/с регион Кахетия ', 7, 399.90, false, false);
INSERT INTO products (code, name, categories_id, price, isSale, oldprice, isWeight) VALUES
                                                                      (123987, 'Изд.кондитерское Хрустиш в конд.глазури Добр.печеньки', 2, 359.90, true, 409.9, false),
                                                                      (987123, 'Икра из кабачков Фрау Марта 320г консервы стерилиз.ж/б ', 1, 41.90, true, 49.90, false),
                                                                      (987321, 'Йогурт Савушкин 120г персикманго 2% с фр.нап.пл/б БЗМЖ', 8, 15.90, true, 19.9, false);