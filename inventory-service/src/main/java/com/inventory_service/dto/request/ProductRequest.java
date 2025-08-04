package com.inventory_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {

    @NotBlank(message = "Product name cannot be blank")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Product category cannot be blank")
    @Size(min = 2, max = 100, message = "Product category name must be between 2 and 100 characters")
    private String category;

    @Positive(message = "Product price contains positive")
    private Float price;

    @Positive(message = "Product stocks contains positive")
    @NotNull(message = "Product stock cannot be null")
    private Integer stock;
}
