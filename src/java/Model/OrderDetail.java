/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class OrderDetail {
    String OrderTailID,OrderID,DishID,Quanlity,Price,TotalPrice,Quantity;

    public OrderDetail() {
    }

    public OrderDetail(String OrderTailID, String OrderID, String DishID, String Quanlity, String Price, String TotalPrice, String Quantity) {
        this.OrderTailID = OrderTailID;
        this.OrderID = OrderID;
        this.DishID = DishID;
        this.Quanlity = Quanlity;
        this.Price = Price;
        this.TotalPrice = TotalPrice;
        this.Quantity = Quantity;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
    
    

    public String getOrderTailID() {
        return OrderTailID;
    }

    public void setOrderTailID(String OrderTailID) {
        this.OrderTailID = OrderTailID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getDishID() {
        return DishID;
    }

    public void setDishID(String DishID) {
        this.DishID = DishID;
    }

    public String getQuanlity() {
        return Quanlity;
    }

    public void setQuanlity(String Quanlity) {
        this.Quanlity = Quanlity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
    
    
}
