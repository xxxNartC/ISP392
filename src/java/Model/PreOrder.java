package Model;

import java.util.Date;

public class PreOrder {
    private int preOrderID; // Trường này sẽ tự động tăng
    private int tableID;
    private String name;
    private String email;
    private String phone;
    private Date bookTime;
    
    // Constructors
    public PreOrder() {
    }

    public PreOrder(int tableID, String name, String email, String phone, Date bookTime) {
        this.tableID = tableID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bookTime = bookTime;
    }

    // Getters and Setters
    public int getPreOrderID() {
        return preOrderID;
    }

    public void setPreOrderID(int preOrderID) {
        this.preOrderID = preOrderID;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    
}
