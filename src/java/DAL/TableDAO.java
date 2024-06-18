/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Table;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chutu
 */
public class TableDAO extends DBConnect {

    public void addTable(Table table) throws SQLException {
        String query = "INSERT INTO restauranttable (TableNumber, Seats, Status) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cnn.prepareStatement(query)){
            ps.setInt(1, table.getTableNumber());
            ps.setInt(2, table.getSeats());
            ps.setString(3, table.getStatus());
            ps.executeUpdate();
        }
    }
    
     public boolean checkTableExists(int tableNumber) throws SQLException {
        String query = "SELECT 1 FROM restauranttable WHERE TableNumber = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, tableNumber);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Returns true if a record is found
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
}
    

