package com.example.demo.controller;

public class UserUU {
    private String id;
    private String name;
    private String email;
    private String password;
    private double balance;
    private double loanAmount;

    public UserUU(String id, String name, String email, String password, double balance, double loanAmount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.loanAmount = loanAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

   public double salary(){
        return balance;
   }
   public double addSalary(){
       return balance=balance+balance;
   }

}
