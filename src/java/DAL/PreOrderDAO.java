package DAL;

import Model.PreOrder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreOrderDAO extends DBConnect {

    // Add a new pre-order to the database
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

   public List<PreOrder> searchReservationsByPhone(String phone) {
        List<PreOrder> reservations = new ArrayList<>();

        String query = "SELECT * FROM `isp392`.`preordertable` WHERE `Phone` = ?";

        String query = "SELECT * FROM `isp392`.`preordertable` WHERE `Name` LIKE ? AND `Phone` = ?";


        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
            preparedStatement.setString(1, phone);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PreOrder preOrder = new PreOrder();
                preOrder.setPreOrderID(rs.getInt("PreOrderID"));
                preOrder.setTableID(rs.getInt("TableID"));
                preOrder.setName(rs.getString("Name"));
                preOrder.setPhone(rs.getString("Phone"));
                preOrder.setBookDate(rs.getDate("Book_date"));
                preOrder.setNumberOfPeople(rs.getInt("NumberOfPeople"));
                preOrder.setTime(rs.getTime("Time"));
                reservations.add(preOrder);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reservations;
    }

    // Delete a pre-order by its ID
    public void deletePreOrder(int preOrderID) {
        String query = "DELETE FROM `isp392`.`preordertable` WHERE `PreOrderID` = ?";

        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
            preparedStatement.setInt(1, preOrderID);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Update an existing pre-order
    public void updatePreOrder(PreOrder preOrder) {
        String query = "UPDATE `preordertable` SET `Name`=?, `Phone`=?, `Book_date`=?, `Time`=?, `NumberOfPeople`=? WHERE `PreOrderID`=?";

        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
            preparedStatement.setString(1, preOrder.getName());
            preparedStatement.setString(2, preOrder.getPhone());
            preparedStatement.setDate(3, new java.sql.Date(preOrder.getBookDate().getTime()));

            // Convert java.util.Date to java.sql.Time
            if (preOrder.getTime() != null) {
                long timeInMillis = preOrder.getTime().getTime();
                java.sql.Time sqlTime = new java.sql.Time(timeInMillis);
                preparedStatement.setTime(4, sqlTime);
            } else {
                preparedStatement.setNull(4, java.sql.Types.TIME);
            }

            preparedStatement.setInt(5, preOrder.getNumberOfPeople());
            preparedStatement.setInt(6, preOrder.getPreOrderID());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Retrieve a pre-order by its ID
    public PreOrder getPreOrderById(int preOrderID) {
        String query = "SELECT * FROM `preordertable` WHERE `PreOrderID` = ?";
        try (PreparedStatement preparedStatement = cnn.prepareStatement(query)) {
            preparedStatement.setInt(1, preOrderID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Name");
                String phone = rs.getString("Phone");
                Date bookDate = rs.getDate("Book_date");
                Date time = rs.getTime("Time");
                int numberOfPeople = rs.getInt("NumberOfPeople");
                return new PreOrder(preOrderID, 0, name, phone, bookDate, numberOfPeople, time); // tableID = 0, adjust as needed
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    // Update the status of a pre-order

    public boolean updateStatusPreOrder(String status, int id) {
        String query = "UPDATE preordertable SET Status = ? WHERE PreOrderID = ?";
        boolean rowUpdated = false;

        try (PreparedStatement statement = cnn.prepareStatement(query)) {
            statement.setString(1, status);
            statement.setInt(2, id);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error updating pre-order status: " + e.getMessage());
        }
        return rowUpdated;
    }


    // Create a new pre-order and return the generated ID
    public int createPreOrder(PreOrder preOrder) {
        String query = "INSERT INTO preordertable (Name, Phone, Book_date, Time, NumberOfPeople, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = cnn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

    public int createPreOrder(PreOrder preOrder) {
        String query = "INSERT INTO preordertable (Name, Phone, Book_date, Time, NumberOfPeople, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = cnn.prepareStatement(query)) {

            statement.setString(1, preOrder.getName());
            statement.setString(2, preOrder.getPhone());
            statement.setDate(3, new java.sql.Date(preOrder.getBookDate().getTime()));
            statement.setTime(4, new java.sql.Time(preOrder.getTime().getTime()));
            statement.setInt(5, preOrder.getNumberOfPeople());
            statement.setString(6, preOrder.getStatus());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating new pre-order: " + e.getMessage());
        }
        return -1;


    }
}
