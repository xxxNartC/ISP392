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
        String dishType = "Cocktails";
        List<dish> dishes = dao.getDishesByType(dishType);
        System.out.println(dishes.get(0).getName());
    }
    public List<dish> getDishesByType(String dishType) throws SQLException {
        List<dish> dishes = new ArrayList<>();
        String sql = "SELECT * FROM dish WHERE DishType = ?";
        PreparedStatement statement = cnn.prepareStatement(sql);
        statement.setString(1, dishType);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            dish dish = new dish();
            dish.setDishID(resultSet.getInt("DishID"));
            dish.setName(resultSet.getString("Name"));
            dish.setPrice(resultSet.getInt("Price"));
            dish.setDescription(resultSet.getString("Description"));
            dish.setImage(resultSet.getString("image"));
            dish.setDishType(resultSet.getString("DishType"));
            dishes.add(dish);
        }

        resultSet.close();
        statement.close();
        return dishes;
    }
}


