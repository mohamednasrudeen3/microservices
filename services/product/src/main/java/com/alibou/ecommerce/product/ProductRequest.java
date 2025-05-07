package com.alibou.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,

        @NotNull(message = "Product name is Required")
        String name,

        @NotNull(message="Product description is required")
        String description,

        @Positive(message="Available Quantity should be positive")
        double availableQuantity,

        @Positive(message="Price should be positive")
        BigDecimal price,

        @NotNull(message="Category is Required")
        Integer categoryId
) {
}
