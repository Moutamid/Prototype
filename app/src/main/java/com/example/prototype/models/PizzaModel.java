package com.example.prototype.models;

import com.example.prototype.models.Extras;

import java.util.ArrayList;

public class PizzaModel {
    int image;
    String name;
    double price;
    ArrayList<Extras> extras;
    int quantity;

    public PizzaModel(int image, String name, double price, ArrayList<Extras> extras) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.extras = extras;
    }

    public PizzaModel(int image, String name, double price, ArrayList<Extras> extras, int quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.extras = extras;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Extras> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<Extras> extras) {
        this.extras = extras;
    }
}
