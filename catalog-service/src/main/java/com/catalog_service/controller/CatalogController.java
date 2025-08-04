package com.catalog_service.controller;

import com.catalog_service.dto.request.ItemRequest;
import com.catalog_service.dto.response.ItemResponse;
import com.catalog_service.service.CatalogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ItemResponse>> getProducts() {
        List<ItemResponse> itemResponses = catalogService.getProducts();
        return new ResponseEntity<>(itemResponses, HttpStatus.OK);
    }

    @GetMapping("/products/category")
    public ResponseEntity<List<ItemResponse>> getProductByCategory(@RequestParam String category) {
        List<ItemResponse> productsByCategory = catalogService.getProductsByCategory(category);
        return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
    }

    @PostMapping("/shipment")
    public ResponseEntity<ItemResponse> createNewShipment(@Valid @RequestBody ItemRequest itemRequest) {
        ItemResponse itemResponse = catalogService.receiveNewShipment(itemRequest);
        return new ResponseEntity<>(itemResponse, HttpStatus.OK);
    }
}
