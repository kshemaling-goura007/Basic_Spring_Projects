package com.kshem.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	   @Positive(message = "Product ID must be greater than zero")
       private int productId;

      @NotBlank(message = "Product name is mandatory")
      @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
       private String productName;

      @NotBlank(message = "Category is mandatory")
      private String category;

      @Min(value = 0, message = "Stock cannot be negative")
      private int stock;

      @Positive(message = "Price should be greater than zero")
      private double price;
}

