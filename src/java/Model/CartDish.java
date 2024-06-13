/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class CartDish {
    private dish dishs;
    private int quanlity;

    public CartDish() {
    }

    public CartDish(dish dishs, int quanlity) {
        this.dishs = dishs;
        this.quanlity = quanlity;
    }

    public dish getDishs() {
        return dishs;
    }

    public void setDishs(dish dishs) {
        this.dishs = dishs;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }
    
}
