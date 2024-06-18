package Model;

import java.sql.Timestamp;
import java.util.Date;

public class PreOrder {
    private int preOrderID; // This field will auto-increment
    private int tableID;
    private String name;
    private String phone;
    private String email;
    private Timestamp bookDate;
    private int numberOfPeople;
    private int status;

    public PreOrder() {
    }

    public PreOrder(int preOrderID, int tableID, String name, String phone, String email, Timestamp bookDate, int numberOfPeople, int status) {
        this.preOrderID = preOrderID;
        this.tableID = tableID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bookDate = bookDate;
        this.numberOfPeople = numberOfPeople;
        this.status = status;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBookDate() {
        return bookDate;
    }

    public void setBookDate(Timestamp bookDate) {
        this.bookDate = bookDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
