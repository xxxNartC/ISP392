package DAL;

import Model.PreOrder;
import com.sun.jdi.connect.spi.Connection;
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

   public List<PreOrder> getAllPreOrders() throws SQLException {
    List<PreOrder> preOrders = new ArrayList<>();
    String query = "SELECT * FROM `preordertable`"; // Đảm bảo đúng tên bảng

    try (PreparedStatement statement = cnn.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int preOrderID = resultSet.getInt("PreOrderID");
            int tableID = resultSet.getInt("TableID");
            String name = resultSet.getString("Name");
            String phone = resultSet.getString("Phone");
            Date bookDate = resultSet.getDate("Book_date");
            int numberOfPeople = resultSet.getInt("NumberOfPeople");
            Date time = resultSet.getDate("Time");
            // Đảm bảo các giá trị lấy từ ResultSet khớp với constructor của PreOrder
            // Constructor PreOrder(int, int, String, String, Date, int, Date)
            PreOrder preOrder = new PreOrder(preOrderID, tableID, name, phone, bookDate, numberOfPeople, time);
            preOrders.add(preOrder);
        }
    } catch (SQLException e) {
        throw new SQLException("Lỗi khi truy vấn đơn đặt bàn: " + e.getMessage());
    }

    return preOrders;
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

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception properly
        }
    }
}


