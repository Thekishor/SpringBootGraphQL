package com.catalog_service.client;

import com.catalog_service.dto.request.ItemRequest;
import com.catalog_service.dto.response.ItemResponse;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryClient {

    private final HttpGraphQlClient graphQlClient;

    public InventoryClient(HttpGraphQlClient graphQlClient) {
        this.graphQlClient = graphQlClient;
    }


    public List<ItemResponse> getProducts() {
        String graphQlQuery = """
                query GetProducts {
                    getProducts {
                        name
                        price
                    }
                }
                """;
        return graphQlClient.document(graphQlQuery)
                .retrieve("getProducts")
                .toEntityList(ItemResponse.class).block();
    }

    public List<ItemResponse> getProductsByCategory(String category) {
        String graphQlQuery = String.format("""
                query GetProductByCategory {
                    getProductByCategory(category: "%s") {
                        name
                        category
                        price
                        stock
                    }
                }
                """, category);
        return graphQlClient.document(graphQlQuery)
                .retrieve("getProductByCategory")
                .toEntityList(ItemResponse.class).block();
    }

    public ItemResponse receiveNewShipment(ItemRequest request) {
        String graphQlQuery = String.format("""
                mutation ReceiveNewShipment {
                    receiveNewShipment(productId: %s, quantity: %d) {
                        name
                        category
                        price
                        stock
                    }
                }
                """, request.getProductId(), request.getQuantity());
        return graphQlClient.document(graphQlQuery)
                .retrieve("receiveNewShipment")
                .toEntity(ItemResponse.class).block();
    }
}
