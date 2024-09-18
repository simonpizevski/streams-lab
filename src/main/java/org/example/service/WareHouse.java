package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WareHouse {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void modifyProduct(int id, String newName, Category newCategory, int newRating) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.id() == id) {
                products.set(i, new Product(product.id(), newName, newCategory, newRating,
                        product.createdDate(), LocalDate.now()));
                return;
            }
        }
    }

    public List<Product> getAllProducts() {
        return List.copyOf(products);
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.id() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductByCategory(Category category) {
        return products.stream()
                .filter(product -> product.category() == category)
                .sorted((product1, product2) -> product1.name().compareTo(product2.name()))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByDate(LocalDate date) {
        return products.stream()
                .filter(product -> product.createdDate().isAfter(date))
                .collect(Collectors.toList());
    }

    public List<Product> getModifiedProducts() {
        return products.stream()
                .filter(product -> !product.createdDate().equals(product.modifiedDate()))
                .collect(Collectors.toList());

    }

}
