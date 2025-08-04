package com.inventory_service.mapper;

import com.inventory_service.dto.request.ProductRequest;
import com.inventory_service.dto.response.ProductResponse;
import com.inventory_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    Product productRequestToProduct(ProductRequest productRequest);

    @Mapping(target = "productId", source = "product.id")
    ProductResponse productToProductResponse(Product product);
}
