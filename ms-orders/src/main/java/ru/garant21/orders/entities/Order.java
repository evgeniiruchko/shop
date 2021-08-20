package ru.garant21.orders.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="orderNumber")
    private String orderNumber;

    @Column(name ="Users_Id")
    private Long usersId;

    @Column(name ="Products_id")
    private Long ProductId;

    @Column(name ="count")
    private Double count;

    @Column(name ="price")
    private Double price;

    @Column(name ="sum")
    private Double sum;

    @Column(name ="totalSum")
    private Double totalSum;

    @Column(name ="date")
    private Date date;

    @Column(name ="Delivery_id")
    private Long DeliveryId;

    @Column(name ="Payment_id")
    private Long PaymentId;

    @Column(name ="bonusAccrued")
    private Double bonusAccrued;

    @Column(name ="bonusPay")
    private Double bonusPay;
}
