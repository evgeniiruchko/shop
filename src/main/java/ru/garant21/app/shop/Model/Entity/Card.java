package ru.garant21.app.shop.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Data
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Long number;

    @OneToOne
    @JoinColumn(name ="Users_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cardtypes_id")
    private CardType cardType;

    @OneToOne(mappedBy = "card")
    Counter counter;
}
