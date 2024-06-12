package DAL;

import Model.PreOrder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreOrderDAO extends DBConnect {

    public PreOrderDAO() {
        super();
    }

    public void addPreOrder(String name, String phone, Date bookDate, Date time, int numberOfPeople) {
        String query = "INSERT INTO `isp392`.`preordertable` (`Name`, `Phone`, `Book_date`, `Time`, `NumberOfPeople`) VALUES (?,?,?,?,?);";

        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setDate(3, new java.sql.Date(bookDate.getTime()));

            // Convert java.util.Date to java.sql.Time
            long timeInMillis = time.getTime();
            java.sql.Time sqlTime = new java.sql.Time(timeInMillis);
            preparedStatement.setTime(4, sqlTime);

            preparedStatement.setInt(5, numberOfPeople);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

  public List<PreOrder> getPreOrdersByPhone(String phone) throws SQLException {
    List<PreOrder> preOrders = new ArrayList<>();
    String query = "SELECT * FROM isp392.preordertable WHERE Phone = ?";
    try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
        preparedStatement.setString(1, phone);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                PreOrder preOrder = new PreOrder();
                preOrder.setPreOrderID(resultSet.getInt("PreOrderID"));
                preOrder.setTableID(resultSet.getInt("TableID"));
                preOrder.setName(resultSet.getString("Name"));
                preOrder.setPhone(resultSet.getString("Phone"));
                java.sql.Date bookDate = resultSet.getDate("Book_date");
                preOrder.setNumberOfPeople(resultSet.getInt("NumberOfPeople"));
                java.sql.Time bookTime = resultSet.getTime("Time");
                
                // Sử dụng java.util.Date thay vì java.sql.Date và java.sql.Time
                preOrder.setBookDate(new java.util.Date(bookDate.getTime()));
                preOrder.setBookTime((Time) new java.util.Date(bookTime.getTime()));

                preOrders.add(preOrder);
            }
        }
    }
    return preOrders;
}


}


