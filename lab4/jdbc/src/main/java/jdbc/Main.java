package jdbc;

import jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Connection connection = JDBCUtils.getNewConnection()) {
            JDBCUtils.createTable(connection);
            JDBCUtils.clearTable(connection);

            Scanner console = new Scanner(System.in);

            System.out.println("Enter the initial number of products: ");
            int n = console.nextInt();

            int cost;
            int prodid;
            String title;
            for (int i = 1; i <= n; ++i) {
                System.out.println("Enter prodid title price");
                prodid = console.nextInt();
                title = console.next();
                cost = console.nextInt();
                JDBCUtils.addProduct(connection, prodid, title, cost);
            }

            while(console.hasNext()) {
                String command = console.next();
                JDBCUtils.executeCommand(connection, command, console);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
