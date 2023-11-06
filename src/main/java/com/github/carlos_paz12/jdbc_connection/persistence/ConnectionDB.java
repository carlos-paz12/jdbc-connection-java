package com.github.carlos_paz12.jdbc_connection.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String URL = "jdbc:mysql://{ip_db}:{port_db}/{name_db}";
    private static final String USER = "{user_db}";
    private static final String SENHA = "{password_db}";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;

    public static Connection connect() {
        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, SENHA);
            return connection;

        } catch (ClassNotFoundException e1) {

            System.out.println("Error in " + e1.getMessage());

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void disconnect() {
        try {

            if (connection != null) {

                connection.close();
                connection = null;

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
    }

}
