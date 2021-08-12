package ru.garant21.app.shop.Model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CounterChange")
@Data
@NoArgsConstructor
public class CounterChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "counter_id")
    private Counter counter;

    @ManyToOne
    @JoinColumn(name = "Orders_id")
    private Order order;

    @Column(name = "delta")
    private Double delta;

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "activateDate")
    private LocalDateTime activateDate;

    @Column(name = "expiredDate")
    private LocalDateTime expiredDate;
}
