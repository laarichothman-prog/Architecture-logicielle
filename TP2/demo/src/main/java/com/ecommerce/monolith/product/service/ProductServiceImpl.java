package com.ecommerce.monolith.product.service;

import com.ecommerce.monolith.product.dto.ProductDto;
import com.ecommerce.monolith.product.dto.ProductRequest;
import com.ecommerce.monolith.product.mapper.ProductMapper;
import com.ecommerce.monolith.product.model.Product;
import com.ecommerce.monolith.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProductById(Long id) {
        Product product = repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        return mapper.toDTO(product);
    }

    @Override
    public ProductDto createProduct(ProductRequest request) {
        Product product = mapper.toEntity(request);
        return mapper.toDTO(repository.save(product));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductRequest request) {
        Product product = repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        mapper.updateEntity(request, product);
        return mapper.toDTO(repository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
