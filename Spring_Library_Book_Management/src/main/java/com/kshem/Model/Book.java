package com.kshem.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@NotNull(message="Book Id must be required")
	@Positive(message="Book Id Must be Positive")
	private int bookId;
	
	@NotBlank(message="Book Name must be required")
	@Size(min=3, max=50, message="Book Name must be btw 3 and 50 characters")
	private String bookName;
	
	@NotBlank(message="Author Name is required")
	@Size(min=3, max=50, message="Author Name must be btw 3 and 50 characters")
	private String author;
	
	@Positive(message="Price must be positive")
	private double price;
	
	private boolean available;
}
