package com.example.demo.Form;

public class WithdrewForm {
    private String id;
    private double withdrewAmount;

    public WithdrewForm(String id, double withdrewAmount) {
        this.id = id;
        this.withdrewAmount = withdrewAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWithdrewAmount() {
        return withdrewAmount;
    }

    public void setWithdrewAmount(double withdrewAmount) {
        this.withdrewAmount = withdrewAmount;
    }
}
