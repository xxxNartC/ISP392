/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author maingocdat
 */
public class dish {
    private int DishID;
    private String Name;
    private int Price;
    private String Description;
    private String DishType;
    private String image;

    public dish() {
    }

    public dish(String Name, int Price, String Description, String DishType, String image) {
        this.Name = Name;
        this.Price = Price;
        this.Description = Description;
        this.DishType = DishType;
        this.image = image;
    }

    public dish(int DishID, String Name, int Price, String Description, String DishType, String image) {
        this.DishID = DishID;
        this.Name = Name;
        this.Price = Price;
        this.Description = Description;
        this.DishType = DishType;
        this.image = image;
    }

    public int getDishID() {
        return DishID;
    }

    public void setDishID(int DishID) {
        this.DishID = DishID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDishType() {
        return DishType;
    }

    public void setDishType(String DishType) {
        this.DishType = DishType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
