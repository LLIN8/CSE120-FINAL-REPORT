package com.example.jchen415.mywaytormobileapplication;

import java.util.Vector;

/**
 * Created by liangminglin on 12/10/17.
 */

public class order {

    String foodName;
    int amount;
    double foodPrice;
    double subTotal;

    public String getFoodName() {
        return foodName;
    }

    public int getAmount() {
        return amount;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
