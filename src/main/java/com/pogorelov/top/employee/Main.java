package com.pogorelov.top.employee;

import com.pogorelov.top.employee.classes.Company;
import com.pogorelov.top.employee.classes.Employee;
import com.pogorelov.top.employee.classes.Payment;
import com.pogorelov.top.employee.classes.PaymentType;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Путин Владимир Владимирович", true);
        Employee employee2 = new Employee("Пьеха Эдита Станиславовна", false);
        Employee employee3 = new Employee("Иванов Егор Екатеринович", false);
        Employee employee4 = new Employee("Джойли Анженина Иванона", true);
        Employee employee5 = new Employee("Чан Джекки Николаевич", true);

        Company company = new Company();

        employee1.setPayment(new Payment((PaymentType.SALARY), 26, 3000));
        employee2.setPayment(new Payment((PaymentType.SALARY),21,3000 ));
        employee3.setPayment(new Payment((PaymentType.WAGE), 205, 600));
        employee4.setPayment(new Payment((PaymentType.WAGE), 120, 600));
        employee5.setPayment(new Payment((PaymentType.FEE),3,10000 ));

        company.getEmployees().add(employee1);
        company.getEmployees().add(employee2);
        company.getEmployees().add(employee3);
        company.getEmployees().add(employee4);
        company.getEmployees().add(employee5);

        employee2.setInOffshore(true);
        employee4.setInOffshore(true);

        company.printReport();
        System.out.println();
    }
}
