package DAL;

import Model.PreOrder;
import com.sun.jdi.connect.spi.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreOrderDAO extends DBConnect {

    public PreOrderDAO() {
        super();
    }

    public void addPreOrder2(int tableID, String name, String email, String phone, Date bookTime) {
        String query = "INSERT INTO `isp392`.`preordertable` (`TableID`, `Name`, `Email`, `Phone`, `Book_time`) VALUES (?,?,?,?,?);";

        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
            preparedStatement.setInt(1, tableID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setDate(5, new java.sql.Date(bookTime.getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Phương thức thêm bàn vào cơ sở dữ liệu
    // Phương thức thêm bàn vào cơ sở dữ liệu
//    public void addTable(String tableName, int numberOfPeople) throws SQLException {
//        String query = "INSERT INTO `isp392`.`table` (`Name`, `NumberOfPeople`) VALUES (?,?);";
//        
//        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
//            preparedStatement.setString(1, tableName);
//            preparedStatement.setInt(2, numberOfPeople);
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
//    public void addPreOrder(int tableID, String name, String email, String phone, Date bookTime) throws SQLException {
//        String query = "INSERT INTO preorders (table_id, name, email, phone, book_time) VALUES (?, ?, ?, ?, ?)";
//
//        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
//            preparedStatement.setInt(1, tableID);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, email);
//            preparedStatement.setString(4, phone);
//            preparedStatement.setDate(5, new java.sql.Date(bookTime.getTime()));
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }
//
//    public List<PreOrder> getAllPreOrders() throws SQLException {
//        List<PreOrder> preOrders = new ArrayList<>();
//        String query = "SELECT * FROM preorders";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
//            while (resultSet.next()) {
//                PreOrder preOrder = new PreOrder();
//                preOrder.setPreOrderID(resultSet.getInt("pre_order_id"));
//                preOrder.setTableID(resultSet.getInt("table_id"));
//                preOrder.setName(resultSet.getString("name"));
//                preOrder.setEmail(resultSet.getString("email"));
//                preOrder.setPhone(resultSet.getString("phone"));
//                preOrder.setBookTime(resultSet.getDate("book_time"));
//                preOrders.add(preOrder);
//            }
//        }
//        return preOrders;
//    }
//    
    public List<PreOrder> getAllPreOrders() {
        List<PreOrder> preOrders = new ArrayList<>();
        String query = "SELECT * FROM `preordertable`"; 

        try (PreparedStatement statement = cnn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int preOrderID = resultSet.getInt("PreOrderID");
                int tableID = resultSet.getInt("TableID");
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                Timestamp bookDate = resultSet.getTimestamp("Book_time");
                int numberOfPeople = resultSet.getInt("NumberOfPeople");
                int status = resultSet.getInt("status");
                PreOrder preOrder = new PreOrder(preOrderID, tableID, name, phone, email, bookDate, numberOfPeople, status);
                preOrders.add(preOrder);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi truy vấn đơn đặt bàn: " + e.getMessage());
        }

        return preOrders;
    }
    
    public PreOrder getPreOrderById(int preOrderID) {
        String query = "SELECT * FROM `preordertable` WHERE `PreOrderID` = ?";
        PreOrder preOrder = null;

        try (PreparedStatement statement = cnn.prepareStatement(query)) {
            statement.setInt(1, preOrderID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int tableID = resultSet.getInt("TableID");
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                Timestamp bookDate = resultSet.getTimestamp("Book_time");
                int numberOfPeople = resultSet.getInt("NumberOfPeople");
                int status = resultSet.getInt("status");
                preOrder = new PreOrder(preOrderID, tableID, name, phone, email, bookDate, numberOfPeople, status);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi truy vấn đơn đặt bàn theo ID: " + e.getMessage());
        }

        return preOrder;
    }
    
    public boolean updatePreOrder(PreOrder preOrder) {
        String query = "UPDATE `preordertable` SET `TableID` = ?, `Name` = ?, `Email` = ?, `Phone` = ?, `Book_time` = ?, `NumberOfPeople` = ?, `status` = ? WHERE `PreOrderID` = ?";
        boolean rowUpdated = false;

        try (PreparedStatement statement = cnn.prepareStatement(query)) {
            statement.setInt(1, preOrder.getTableID());
            statement.setString(2, preOrder.getName());
            statement.setString(3, preOrder.getEmail());
            statement.setString(4, preOrder.getPhone());
            statement.setTimestamp(5, preOrder.getBookDate());
            statement.setInt(6, preOrder.getNumberOfPeople());
            statement.setInt(7, preOrder.getStatus());
            statement.setInt(8, preOrder.getPreOrderID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật đơn đặt bàn: " + e.getMessage());
        }

        return rowUpdated;
    }
    
    public boolean updateStatusPreOrder(int status, int id) {
        String query = "UPDATE `preordertable` SET `status` = ? WHERE `PreOrderID` = ?";
        boolean rowUpdated = false;

        try (PreparedStatement statement = cnn.prepareStatement(query)) {
            statement.setInt(1, status);
            statement.setInt(2, id);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật đơn đặt bàn: " + e.getMessage());
        }
        return rowUpdated;
    }

    public int createPreOrder(PreOrder preOrder) {
        String query = "INSERT INTO preordertable (name, phone, email, Book_time, numberOfPeople, status) VALUES (?, ?, ?, ?, ?, ?)";
        int preOrderId = -1;
        try (PreparedStatement statement = cnn.prepareStatement(query)) {
            int index = 1;
            statement.setString(index++, preOrder.getName());
            statement.setString(index++, preOrder.getPhone());
            statement.setString(index++, preOrder.getEmail());
            statement.setTimestamp(index++, preOrder.getBookDate());
            statement.setInt(index++, preOrder.getNumberOfPeople());
            statement.setInt(index++, preOrder.getStatus());
            int affectedRows = statement.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            System.out.println("Add new preorder: " + e);
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        try {
            PreOrderDAO dao = new PreOrderDAO();

            // Retrieve all pre-orders
            List<PreOrder> preOrders = dao.getAllPreOrders();

            // Display or process retrieved pre-orders
            for (PreOrder preOrder : preOrders) {
                System.out.println(preOrder);
            }

        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception properly
        }
    }
}
