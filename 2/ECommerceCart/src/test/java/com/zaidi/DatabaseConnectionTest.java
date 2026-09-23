package com.zaidi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    static DatabaseConnection database;

    // 🔹 SETUP: runs ONCE before ALL tests
    @BeforeAll
    static void connectDatabase() throws SQLException {

        database = new DatabaseConnection();

        // 🔹 ACT: Open database connection
        database.connect();

        // 🔹 ACT: Create products table
        String sql = """
                CREATE TABLE products (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100),
                    price DOUBLE,
                    stock INT
                )
                """;

        try (Statement statement = database.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    // 🔹 TEST: Database connection should work
    @Test
    void shouldConnectToDatabase() throws SQLException {

        // 🔹 ASSERT: Connection object should exist
        assertNotNull(database.getConnection());

        // 🔹 ASSERT: Connection should be open
        assertFalse(database.getConnection().isClosed());
    }

    // 🔹 TEST: Product should be inserted into database
    @Test
    void shouldInsertProduct() throws SQLException {

        // 🔹 ARRANGE: SQL INSERT query
        String sql = """
                INSERT INTO products(name, price, stock)
                VALUES (?, ?, ?)
                """;

        // 🔹 ACT: Insert product
        try (PreparedStatement statement =
                     database.getConnection().prepareStatement(sql)) {

            statement.setString(1, "Laptop");
            statement.setDouble(2, 60000);
            statement.setInt(3, 5);

            int rowsInserted = statement.executeUpdate();

            // 🔹 ASSERT: One row should be inserted
            assertEquals(1, rowsInserted);
        }
    }

    // 🔹 TEST: Product should be found in database
    @Test
    void shouldFindProduct() throws SQLException {

        // 🔹 ARRANGE: SQL SELECT query
        String sql = """
                SELECT * FROM products
                WHERE name = ?
                """;

        // 🔹 ACT: Search for product
        try (PreparedStatement statement =
                     database.getConnection().prepareStatement(sql)) {

            statement.setString(1, "Laptop");

            try (ResultSet result = statement.executeQuery()) {

                // 🔹 ASSERT: Product should exist
                assertTrue(result.next());

                // 🔹 ASSERT: Check product data
                assertEquals("Laptop", result.getString("name"));
                assertEquals(60000, result.getDouble("price"));
                assertEquals(5, result.getInt("stock"));
            }
        }
    }

    // 🔹 CLEANUP: runs ONCE after ALL tests
    @AfterAll
    static void closeDatabase() throws SQLException {

        // 🔹 CLEANUP: Delete the test table
        String sql = "DROP TABLE products";

        try (Statement statement = database.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        }

        // 🔹 CLEANUP: Close database connection
        database.close();
    }
}