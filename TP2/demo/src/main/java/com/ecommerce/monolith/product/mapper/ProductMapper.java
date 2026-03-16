package com.ecommerce.monolith.product.mapper;

import com.ecommerce.monolith.product.dto.ProductDto;
import com.ecommerce.monolith.product.dto.ProductRequest;
import com.ecommerce.monolith.product.model.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDTO(Product product);

    List<ProductDto> toDTOList(List<Product> products);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntity(ProductRequest request, @MappingTarget Product product);
}
