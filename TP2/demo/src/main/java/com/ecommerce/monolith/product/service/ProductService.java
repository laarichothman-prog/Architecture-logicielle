package com.ecommerce.monolith.product.service;

import com.ecommerce.monolith.product.dto.ProductDto;
import com.ecommerce.monolith.product.dto.ProductRequest;
import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductRequest request);
    ProductDto updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
}
