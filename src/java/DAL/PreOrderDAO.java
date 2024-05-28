package DAL;

import Model.PreOrder;
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
}
