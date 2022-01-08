package com.example.demo.Form;

public class BankMany {
    private String id;
    private double payment ;
    private String password;

    public BankMany(String id, double payment, String password) {
        this.id = id;
        this.payment = payment;
        this.password = password;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}