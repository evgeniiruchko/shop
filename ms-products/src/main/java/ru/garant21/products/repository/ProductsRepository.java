package ru.garant21.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.garant21.products.entities.Product;
import ru.garant21.routing.dtos.ProductDto;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findProductByTitleContainingIgnoreCase(String title);
    List<Product> findAllByPriceBetween(Double priceMin, Double priceMax);
    //Product findProductById(Long id);
    List<Product> findByIdIn(List<Long> ids);
}
