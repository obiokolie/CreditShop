package com.obiokolie;

/**
 *
 * @author Obinna Okolie
 */
public class Cart {

    private String pID;
    private String pName;
    private int pPrice;
    private int quantity;
    
    //Class Constructor
    public Cart(String pID, String pName, int pPrice, int quantity) {
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.quantity = quantity;
    }

    //Getters and Setters
    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
