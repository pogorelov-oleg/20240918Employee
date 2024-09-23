package com.pogorelov.top.employee.classes;

public enum PaymentType {

    SALARY("ставка"), WAGE("часовая"), FEE("сдельная");
    private String name;

    PaymentType(String name) {
        this.name = name;
    }

    public String getRuName() {
        return name;
    }
}