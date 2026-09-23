package com.zaidi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;

    public void connect() throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:h2:mem:shopdb",
                "sa",
                ""
        );

        System.out.println("Database connected");
    }

    public void close() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}