package jdbc.utils;

import java.sql.*;
import java.util.Scanner;

public class JDBCUtils {
    public static Connection getNewConnection() throws SQLException {
        String DB_URL = "jdbc:h2:/d:/java/lab4/db/database";
        Connection connection = DriverManager.getConnection(DB_URL);

        if (connection.isValid(1)) {
            System.out.println("Connection successful");
        }

        return connection;
    }

    public static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS products(" +
                "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "prodid INT NOT NULL," +
                "title VARCHAR," +
                "cost INT)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.execute();
        }
    }

    public static void clearTable(Connection connection) throws SQLException {
        String sql = "TRUNCATE TABLE products";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.execute();
        }
    }

    public static void executeCommand(Connection connection, String command, Scanner console) throws SQLException {
        switch (command) {
            case ("add"): {
                int prodid = console.nextInt();
                String title = console.next();
                int cost = console.nextInt();
                addProduct(connection, prodid, title, cost);
                break;
            }
            case ("delete"): {
                String title = console.next();
                deleteProduct(connection, title);
                break;
            }
            case ("show_all"): {
                showAllProducts(connection);
                break;
            }
            case ("price"): {
                String title = console.next();
                checkPrice(connection, title);
                break;
            }
            case ("change_price"): {
                String title = console.next();
                int newPrice = console.nextInt();
                changePrice(connection, title, newPrice);
                break;
            }
            case ("filter_by_price"): {
                int start = console.nextInt();
                int end = console.nextInt();
                showDesiredProducts(connection, start, end);
                break;
            }
            default:
                System.out.println("There is no such command");
        }
    }

    public static void addProduct(Connection connection, int prodid, String title, int cost) throws SQLException {
        String check = "SELECT * FROM products WHERE title = ?";
        try(PreparedStatement statement = connection.prepareStatement(check)){
            statement.setString(1, title);

            try(ResultSet rs = statement.executeQuery()) {
                if (!rs.next()) {
                    String sql = "INSERT INTO products (prodid, title, cost) VALUES (?, ?, ?)";
                    try(PreparedStatement st = connection.prepareStatement(sql)){
                        st.setInt(1, prodid);
                        st.setString(2, title);
                        st.setInt(3, cost);
                        st.executeUpdate();
                    }
                } else {
                    System.out.println("The table cannot contain 2 products with the same name");
                }
            }
        }
    }

    public static void deleteProduct(Connection connection, String title) throws SQLException {
        String sql = "DELETE FROM products WHERE title = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, title);
            statement.executeUpdate();
        }
    }

    public static void showAllProducts(Connection connection) throws SQLException {
        String sql = "SELECT * FROM products";
        try(PreparedStatement statement = connection.prepareStatement(sql); ResultSet rs = statement.executeQuery()){
            while (rs.next()) {
                String productName = rs.getString("title");
                int cost = rs.getInt("cost");
                System.out.println(productName + ": " + cost);
            }
        }
    }

    public static void checkPrice(Connection connection, String title) throws SQLException {
        String sql = "SELECT * FROM products WHERE title = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, title);

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String productName = rs.getString("title");
                    int cost = rs.getInt("cost");
                    System.out.println(productName + ": " + cost);
                } else {
                    System.out.println("There is no such product");
                }
            }
        }
    }

    public static void changePrice(Connection connection, String title, int newPrice) throws SQLException {
        String sql = "UPDATE products SET cost = ? WHERE title = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, newPrice);
            statement.setString(2, title);
            statement.executeUpdate();
        }
    }

    public static void showDesiredProducts(Connection connection, int startPrice, int endPrice) throws SQLException {
        String sql = "SELECT * FROM products WHERE cost >= ? AND cost <= ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, startPrice);
            statement.setInt(2, endPrice);

            try(ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String productName = rs.getString("title");
                    int cost = rs.getInt("cost");
                    System.out.println(productName + ": " + cost);
                }
            }
        }
    }
}
