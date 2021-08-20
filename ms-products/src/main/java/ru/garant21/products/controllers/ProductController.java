package ru.garant21.products.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.garant21.core.exceptions.ResourceNotFoundException;
import ru.garant21.products.dtos.ProductDto;
import ru.garant21.products.entities.Product;
import ru.garant21.products.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping ("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Товар с id = " + id + " Не найден"));
    }

    @GetMapping ("/title")
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping
    public List<ProductDto> getProductBeforeMaxPrice(@RequestParam(name = "min_price", defaultValue = "0") Double priceMin,
                                                  @RequestParam(name = "max_price", required = false) Double priceMax)
    {
        if (priceMax == null) {
            priceMax = Double.MAX_VALUE;
        }
        return productService.getProductBetweenPrices(priceMin, priceMax);
    }

    @GetMapping("/get-from-orders")
    public List<ProductDto> getProductsByListId(@RequestBody List<Long> listId) {
        return productService.getProductsBiIds(listId);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
            return productService.saveProduct(product);
    }
}
