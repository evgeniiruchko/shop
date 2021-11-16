DROP TABLE IF EXISTS Cards CASCADE;
CREATE TABLE Cards(
                           id BIGSERIAL NOT NULL PRIMARY KEY,
                           number INTEGER NOT NULL,
                           balance DOUBLE);

INSERT INTO Cards (number, balance) VALUES
                                             (000001, 0),
                                             (000002, 10.6);