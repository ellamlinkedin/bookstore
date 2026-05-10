package com.example.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookstoreApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book title to search:");
        String title = scanner.nextLine();

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bookstore",
            "admin",
            "password123"
        );

        Statement stmt = conn.createStatement();

        // Intentionally vulnerable SQL query for Semgrep practice
        String query = "SELECT * FROM books WHERE title = '" + title + "'";

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("Book: " + rs.getString("title"));
        }

        rs.close();
        stmt.close();
        conn.close();
        scanner.close();
    }
}
