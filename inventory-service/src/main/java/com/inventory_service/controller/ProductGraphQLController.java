package com.inventory_service.controller;

import com.inventory_service.entity.Product;
import com.inventory_service.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductGraphQLController {

    private final ProductService productService;

    public ProductGraphQLController(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @QueryMapping
    public List<Product> getProductByCategory(@Argument String category){
        return productService.getProductByCategory(category);
    }

    //for create, update and delete use this annotation
    @MutationMapping
    public Product updateStock(@Argument Integer productId, @Argument Integer stock){
        return productService.updateStock(productId, stock);
    }

    @MutationMapping
    public Product receiveNewShipment(@Argument Integer productId, @Argument Integer quantity){
        return productService.receiveNewShipment(productId, quantity);
    }
}
