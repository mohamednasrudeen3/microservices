package com.alibou.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
         String id,

         @NotNull(message = "Customer FirstName is Required")
         String firstName,

         @NotNull(message="Customer lastname is required")
         String lastName,

         @NotNull(message = "Customer Email is Required")
         @Email(message = "Customer email is not a valid email Address")
         String email,

         Address address
) {
}
