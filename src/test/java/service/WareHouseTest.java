package service;

import net.bytebuddy.asm.Advice;
import org.example.entities.Category;
import org.example.entities.Product;
import org.example.service.WareHouse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


}
