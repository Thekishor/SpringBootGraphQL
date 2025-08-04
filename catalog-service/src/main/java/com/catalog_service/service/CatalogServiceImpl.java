package com.catalog_service.service;

import com.catalog_service.client.InventoryClient;
import com.catalog_service.dto.request.ItemRequest;
import com.catalog_service.dto.response.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final InventoryClient inventoryClient;

    public CatalogServiceImpl(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @Override
    public List<ItemResponse> getProducts() {
        return inventoryClient.getProducts();
    }

    @Override
    public List<ItemResponse> getProductsByCategory(String category) {
        return inventoryClient.getProductsByCategory(category);
    }

    @Override
    public ItemResponse receiveNewShipment(ItemRequest request) {
        return inventoryClient.receiveNewShipment(request);
    }
}
