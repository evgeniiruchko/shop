package ru.garant21.orders.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.garant21.products.dtos.ProductDto;
import ru.garant21.routing.dtos.ListIdProducts;

import java.util.List;

@FeignClient("ms-products")
public interface OrderClient {
    @GetMapping("/get-from-orders")
    public List<ProductDto> getProductsByListId(@RequestBody ListIdProducts listId);
}
