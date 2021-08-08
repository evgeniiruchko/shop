DROP TABLE IF EXISTS Payment CASCADE;
CREATE TABLE Payment(
                        id BIGSERIAL NOT NULL PRIMARY KEY,
                        type INTEGER NOT NULL);

INSERT INTO Payment(type)
VALUES
    ('Наличными курьеру'),
    ('Картой курьеру'),
    ('Картой на сайте'),
    ('ApplePay'),
    ('SamsungPay');