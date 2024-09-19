package service;

import net.bytebuddy.asm.Advice;
import org.example.entities.Category;
import org.example.entities.Product;
import org.example.service.WareHouse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class WareHouseTest {
    private final WareHouse wareHouse = new WareHouse();

    @Test
    public void testAddProductSuccess() {
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());
        wareHouse.addProduct(product);
        assertEquals(1, wareHouse.getAllProducts().size());
        assertEquals("Test Product", wareHouse.getAllProducts().get(0).name());
    }

    @Test
    public void testAddProductFailureNoName() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product(1, "", Category.TV, 9, LocalDate.now(), LocalDate.now());
            wareHouse.addProduct(product);
        });
    }

    @Test
    public void testAddProductFailureNoCategory() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product(1, "Test Product", null, 5, LocalDate.now(), LocalDate.now());
        });
    }

    @Test
    public void testAddProductFailureNoDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product(1, "Test Product", Category.COMPUTER, 5, null, null);
        });
    }

    @Test
    public void testAddProductFailureNegativeRating() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product(1, "Test Product", Category.COMPUTER, -1, LocalDate.now(), LocalDate.now());
        });
    }

    @Test
    public void testModifiedProductSuccess() {
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());
        wareHouse.addProduct(product);

        wareHouse.modifyProduct(1, "Modified Product", Category.TV, 3);
        Product modifiedProduct = wareHouse.getProductById(1);

        assertEquals("Modified Product", modifiedProduct.name());
        assertEquals(Category.TV, modifiedProduct.category());
    }

    @Test
    public void testGetAllProductsSuccess() {
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());
        Product product1 = new Product(2, "Test Product1", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());

        wareHouse.addProduct(product);
        wareHouse.addProduct(product1);

        assertEquals(2, wareHouse.getAllProducts().size());
    }

    @Test
    public void testGetAllProductsFailure() {
        assertEquals(0, wareHouse.getAllProducts().size());
    }

    @Test
    public void testGetProductByIdSuccess() {
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());
        wareHouse.addProduct(product);

        assertEquals(product, wareHouse.getProductById(1));
    }

    @Test
    public void testGetProductByIdFailure() {
        assertNull(wareHouse.getProductById(23));
    }

    @Test
    public void testGetProductByCategorySuccess() {
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());
        Product product1 = new Product(2, "Test Product1", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());
        wareHouse.addProduct(product);
        wareHouse.addProduct(product1);

        assertEquals(2, wareHouse.getProductByCategory(Category.COMPUTER).size());
    }

    @Test
    public void testGetProductByCategoryFailure() {
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.now(), LocalDate.now());
        wareHouse.addProduct(product);

        assertEquals(0, wareHouse.getProductByCategory(Category.TV).size());
    }

    @Test
    public void testGetProductByDateSuccess() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.of(2024, 2, 1), LocalDate.now());
        Product product1 = new Product(2, "Test Product1", Category.COMPUTER, 5, LocalDate.of(2023, 1, 1), LocalDate.now());

        wareHouse.addProduct(product);
        wareHouse.addProduct(product1);

        assertEquals(1, wareHouse.getProductsByDate(date).size());
    }

    @Test
    public void testGetProductByDateFailure() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.of(2023, 1, 1), LocalDate.now());

        wareHouse.addProduct(product);

        assertEquals(0, wareHouse.getProductsByDate(date).size());
    }

    @Test
    public void testGetModifiedProductsSuccess() {
        Product product = new Product(1, "Test Product", Category.COMPUTER, 5, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1));

        wareHouse.addProduct(product);

        assertEquals(1, wareHouse.getModifiedProducts().size());
    }

    @Test
    public void testGetModifiedProductsFailure() {
        Product product = new Product(1, "Test Product", Category.GAMES, 5, LocalDate.now(), LocalDate.now());
        wareHouse.addProduct(product);

        assertEquals(0, wareHouse.getModifiedProducts().size());
    }








}
