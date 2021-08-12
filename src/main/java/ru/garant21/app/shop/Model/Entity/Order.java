package ru.garant21.app.shop.Model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    /*                     Users_Id BIGSERIAL NOT NULL,
                         Products_id BIGSERIAL NOT NULL,
                         count NUMERIC(6, 2),,
                         price NUMERIC(6, 2),,
                         sum NUMERIC(6, 2),,
                         totalSum NUMERIC(6, 2),,
                         date DATE,
                         Delivery_id BIGSERIAL NOT NULL,
                         Payment_id BIGSERIAL NOT NULL,
                         bonusAccrued FLOAT,
                         bonusPay FLOAT*/

}
