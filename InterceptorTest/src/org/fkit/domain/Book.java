package org.fkit.domain;

import java.io.Serializable;

/**
 * Created by Ray on 2017/3/10.
 */
public class Book implements Serializable {
    private String name;
    private String author;
    private double money;

    public Book(String name, String author, double money) {
        this.name = name;
        this.author = author;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
