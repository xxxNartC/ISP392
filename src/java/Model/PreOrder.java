package Model;

import java.util.Date;

public class PreOrder {
    private int preOrderID; // Trường này sẽ tự động tăng
    private int tableID;
    private String name;
    private String email;
    private String phone;
    private Date bookTime;
    private int Adults;
    private int Children;
    
    
    // Constructors
    public PreOrder() {
    }

    public PreOrder(int preOrderID, String name, String email, String phone, Date bookTime, int Adults, int Children) {
        this.preOrderID = preOrderID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bookTime = bookTime;
        this.Adults = Adults;
        this.Children = Children;
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

    public int getAdults() {
        return Adults;
    }

    public void setAdults(int Adults) {
        this.Adults = Adults;
    }

    public int getChildren() {
        return Children;
    }

    public void setChildren(int Children) {
        this.Children = Children;
    }

    


    
}
