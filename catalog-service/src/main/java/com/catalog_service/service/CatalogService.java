package com.catalog_service.service;

import com.catalog_service.dto.request.ItemRequest;
import com.catalog_service.dto.response.ItemResponse;

import java.util.List;

public interface CatalogService {

    List<ItemResponse> getProducts();

    List<ItemResponse> getProductsByCategory(String category);

    ItemResponse receiveNewShipment(ItemRequest request);
}
