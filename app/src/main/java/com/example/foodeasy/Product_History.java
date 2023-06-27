package com.example.foodeasy;

public class Product_History {
    private String name;
   private int id,count;
   private double price,total_amt;

    public Product_History(String name, int id,int count,double price,double total_amt) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.price = price;
        this.total_amt = total_amt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
