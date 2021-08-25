package ru.garant21.products.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.garant21.products.dtos.ProductDto;
import ru.garant21.products.entities.Product;
import ru.garant21.products.repository.ProductsRepoInterface;
import ru.garant21.routing.dtos.ListIdProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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
    public List<ProductDto> getProductBetweenPrices(Double priceMin, Double priceMax) {
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

    public List<ProductDto> getProductsBiIds(ListIdProducts listId) {
        List<ProductDto> products = null;
        for (Long id : listId.getListId()) {
            if (getProductById(id).isPresent()) {
                products.add(getProductById(id).get());
            }
        }
        return products;
    }

}
