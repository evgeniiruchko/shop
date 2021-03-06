package ru.garant21.products.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.garant21.products.entities.Product;
import ru.garant21.products.repository.ProductsRepository;
import ru.garant21.routing.dtos.ProductDto;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ModelMapper modelMapper;

    private final ProductsRepository productRepository;

    public Optional<ProductDto> findProductDtoById(Long id) {
        return productRepository.findById(id).map(this::toDto);
    }

    public List<ProductDto> findProductDtosByIds(List<Long> ids) {
        return productRepository.findByIdIn(ids).stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(this::toDto);
    }

    public ProductDto saveOrUpdate(ProductDto product) throws ParseException {
        return toDto(productRepository.save(toEntity(product)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDto toDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product toEntity(ProductDto productDto) throws ParseException {
        return modelMapper.map(productDto, Product.class);
    }

}
