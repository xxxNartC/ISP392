/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Chef;
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
                        resultSet.getString(6),
                        resultSet.getInt(7)
                ));
            }
        }
        return dishs;
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
            dish.setQuantity(resultSet.getInt("Quantity"));
            dishes.add(dish);
        }

        resultSet.close();
        statement.close();
        return dishes;
    }

    public List<dish> getDishesByID(int DishID) throws SQLException {
        List<dish> dishes = new ArrayList<>();
        String sql = "SELECT * FROM isp392.dish where dish.DishID =?";
        PreparedStatement statement = cnn.prepareStatement(sql);
        statement.setInt(1, DishID);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            dish dish = new dish();
            dish.setDishID(resultSet.getInt("DishID"));
            dish.setName(resultSet.getString("Name"));
            dish.setPrice(resultSet.getInt("Price"));
            dish.setDescription(resultSet.getString("Description"));
            dish.setImage(resultSet.getString("image"));
            dish.setDishType(resultSet.getString("DishType"));
            dish.setQuantity(resultSet.getInt("Quantity"));
            dishes.add(dish);
        }

        resultSet.close();
        statement.close();
        return dishes;
    }

    public dish getDishesByID1(int DishID) {
        dish c = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;

        try {

            String strSql = "SELECT * FROM isp392.dish where dish.DishID =?";
            stm = cnn.prepareStatement(strSql);
            stm.setInt(1, DishID);

            resultSet = stm.executeQuery();

            if (resultSet.next()) {

                c = new dish(resultSet.getInt("DishID"), 
                        resultSet.getString("Name"),
                        resultSet.getInt("Price"),
                        resultSet.getString("Description"),
                        resultSet.getString("DishType"),
                         resultSet.getString("image"),
                        resultSet.getInt("Quantity"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("getUsers: " + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) throws SQLException {

        DishDao dao = new DishDao();

        dish newDish = new dish(0, "Spaghetti", 0, "Delicious Italian pasta", "Main Course", "spaghetti.jpg", 1);
        String dishType = "Main Course";
        // Thêm món ăn vào cơ sở dữ liệu và kiểm tra xem thêm có thành công hay không
        dish dishes = dao.getDishesByID1(17);
        System.out.println(dishes.getName());
    }

    public void addDish(dish dish) throws SQLException {
        String query = "INSERT INTO dish (Name, Description, Price, DishType, image) VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = cnn.prepareStatement(query)) {
            statement.setString(1, dish.getName());
            statement.setString(2, dish.getDescription());
            statement.setInt(3, dish.getPrice());
            statement.setString(4, dish.getDishType());
            statement.setString(5, dish.getImage());
            statement.setInt(5, dish.getQuantity());

            statement.executeUpdate();
        }
    }

}
