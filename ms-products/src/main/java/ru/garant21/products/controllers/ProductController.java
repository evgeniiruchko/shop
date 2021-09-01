package ru.garant21.products.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.garant21.core.exceptions.ResourceNotFoundException;
import ru.garant21.products.repository.specifications.ProductSpecifications;
import ru.garant21.routing.dtos.ProductDto;
import ru.garant21.products.entities.Product;
import ru.garant21.products.services.ProductService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }

        return productService.findAll(ProductSpecifications.build(params), page, 4);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findProductDtoById(id).get();
    }

    @GetMapping("/ids")
    public List<ProductDto> findProductById(@RequestParam List<Long> ids) {
        return productService.findProductDtosByIds(ids);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto saveNewProduct(@RequestBody ProductDto product) throws ParseException {
        return productService.saveOrUpdate(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto product) throws ParseException {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void updateProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
