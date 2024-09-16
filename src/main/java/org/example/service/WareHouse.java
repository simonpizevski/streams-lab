package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void modifyProduct() {}

    public List<Product> getAllProducts() {
        return List.copyOf(products);
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public void getProductByCategory(Category category) {}

    public void getProductsByDate(LocalDate date) {}

    public void getModifiedProducts() {}

}
