package com.example.foodeasy;

public class Product_History {
    private  String name,date_and_time;
    private  int count;
    private  double total;

    public Product_History(String name, String date_and_time, int count, double total) {
        this.name = name;
        this.date_and_time = date_and_time;
        this.count = count;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(String date_and_time) {
        this.date_and_time = date_and_time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
