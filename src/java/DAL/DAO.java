/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Account;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAO extends DBConnect {

    public DAO() {
        super();
    }

    public Account getAccountByUsername(String username, String password) {
        Account a = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            Connection conn = this.getConnection();
            if (conn == null) {
                throw new SQLException("Database connection is null");
            }

            String strSql = "SELECT * FROM isp392_new.account WHERE Username = ? AND Password = ?";
            stm = conn.prepareStatement(strSql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();

            if (rs.next()) {
                String ID = rs.getString(1);
                String acc = rs.getString(2);
                String pass = rs.getString(3);
                String type = rs.getString(4);
                String userInfoId = rs.getString(5);
                a = new Account(ID, acc, pass, type, userInfoId);
                System.out.println("success");
                return a;
            }
        } catch (SQLException e) {
            System.out.println("getUsers: " + e.getMessage());
        }

        return null;
    }

    public boolean updateUser(Account user) {
        String query = "UPDATE isp392_new.account SET Username = ?, Password = ?, AccountType = ?, UserInfoID = ? WHERE AccountID = ?";
        try (Connection conn = this.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAccountType());

            // Assuming UserInfoID is an integer
            ps.setInt(4, Integer.parseInt(user.getUserInfoId()));

            ps.setString(5, user.getAccountID());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid UserInfoID format: " + user.getUserInfoId());
            return false;
        }
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        Account account = d.getAccountByUsername("user0", "1234");
        if (account != null) {
            System.out.println(d.updateUser(account));
        } else {
            System.out.println("Account not found");
        }
    }
}
