package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "zx5DfFXS5Ub6hB";

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
