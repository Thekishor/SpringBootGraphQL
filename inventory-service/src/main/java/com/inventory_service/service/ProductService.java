package com.inventory_service.service;

import com.inventory_service.dto.request.ProductRequest;
import com.inventory_service.dto.response.ProductResponse;
import com.inventory_service.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

    List<Product> getProducts();

    List<Product> getProductByCategory(String category);

    Product updateStock(Integer productId, Integer stock);

    Product receiveNewShipment(Integer productId, Integer quantity);
}
