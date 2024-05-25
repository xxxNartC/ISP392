/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Users {

    String userID, name;
    int phone;
    String address, email;
    Date b_o_d;

    public Users() {
    }

    public Users(String userID, String name, int phone, String address, String email, Date b_o_d) {
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.b_o_d = b_o_d;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getB_o_d() {
        return b_o_d;
    }

    public void setB_o_d(Date b_o_d) {
        this.b_o_d = b_o_d;
    }
    

}
