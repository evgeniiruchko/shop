package ru.garant21.msproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.garant21.msproducts.entities.Product;

import java.util.List;


@Repository
public interface ProductsRepoInterface extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findProductByTitleContainingIgnoreCase(String title);
    List<Product> findAllByPriceGreaterThanEqual(Float price);
    List<Product> findAllByPriceLessThanEqual(Float price);
    List<Product> findAllByPriceBetween(Float priceMin, Float priceMax);
    List<Product> findAllBySaleIsTrueAndOldPriceNotNull();
    Product findProductById(Long id);
}
