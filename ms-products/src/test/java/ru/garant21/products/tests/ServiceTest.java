package ru.garant21.products.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import ru.garant21.products.entities.Category;
import ru.garant21.products.entities.Product;
import ru.garant21.products.repository.ProductsRepository;
import ru.garant21.products.services.ProductService;
import ru.garant21.routing.dtos.ProductDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest (classes = {ProductService.class, ModelMapper.class})
public class ServiceTest {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductsRepository productsRepository;

    @Test
    public void testGetProduct() {
        Product product = new Product();
        Category category = new Category();
        category.setId(1L);
        category.setTitle("Test");
        product.setCode(111);
        product.setCategory(category);
        product.setId(1L);
        product.setTitle("Test");

        Mockito
                .doReturn(Optional.of(product))
                .when(productsRepository)
                .findById(1L);

        ProductDto p = productService.findProductDtoById(1L).get();
        Assertions.assertEquals("Test", p.getTitle());
    }

    @Test
    public void testGetListProductsByIds() {
        List<Long> idsList = new ArrayList(Arrays.asList(1L, 3L, 5L));
        List<Product> productList = new ArrayList<>();

        Category category = new Category();
        category.setId(1L);
        category.setTitle("Test");

        Product product_1 = new Product();
        Product product_2 = new Product();
        Product product_3 = new Product();
        product_1.setCode(111);
        product_1.setCategory(category);
        product_1.setId(1L);
        product_1.setTitle("Test_1");
        product_2.setCode(222);
        product_2.setCategory(category);
        product_2.setId(2L);
        product_2.setTitle("Test_2");
        product_3.setCode(333);
        product_3.setCategory(category);
        product_3.setId(3L);
        product_3.setTitle("Test_3");

        productList.add(product_1);
        productList.add(product_3);

        Mockito
                .doReturn(productList)
                .when(productsRepository)
                .findByIdIn(idsList);

        List<ProductDto> pl = productService.findProductDtosByIds(idsList);
        Assertions.assertEquals("Test_1", pl.get(0).getTitle());
        Assertions.assertEquals(3, pl.get(1).getId());
        Assertions.assertEquals(2, pl.size());
        Mockito.verify(productsRepository, Mockito.times(1)).findByIdIn(ArgumentMatchers.eq(idsList));
    }
}
