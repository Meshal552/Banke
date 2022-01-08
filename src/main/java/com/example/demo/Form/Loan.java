package com.example.demo.Form;

public class Loan {
    private String id;
    private double loanAmount;

    public Loan(String id, double loanAmount) {
        this.id = id;
        this.loanAmount = loanAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
}
