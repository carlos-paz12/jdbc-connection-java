package com.github.carlos_paz12.jdbc_connection.persistence;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.carlos_paz12.jdbc_connection.entity.User;

public class UserDAO {

    public boolean create(User u) {
        boolean result = false;

        Connection connection = ConnectionDB.connect();
        String query = "INSERT INTO tb_user (email, password) VALUES (?, ?);";

        try {

            PreparedStatement command = connection.prepareStatement(query);

            command.setString(1, u.getEmail());
            command.setString(2, u.getPassword());

            int rowsAffected = command.executeUpdate();

            if (rowsAffected > 0) {

                result = true;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            ConnectionDB.disconnect();

        }

        return result;
    }

    public User retrieve(String email) {
        User u = null;
        Connection connection = ConnectionDB.connect();
        String query = "SELECT tb_user.* FROM tb_user WHERE tb_user.email = ?;";

        try {

            PreparedStatement command = connection.prepareStatement(query);
            command.setString(1, email);

            ResultSet resultSet = command.executeQuery();

            if (resultSet.next()) {

                u = new User();
                u.setId(resultSet.getLong("id"));
                u.setEmail(resultSet.getString("email"));
                u.setPassword(resultSet.getString("password"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            ConnectionDB.disconnect();

        }

        return u;
    }

}
