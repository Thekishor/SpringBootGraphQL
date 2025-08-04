package com.inventory_service.service;

import com.inventory_service.dto.request.ProductRequest;
import com.inventory_service.dto.response.ProductResponse;
import com.inventory_service.entity.Product;
import com.inventory_service.exception.ResourceAlreadyExistsException;
import com.inventory_service.mapper.ProductMapper;
import com.inventory_service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(
            ProductRepository productRepository,
            ProductMapper productMapper
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        if (productRepository.existsByName(productRequest.getName())){
            logger.error("Product exists already into db");
            throw new ResourceAlreadyExistsException("Product already exists with Id");
        }
        Product product = productMapper.productRequestToProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductResponse(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(Integer productId, ProductRequest productRequest) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id:" + productId));
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        Product updatedProduct = productRepository.save(product);
        return productMapper.productToProductResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id:" + productId));
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Integer productId, Integer stock) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id:" + productId));
        product.setStock(stock);
        return productRepository.save(product);
    }

    @Override
    public Product receiveNewShipment(Integer productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id:" + productId));
        product.setStock(product.getStock() + quantity);
        return productRepository.save(product);
    }
}
