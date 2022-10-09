package com.springGB.springGB.Homework3;

public class Product {
    private static Long amount = 0L;
    private Long id;
    private String title;
    private int price;

    public Product() {
        amount++;
        this.id = amount;
    }

    public Product(String title, int price) {
        amount++;
        this.id = amount;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
