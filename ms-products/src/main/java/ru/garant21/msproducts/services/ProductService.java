package ru.garant21.msproducts.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.garant21.msproducts.dtos.ProductDto;
import ru.garant21.msproducts.entities.Product;
import ru.garant21.msproducts.repository.ProductsRepoInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductsRepoInterface productsRepoInterface;

    public int getCountProducts() {
        return (int) productsRepoInterface.count();
    }

    public Optional<ProductDto> getProductById(Long id) {
        return productsRepoInterface.findById(id).map(ProductDto::new);
    }

    public List<Product> getProductByTitle(String title) {
        return productsRepoInterface.findProductByTitleContainingIgnoreCase(title);
    }

    //получаем массив ProductDto в диапозоне цен
    public List<ProductDto> getProductBetweenPrices(float priceMin, float priceMax) {
        return productsRepoInterface.findAllByPriceBetween(priceMin, priceMax).stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    public void deleteById (Long id) {
        productsRepoInterface.deleteById(id);
    }

    public Product saveProduct (Product product) {
        return productsRepoInterface.save(product);
    }

}
