/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Chef;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ACER
 */
public class ChefDAO extends DBConnect{ 
        public List<Chef> getAllChef() throws SQLException {
        List<Chef> chefs = new ArrayList<>();
        String query = "SELECT Name, Role FROM isp392.chef;";
        
        try (PreparedStatement statement = cnn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                chefs.add(new Chef(
                    resultSet.getString("Name"), // Ensure the column name is correct
                    resultSet.getString("Role")  // Ensure the column name is correct
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        
        return chefs;
    }


    public static void main(String[] args) {

            try {
                ChefDAO dao = new ChefDAO();
                List<Chef> chef = dao.getAllChef();
                System.out.println(chef.size());
            } catch (SQLException ex) {
                Logger.getLogger(ChefDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

