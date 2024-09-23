package com.pogorelov.top.employee.classes;

public class Employee {
    private final String fullName;
    private Payment payment;
    private Boolean hasChild;
    private Boolean inOffshore;

    public Employee(String fullName, Boolean hasChild) {
        this.fullName = fullName;
        this.hasChild = hasChild;
        this.inOffshore = false;
    }

    public String getFullName() {

        return fullName;
    }

    public Payment getPayment() {

        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        payment.setEmployee(this);
    }

    public Boolean getHasChild() {

        return hasChild;
    }

    public Boolean getInOffshore() {
        return inOffshore;
    }

    public void setInOffshore(Boolean inOffshore) {
        this.inOffshore = inOffshore;
    }

}
