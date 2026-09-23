package com.zaidi;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    static DatabaseConnection database;

    // 🔹 SETUP: runs ONCE before ALL database tests
    @BeforeAll
    static void connectDatabase() throws SQLException {

        database = new DatabaseConnection();

        // 🔹 ACT: open database connection
        database.connect();
    }

    // 🔹 TEST: database connection should be created successfully
    @Test
    void shouldConnectToDatabase() throws SQLException {

        // 🔹 ASSERT: connection object should exist
        assertNotNull(database.getConnection());

        // 🔹 ASSERT: connection should NOT be closed
        assertFalse(database.getConnection().isClosed());
    }

    // 🔹 CLEANUP: runs ONCE after ALL database tests
    @AfterAll
    static void closeDatabase() throws SQLException {

        // 🔹 CLEANUP: close database connection
        database.close();
    }
}