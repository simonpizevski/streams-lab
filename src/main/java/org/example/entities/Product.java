package org.example.entities;

import java.time.LocalDate;

public record Product (
     int id,
     String name,
     Category category,
     int rating,
     LocalDate createdDate,
     LocalDate modifiedDate
     ) {
    public Product {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("rating must be between 0 and 10");
        }
    }
}
