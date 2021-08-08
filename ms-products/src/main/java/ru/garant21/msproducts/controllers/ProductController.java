package ru.garant21.msproducts.controllers;

import org.springframework.web.bind.annotation.*;
import ru.garant21.core.exceptions.ResourceNotFoundException;
import ru.garant21.msproducts.dtos.ProductDto;
import ru.garant21.msproducts.entities.Product;
import ru.garant21.msproducts.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping ("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Товар с id = " + id + " Не найден"));
    }

    @GetMapping ("/title")
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping
    public List<ProductDto> getProductBeforeMaxPrice(@RequestParam(name = "min_price", defaultValue = "0") Float priceMin,
                                                  @RequestParam(name = "max_price", required = false) Float priceMax)
    {
        if (priceMax == null) {
            priceMax = Float.MAX_VALUE;
        }
        return productService.getProductBetweenPrices(priceMin, priceMax);
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
