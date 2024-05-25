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
                return a;
            }
        } catch (SQLException e) {
            System.out.println("getUsers: " + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        Account account = d.getAccountByUsername("manager", "123");
        System.out.println(account != null ? account.getAccountID() : "Account not found");
    }
}
