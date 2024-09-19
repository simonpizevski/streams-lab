package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Samsung 65", Category.TV, 5, LocalDate.now(), LocalDate.now()));
        products.add(new Product(2, "Playstation 1", Category.GAMES, 9,LocalDate.now(),LocalDate.now()));
        products.add(new Product(3, "Playstation 2", Category.GAMES, 8,LocalDate.now(),LocalDate.now()));
        products.add(new Product(4, "Playstation 3", Category.GAMES, 5,LocalDate.now(),LocalDate.now()));
        products.add(new Product(5, "Playstation 4", Category.GAMES, 0,LocalDate.now(),LocalDate.now()));

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (true) {
            switch (choice) {
                case 1:

                    break;

                case 2:
                    System.out.println("2");
                    break;

                case 3:
                    System.out.println("3");
                    break;

                default:
                    break;
            }

        }

    }

}
