/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Account;
import Model.Users;
import Model.dish;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maingocdat
 */
public class UserDao extends DBConnect {

    public List<Users> getAllUsers() throws SQLException {
        List<Users> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (PreparedStatement statement = cnn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }
        }
        return users;
    }

    public Users getUserById(int id) throws SQLException {
        String query = "SELECT * FROM user WHERE id = ?";
        Users user = null;

        try (PreparedStatement statement = cnn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    String dob = resultSet.getString("dob");

                    user = new Users(id, username, email, phone, address, dob);
                }
            }
        }
        return user;
    }

    public Users getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        Users user = null;

        try (
                PreparedStatement statement = cnn.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    String dob = resultSet.getString("dob");

                    user = new Users(id, name, email, phone, address, dob);
                }
            }
        }
        return user;
    }

    public static void main(String[] args) throws SQLException {
        UserDao d = new UserDao();
//        List<Users> list = new ArrayList<>();
//        list = d.getAllUsers();
        Users u = d.getUserById(1);
        System.out.println(u);
    }

}
