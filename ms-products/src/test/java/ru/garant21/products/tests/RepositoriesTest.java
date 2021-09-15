package ru.garant21.products.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.garant21.products.entities.Category;
import ru.garant21.products.entities.Product;
import ru.garant21.products.repository.CategoryRepository;
import ru.garant21.products.repository.ProductsRepository;
import ru.garant21.routing.dtos.ProductDto;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class RepositoriesTest {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void initDbTestProducts() {
        List<Product> productList = productsRepository.findAll();
        Assertions.assertEquals(3, productList.size());
    }

    @Test
    public void initDbTestCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        Assertions.assertEquals(2, categoryList.size());
    }

    @Test
    public void findByIdInTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<Product> productList = productsRepository.findByIdIn(ids);
        Assertions.assertEquals(2, productList.size());
    }
}
