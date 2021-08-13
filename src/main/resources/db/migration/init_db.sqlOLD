DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories(
                           id BIGSERIAL NOT NULL PRIMARY KEY,
                           code INTEGER NOT NULL,
                           name VARCHAR(20) NOT NULL);

DROP TABLE IF EXISTS Products CASCADE;
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

DROP TABLE IF EXISTS Delivery CASCADE;
CREATE TABLE Delivery(
                         id BIGSERIAL NOT NULL PRIMARY KEY,
                         type INTEGER NOT NULL);

DROP TABLE IF EXISTS Payment CASCADE;
CREATE TABLE Payment(
                        id BIGSERIAL NOT NULL PRIMARY KEY,
                        type INTEGER NOT NULL);

DROP TABLE IF EXISTS CardTypes CASCADE;
CREATE TABLE CardTypes(
                          id BIGSERIAL NOT NULL PRIMARY KEY,
                          name VARCHAR(20) NOT NULL);

DROP TABLE IF EXISTS Roles CASCADE;
CREATE TABLE Roles(
                      id BIGSERIAL NOT NULL PRIMARY KEY,
                      name VARCHAR(20) NOT NULL);

DROP TABLE IF EXISTS Shops CASCADE;
CREATE TABLE Shops(
                      id BIGSERIAL NOT NULL PRIMARY KEY,
                      city VARCHAR(10) NOT NULL,
                      address VARCHAR(50) NOT NULL);

DROP TABLE IF EXISTS Users CASCADE;
CREATE TABLE Users(
                      Id BIGSERIAL NOT NULL PRIMARY KEY,
                      login VARCHAR(50) NOT NULL,
                      password VARCHAR(200) NOT NULL,
                      name VARCHAR(50) NOT NULL,
                      address VARCHAR(200),
                      phonenumber VARCHAR(12),
                      email VARCHAR(20),
                      birthDay DATE,
                      city VARCHAR(20),
                      favoriteShop BIGSERIAL);

ALTER TABLE Users ADD CONSTRAINT FK_Users_1 FOREIGN KEY (favoriteShop) REFERENCES
    Shops (id);

DROP TABLE IF EXISTS Cards CASCADE;
CREATE TABLE Cards(
                      id BIGSERIAL NOT NULL PRIMARY KEY,
                      Users_Id BIGSERIAL NOT NULL,
                      number INTEGER NOT NULL,
                      cardtypes_id BIGSERIAL NOT NULL);

ALTER TABLE Cards ADD CONSTRAINT FK_cards_1 FOREIGN KEY (Users_Id) REFERENCES
    Users (Id);
ALTER TABLE Cards ADD CONSTRAINT FK_cards_2 FOREIGN KEY (cardtypes_id) REFERENCES
    CardTypes (id);

DROP TABLE IF EXISTS Counters CASCADE;
CREATE TABLE Counters(
                         id BIGSERIAL NOT NULL PRIMARY KEY,
                         name VARCHAR(20) NOT NULL,
                         Cards_id INTEGER NOT NULL);

ALTER TABLE Counters ADD CONSTRAINT FK_Counters_1 FOREIGN KEY (Cards_id) REFERENCES
    Cards (id);

DROP TABLE IF EXISTS Orders CASCADE;
CREATE TABLE Orders(
                       id BIGSERIAL NOT NULL PRIMARY KEY,
                       Users_Id BIGSERIAL NOT NULL,
                       Products_id BIGSERIAL NOT NULL,
                       count NUMERIC(6, 2),
                       price NUMERIC(6, 2),
                       sum NUMERIC(6, 2),
                       totalSum NUMERIC(6, 2),
                       date DATE,
                       Delivery_id BIGSERIAL NOT NULL,
                       Payment_id BIGSERIAL NOT NULL,
                       bonusAccrued FLOAT,
                       bonusPay FLOAT);

ALTER TABLE Orders ADD CONSTRAINT FK_Orders_1 FOREIGN KEY (Users_Id) REFERENCES
    Users (Id);
ALTER TABLE Orders ADD CONSTRAINT FK_Orders_2 FOREIGN KEY (Products_id) REFERENCES
    Products (id);
ALTER TABLE Orders ADD CONSTRAINT FK_Orders_3 FOREIGN KEY (Delivery_id) REFERENCES
    Delivery (id);
ALTER TABLE Orders ADD CONSTRAINT FK_Orders_4 FOREIGN KEY (Payment_id) REFERENCES
    Payment (id);

DROP TABLE IF EXISTS CounterChange CASCADE;
CREATE TABLE CounterChange(
                              id BIGSERIAL NOT NULL PRIMARY KEY,
                              counter_id BIGSERIAL NOT NULL,
                              Orders_id BIGSERIAL NOT NULL,
                              delta NUMERIC(6, 2) NOT NULL,
                              date DATE,
                              activateDate DATE,
                              expiredDate DATE);

ALTER TABLE CounterChange ADD CONSTRAINT FK_counter_1_1 FOREIGN KEY (counter_id) REFERENCES
    Counters (id);
ALTER TABLE CounterChange ADD CONSTRAINT FK_CounterChange_1 FOREIGN KEY (Orders_id) REFERENCES
    Orders (id);

CREATE TABLE Users_roles(
                            id BIGSERIAL NOT NULL PRIMARY KEY,
                            Users_Id BIGSERIAL NOT NULL,
                            Roles_id BIGSERIAL NOT NULL);

ALTER TABLE Users_roles ADD CONSTRAINT FK_users_roles_1 FOREIGN KEY (Users_Id) REFERENCES
    Users (Id);
ALTER TABLE Users_roles ADD CONSTRAINT FK_users_roles_2 FOREIGN KEY (Roles_id) REFERENCES
    Roles (id);