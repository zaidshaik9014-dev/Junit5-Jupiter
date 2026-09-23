package com.zaidi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    private ShoppingCart cart;

    // 🔹 SETUP: Create a fresh cart before EVERY test
    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    // 🔹 TEST: Product can be added to cart
    @Test
    void testAddProduct() {

        // Arrange: Create product
        Product laptop = new Product("Laptop", 60000, 5);

        // Act: Add product to cart
        cart.addProduct(laptop);

        // Assert: Cart should contain 1 product
        assertEquals(1, cart.getItemCount());
    }

    // 🔹 TEST: Cart calculates total price correctly
    @Test
    void testCalculateTotal() {

        // Arrange: Create products
        Product laptop = new Product("Laptop", 60000, 5);
        Product mouse = new Product("Mouse", 1000, 10);

        // Act: Add products to cart
        cart.addProduct(laptop);
        cart.addProduct(mouse);

        // Assert: Total should be 61000
        assertEquals(61000, cart.getTotal());
    }

    // 🔹 TEST: Product can be removed from cart
    @Test
    void testRemoveProduct() {

        // Arrange: Create product
        Product laptop = new Product("Laptop", 60000, 5);

        // Act: Add product first
        cart.addProduct(laptop);

        // Assert: Product was added
        assertEquals(1, cart.getItemCount());

        // Act: Remove product
        cart.removeProduct(laptop);

        // Assert: Cart should now be empty
        assertEquals(0, cart.getItemCount());
    }
}