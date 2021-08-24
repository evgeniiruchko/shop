DROP TABLE IF EXISTS Users CASCADE;
CREATE TABLE Users(
                      Id BIGSERIAL NOT NULL PRIMARY KEY,
                      login VARCHAR(50) NOT NULL,
                      password VARCHAR(200) NOT NULL,
                      name VARCHAR(50),
                      address VARCHAR(200),
                      phonenumber VARCHAR(12),
                      email VARCHAR(20),
                      birthday DATE,
                      city VARCHAR(20),
                      favoriteshop INTEGER );

-- ALTER TABLE Users ADD CONSTRAINT FK_Users_1 FOREIGN KEY (favoriteShop) REFERENCES
--     Shops (id);

DROP TABLE IF EXISTS Roles CASCADE;
CREATE TABLE Roles(
                      id BIGSERIAL NOT NULL PRIMARY KEY,
                      name VARCHAR(20) NOT NULL);

CREATE TABLE Users_roles(
                            id BIGSERIAL NOT NULL PRIMARY KEY,
                            User_Id INTEGER NOT NULL,
                            Role_id INTEGER NOT NULL);

insert into roles (name)
values
    ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (login, password, email, name)
values
    ('user', '{bcrypt}$2y$12$mFUdPh8.ESnhu.eyDjxrYuSigUIOboDP94mt7vuNhf604Yw0iuKQa', 'user@gmail.com', 'Пользователь'),
    ('admin', '{bcrypt}$2y$12$mFUdPh8.ESnhu.eyDjxrYuSigUIOboDP94mt7vuNhf604Yw0iuKQa', 'admin@gmail.com', 'Администратор');

insert into users_roles (user_id, role_id)
values
    (1, 1),
    (2, 1),
    (2, 2);