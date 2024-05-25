/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.dish;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maingocdat
 */
public class DishDao extends DBConnect {

    public List<dish> getAllDishs() throws SQLException {
        List<dish> dishs = new ArrayList<>();
        String query = "SELECT * FROM dish";
        try (PreparedStatement statement = cnn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                dishs.add(new dish(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }
        }
        return dishs;
    }

    public static void main(String[] args) throws SQLException {

        DishDao dao = new DishDao();
        List<dish> dishes = dao.getAllDishs();
        System.out.println(dishes.get(0).getName());
    }
}
