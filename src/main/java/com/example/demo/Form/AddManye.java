package com.example.demo.Form;

public class AddManye {
    private String id;
    private double balance;
    private String password;

    public AddManye(String id, double balance, String password) {
        this.id = id;
        this.balance = balance;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
