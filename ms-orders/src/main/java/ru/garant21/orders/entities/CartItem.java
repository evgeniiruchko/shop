package ru.garant21.orders.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.garant21.routing.dtos.ProductDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "price_per_product")
    private Double pricePerProduct;

    @Column(name = "price")
    private Double price;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void incrementQuantity() {
        quantity++;
        price = quantity * pricePerProduct;
    }

    public void incrementQuantity(double amount) {
        quantity += amount;
        price = quantity * pricePerProduct;
    }

    public void decrementQuantity() {
        quantity--;
        price = quantity * pricePerProduct;
    }

    public CartItem(ProductDto product) {
        this.productId = product.getId();
        this.quantity = 1.0;
        this.pricePerProduct = product.getPrice();
        this.price = this.pricePerProduct;
    }
}
