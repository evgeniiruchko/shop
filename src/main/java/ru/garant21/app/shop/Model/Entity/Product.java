package ru.garant21.app.shop.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="code")
    private Integer code;

    @Column(name ="name")
    private String name;

    @Column(name ="price")
    private Double price;

    @Column(name ="remains")
    private Double remains;

    @Column(name ="isWeight")
    private Boolean isWeight;

    @Column(name ="minprice")
    private Double minPrice;

    @Column(name ="maxdiscount")
    private Double maxDiscount;

    @Column(name ="picture")
    private String picture;

    @Column(name ="description")
    private String description;

    @Column(name ="country")
    private String country;

    @Column(name ="isSale")
    private Boolean isSale;

    @Column(name ="oldprice")
    private Double oldPrice;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;
}
